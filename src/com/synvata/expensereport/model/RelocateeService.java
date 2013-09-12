package com.synvata.expensereport.model;

import java.io.Serializable;

import org.json.JSONObject;

import android.util.Log;

public class RelocateeService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String Name;
	public String GroupName;
	public String Description;
	public String abbr;
	public String ServiceStatus;
	public RelocateeService(){}
	public RelocateeService(JSONObject result)
	{
		processJSON(result);
	}

	private void processJSON(final JSONObject result) {
		try {
			if (result.has("Name")
					&& !result.isNull("Name")) {
				Name = result.getString("Name");
			}
			if (result.has("GroupName") && !result.isNull("GroupName")) {
				GroupName = result.getString("GroupName");
			}
			if (result.has("Description") && !result.isNull("Description")) {
				Description = result.getString("Description");
			}
			if (result.has("abbr") && !result.isNull("abbr")) {
				abbr = result.getString("abbr");
			}
			if (result.has("ServiceStatus") && !result.isNull("ServiceStatus")) {
				ServiceStatus = result.getString("ServiceStatus");
			}
		} catch (Exception e) {
			Log.e("Calss ERExpensePurpose", e.getMessage());
		}
	}
}
