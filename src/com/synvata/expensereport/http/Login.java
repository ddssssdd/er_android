package com.synvata.expensereport.http;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.HttpExecuteGetTask;
import com.synvata.expensereport.base.HttpSettings;
import com.synvata.expensereport.data.DBHelper;
import com.synvata.expensereport.model.Person;
import com.synvata.expensereport.model.Relocatee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Login {
	private Context _context;
	private LoginFinish _callback;
	public Login(Context c){
		_context = c;
	}
	public void getRelocatee(final GetRelocatees callback){
		String url = String.format("users/loginMC?personId=%d", AppSettings.person.PersonID);
		new HttpExecuteGetTask(){
			@Override
			protected void onPostExecute(String result) {				
				processRelocateeResult(result,callback);
			}
		}.execute(url);
	}
	private void processRelocateeResult(final String json,final GetRelocatees callback)
	{
		try
		{
			JSONObject result = new JSONObject(json);
			if (HttpSettings.isSuccessJSON(result)){
				JSONArray list = result.getJSONArray("result");
				AppSettings.relocatees = null;
				AppSettings.relocatees =new ArrayList<Relocatee>();
				for(int i=0;i<list.length();i++)
				{
					JSONObject item =  list.getJSONObject(i);
					Relocatee relocatee = new Relocatee(item);
					AppSettings.relocatees.add(relocatee);
				}
				if (callback!=null){
					callback.relocatees(AppSettings.relocatees);
				}
			}
		}
		catch(Exception e)
		{
			HttpSettings.log(e.getMessage());
			
		}
	}
	public void login(final String username,final String password,final LoginFinish callback)
	{
		_callback = callback;
		String url = String.format("users/login?username=%s&password=%s", username,password);
		new HttpExecuteGetTask(){
			@Override
			protected void onPostExecute(String result) {				
				processResult(result,username,password);
			}
		}.execute(url);		
	}
	private void processResult(final String json,final String username,final String password)
	{
		try
		{
			JSONObject result = new JSONObject(json);
			if (HttpSettings.isSuccessJSON(result)){
				Person p = new Person(result.getJSONObject("result"));
				loginSuccess(username,password,p);
				if (_callback!=null)
				{
					_callback.loginStatus(true, p);
					return;
				}
			}
		}
		catch(Exception e)
		{
			HttpSettings.log(e.getMessage());
			
		}
		if (_callback!=null){
			_callback.loginStatus(false,null);
		}
	}
	private void loginSuccess(final String username,final String password,final Person p)
	{
		AppSettings.isLogin = true;
		AppSettings.person = p;
		logLogin(username,password);
	}
	public void logLogin(final String username,final String password)
	{	
		int id = checkLogin(username);
		DBHelper dbhelper =new DBHelper(_context);		
		SQLiteDatabase db =dbhelper.getWritableDatabase();
		db.beginTransaction();
		try
		{
			if (id==0){			
				db.execSQL("Insert into LoginUser(username,password) values(?,?)", new Object[]{username,password});	
			}else{
				ContentValues cv = new ContentValues();
				cv.put("password", password);
				db.update("LoginUser", cv, "id=?", new String[]{String.valueOf(id)});
			}
		}
		finally
		{
			db.endTransaction();
			db.close();
		}
		
		
	}
	private int checkLogin(final String username){
		DBHelper dbhelper =new DBHelper(_context);		
		SQLiteDatabase db =dbhelper.getReadableDatabase();
		Cursor c = db.rawQuery("select id from LoginUser where username=?",new String[]{username});
		try
		{
			if (c.moveToNext()){
				return c.getInt(0);
			}else{
				return 0;
			}
		}finally
		{
			c.close();
			db.close();
		}
		
	
	}
	public LoginList loginHistroy()
	{
		SQLiteDatabase db = (new DBHelper(_context)).getReadableDatabase();
		Cursor c= db.rawQuery("select username,password from LoginUser order by id desc", null);
		LoginList result = new LoginList();
		try{
			while (c.moveToNext()){
				LoginUser user = new LoginUser();
				user.username = c.getString(0);
				user.password = c.getString(1);
				if (result.lastLoginUser==null){
					result.lastLoginUser = user;
				}
				if (result.list==null){
					result.list = new ArrayList<LoginUser>();
				}
				result.list.add(user);
			}
		return result;
		}finally{
			c.close();
			db.close();
		}
	
	}
	public class LoginList
	{
		public List<LoginUser> list;
		public LoginUser lastLoginUser;
	}
	public class LoginUser
	{
		public String username;
		public String password;
	}
	public interface LoginFinish
	{
		void loginStatus(final boolean isLogin,final Person person);		
	}
	public interface GetRelocatees
	{
		void relocatees(final List<Relocatee> list);
	}
}
