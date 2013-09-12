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
import com.synvata.expensereport.model.ReportStatus;

public class InitReportStatus {
	private Context _context;
	public InitReportStatus(Context c){
		_context = c;
		getDataFromLocal();
		String url = "expenseReports/reportStatus";
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
			db.execSQL("delete from ReportStatus");
			AppSettings.reportStatusList = new ArrayList<ReportStatus>();
			for(int i=0;i<list.length();i++){
				JSONObject item = list.getJSONObject(i);
				ReportStatus rs = new ReportStatus(item);
				AppSettings.reportStatusList.add(rs);
				db.execSQL("insert into ReportStatus(id,description) values(?,?)",new String[]{String.valueOf(rs.ref_ERReportStatusID),rs.Description});
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
		Cursor c = db.rawQuery("select id,description from ReportStatus", null);
		AppSettings.reportStatusList = new ArrayList<ReportStatus>();
		while(c.moveToNext())
		{
			ReportStatus rs = new ReportStatus();
			rs.ref_ERReportStatusID = c.getInt(0);
			rs.Description = c.getString(1);
			AppSettings.reportStatusList.add(rs);
		}
		c.close();
		db.close();
	}

}
