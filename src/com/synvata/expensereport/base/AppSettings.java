package com.synvata.expensereport.base;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.synvata.expensereport.model.Person;
import com.synvata.expensereport.model.Purpose;
import com.synvata.expensereport.model.Relocatee;
import com.synvata.expensereport.model.ReportService;
import com.synvata.expensereport.model.ReportStatus;

public class AppSettings {
	public static boolean isLogin;
	public static int userId;
	public static int relocateeId;
	public static Person person;
	public static List<Relocatee> relocatees;
	public static Relocatee relocatee;
	public static int LOGIN_SUCCESS = 100;
	public static List<ReportStatus> reportStatusList;
	public static List<Purpose> purposeList;
	public static List<ReportService> reportServiceList;
	
	public static void save(Context context)
	{
		SharedPreferences preference =  context.getSharedPreferences("AppSettings", 0);
		Editor editor =preference.edit();
		editor.putBoolean("isLogin", isLogin);
		editor.putInt("userId", userId);
		editor.putInt("relocateeId", relocateeId);
		editor.commit();
	}
	public static void load(Context context)
	{
		SharedPreferences preference =  context.getSharedPreferences("AppSettings", 0);
		isLogin = preference.getBoolean("isLogin", false);
		userId = preference.getInt("userId", 0);
		relocateeId = preference.getInt("relocateeId", 0);
	}
	
}
