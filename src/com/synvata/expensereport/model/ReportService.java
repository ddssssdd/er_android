package com.synvata.expensereport.model;

import java.io.Serializable;
import org.json.JSONObject;

import com.synvata.expensereport.base.AppSettings;

import android.util.Log;

public class ReportService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int ERExpenseserviceID;
	public int ClientTypeID;
	public int ClientID;
	public int EnteredUser;
	public String EnteredDate;
	public int UpdateUser;
	public String UpdateDate;
	public int ParentID;
	public int PolicyID;
	public String Description;
	public int RequireMilage;
	public int Deletable;
	public String IsExcludeClientType;
	public String IsExcludeClient;
	public String IsExcludePolicy;
	public int Owner;

	public ReportService() {
	}

	public ReportService(JSONObject result) {
		processJSON(result);
	}

	private void processJSON(final JSONObject result) {
		try {
			if (result.has("ERExpenseserviceID")
					&& !result.isNull("ERExpenseserviceID")) {
				ERExpenseserviceID = result.getInt("ERExpenseserviceID");
			}
			if (result.has("ClientTypeID") && !result.isNull("ClientTypeID")) {
				ClientTypeID = result.getInt("ClientTypeID");
			}
			if (result.has("ClientID") && !result.isNull("ClientID")) {
				ClientID = result.getInt("ClientID");
			}
			if (result.has("EnteredUser") && !result.isNull("EnteredUser")) {
				EnteredUser = result.getInt("EnteredUser");
			}
			if (result.has("EnteredDate") && !result.isNull("EnteredDate")) {
				EnteredDate = result.getString("EnteredDate");
			}
			if (result.has("UpdateUser") && !result.isNull("UpdateUser")) {
				UpdateUser = result.getInt("UpdateUser");
			}
			if (result.has("UpdateDate") && !result.isNull("UpdateDate")) {
				UpdateDate = result.getString("UpdateDate");
			}
			if (result.has("ParentID") && !result.isNull("ParentID")) {
				ParentID = result.getInt("ParentID");
			}
			if (result.has("PolicyID") && !result.isNull("PolicyID")) {
				PolicyID = result.getInt("PolicyID");
			}
			if (result.has("Description") && !result.isNull("Description")) {
				Description = result.getString("Description");
			}
			if (result.has("RequireMilage") && !result.isNull("RequireMilage")) {
				RequireMilage = result.getInt("RequireMilage");
			}
			if (result.has("Deletable") && !result.isNull("Deletable")) {
				Deletable = result.getInt("Deletable");
			}
			if (result.has("IsExcludeClientType")
					&& !result.isNull("IsExcludeClientType")) {
				IsExcludeClientType = result.getString("IsExcludeClientType");
			}
			if (result.has("IsExcludeClient")
					&& !result.isNull("IsExcludeClient")) {
				IsExcludeClient = result.getString("IsExcludeClient");
			}
			if (result.has("IsExcludePolicy")
					&& !result.isNull("IsExcludePolicy")) {
				IsExcludePolicy = result.getString("IsExcludePolicy");
			}
			if (result.has("Owner") && !result.isNull("Owner")) {
				Owner = result.getInt("Owner");
			}
		} catch (Exception e) {
			Log.e("Calss ERExpenseService", e.getMessage());
		}
	}
	public static ReportService find(int id){
		if (AppSettings.reportServiceList!=null){
			for(int i=0;i<AppSettings.reportServiceList.size();i++)
			{
				if (AppSettings.reportServiceList.get(i).ERExpenseserviceID==id){
					return AppSettings.reportServiceList.get(i);
				}
			}
		}
		return null;
	}
}