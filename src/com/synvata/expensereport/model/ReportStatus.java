package com.synvata.expensereport.model;

import java.io.Serializable;
import org.json.JSONObject;

import com.synvata.expensereport.base.AppSettings;

import android.util.Log;

public class ReportStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int ref_ERReportStatusID;
	public String Description;
	

	public ReportStatus() {
	}

	public ReportStatus(JSONObject result) {
		processJSON(result);
	}

	private void processJSON(final JSONObject result) {
		try {
			if (result.has("ref_ERReportStatusID")
					&& !result.isNull("ref_ERReportStatusID")) {
				ref_ERReportStatusID = result.getInt("ref_ERReportStatusID");
			}
			if (result.has("Description") && !result.isNull("Description")) {
				Description = result.getString("Description");
			}
		} catch (Exception e) {
			Log.e("Calss ref_ERReportStatus", e.getMessage());
		}
	}
	public static ReportStatus find(int id){
		if (AppSettings.reportStatusList!=null){
			for(int i=0;i<AppSettings.reportStatusList.size();i++)
			{
				if (AppSettings.reportStatusList.get(i).ref_ERReportStatusID==id){
					return AppSettings.reportStatusList.get(i);
				}
			}
		}
		return null;
	}
}
