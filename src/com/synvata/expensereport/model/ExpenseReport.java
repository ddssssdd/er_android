package com.synvata.expensereport.model;

import java.io.Serializable;
import org.json.JSONObject;
import android.util.Log;

public class ExpenseReport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int ExpenseReportID;
	public int RelocateeID;
	public int ClientID;
	public String Name;
	public String Description;
	public String PeriodBeginDate;
	public String PeriodEndDate;
	public String ReportDate;
	public int PeopleCovered;
	public int ReportStatusID;
	public int PaymentMethodID;
	public int PaymentMethodVerifiedID;
	public int EnteredUser;
	public String EnteredDate;
	public int UpdateUser;
	public String UpdateDate;
	public int UpdateSeqNo;
	public int HowSentID;
	public String RejectReason;
	public String SubmittedDate;
	public int AssignedUser;

	public ExpenseReport() {
	}

	public ExpenseReport(JSONObject result) {
		processJSON(result);
	}

	private void processJSON(final JSONObject result) {
		try {
			if (result.has("ExpenseReportID")
					&& !result.isNull("ExpenseReportID")) {
				ExpenseReportID = result.getInt("ExpenseReportID");
			}
			if (result.has("RelocateeID") && !result.isNull("RelocateeID")) {
				RelocateeID = result.getInt("RelocateeID");
			}
			if (result.has("ClientID") && !result.isNull("ClientID")) {
				ClientID = result.getInt("ClientID");
			}
			if (result.has("Name") && !result.isNull("Name")) {
				Name = result.getString("Name");
			}
			if (result.has("Description") && !result.isNull("Description")) {
				Description = result.getString("Description");
			}
			if (result.has("PeriodBeginDate")
					&& !result.isNull("PeriodBeginDate")) {
				PeriodBeginDate = result.getString("PeriodBeginDate");
			}
			if (result.has("PeriodEndDate") && !result.isNull("PeriodEndDate")) {
				PeriodEndDate = result.getString("PeriodEndDate");
			}
			if (result.has("ReportDate") && !result.isNull("ReportDate")) {
				ReportDate = result.getString("ReportDate");
			}
			if (result.has("PeopleCovered") && !result.isNull("PeopleCovered")) {
				PeopleCovered = result.getInt("PeopleCovered");
			}
			if (result.has("ReportStatusID")
					&& !result.isNull("ReportStatusID")) {
				ReportStatusID = result.getInt("ReportStatusID");
			}
			if (result.has("PaymentMethodID")
					&& !result.isNull("PaymentMethodID")) {
				PaymentMethodID = result.getInt("PaymentMethodID");
			}
			if (result.has("PaymentMethodVerifiedID")
					&& !result.isNull("PaymentMethodVerifiedID")) {
				PaymentMethodVerifiedID = result
						.getInt("PaymentMethodVerifiedID");
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
			if (result.has("UpdateSeqNo") && !result.isNull("UpdateSeqNo")) {
				UpdateSeqNo = result.getInt("UpdateSeqNo");
			}
			if (result.has("HowSentID") && !result.isNull("HowSentID")) {
				HowSentID = result.getInt("HowSentID");
			}
			if (result.has("RejectReason") && !result.isNull("RejectReason")) {
				RejectReason = result.getString("RejectReason");
			}
			if (result.has("SubmittedDate") && !result.isNull("SubmittedDate")) {
				SubmittedDate = result.getString("SubmittedDate");
			}
			if (result.has("AssignedUser") && !result.isNull("AssignedUser")) {
				AssignedUser = result.getInt("AssignedUser");
			}
		} catch (Exception e) {
			Log.e("Calss ExpenseReport", e.getMessage());
		}
	}
}