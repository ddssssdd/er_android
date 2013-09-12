package com.synvata.expensereport.init;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.HttpExecuteGetTask;
import com.synvata.expensereport.base.HttpSettings;
import com.synvata.expensereport.data.DBHelper;
import com.synvata.expensereport.model.Purpose;


public class InitPurpose {

	private Context _context;
	public InitPurpose(Context c){
		_context = c;
		getDataFromLocal();
		String url =String.format("expenseReports/purposes?relocateeId=%d",AppSettings.relocateeId);
		new HttpExecuteGetTask(){

			@Override
			protected void onPostExecute(String result) {
				JSONArray list = HttpSettings.getSuccessJSONList(result);
				if (list!=null)
				{
					getDataFromServer(list);
				}
			}
			
		}.execute(url);
	}
	private void getDataFromServer(final JSONArray list)
	{
		SQLiteDatabase db = (new DBHelper(_context)).getWritableDatabase();
		
		db.beginTransaction();
		try
		{
			db.execSQL("delete from Purpose");
			AppSettings.purposeList = new ArrayList<Purpose>();
			for(int i=0;i<list.length();i++){
				JSONObject item = list.getJSONObject(i);
				Purpose obj = new Purpose(item);
				AppSettings.purposeList.add(obj);
				db.execSQL("insert into Purpose(id,description) values(?,?)",new String[]{String.valueOf(obj.ERExpensePurposeID),obj.Description});
			}
			
		}
		catch(Exception e)
		{
			HttpSettings.log(e.getMessage());
		}
		finally{
			db.endTransaction();
			db.close();
		}
		
	}
	
	private void getDataFromLocal()
	{
		SQLiteDatabase db = (new DBHelper(_context)).getReadableDatabase();
		Cursor c = db.rawQuery("select id,description from Purpose", null);
		AppSettings.purposeList = new ArrayList<Purpose>();
		while(c.moveToNext())
		{
			Purpose obj = new Purpose();
			obj.ERExpensePurposeID = c.getInt(0);
			obj.Description = c.getString(1);
			AppSettings.purposeList.add(obj);
		}
		c.close();
		db.close();
	}
}
