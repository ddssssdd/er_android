package com.synvata.expensereport.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context){
		super(context,"er.db",null,1);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists LoginUser(id integer primary key autoincrement,username varchar,password varchar)");
		db.execSQL("Create Table if not exists ReportStatus(id integer primary key,description varchar)");
		db.execSQL("Create Table if not exists Purpose(id integer primary key,description varchar)");
		db.execSQL("Create Table if not exists ReportService(id integer primary key,description varchar)");
	
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
	}

}
