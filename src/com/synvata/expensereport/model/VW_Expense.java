package com.synvata.expensereport.model;

import java.io.Serializable;
import org.json.JSONObject;
import android.util.Log;

public class VW_Expense implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String EntryDate;
	public int ExpenseID;
	public int EntityID;
	public int EntityTypeID;
	public int ExpenseCodeID;
	public String SourceCurrencyCode;
	public int CompanyID;
	public String GrossUpDate;
	public int User_ID;
	public int EnteredUser;
	public String PaidDate;
	public String VendorReference;
	public String PRDate;
	public String TargetCurrencyCode;
	public double SourceCurrencyAmount;
	public double SourceConvRate;
	public String ReportDate;
	public String PaidTo;
	public String ReferenceInfo;
	public String ERDetailID;
	public int ExpenseReportID;
	public int AdvanceID;
	public String TransactionNumber;
	public String InvoiceNumber;
	public int PayrollDisbursementsID;
	public int AccountingDisbursementsID;
	public double Amount;
	public int SourceCurrencyID;
	public int InvoiceID;
	public int ExceptionID;
	public String ExceptionDate;
	public double ExceptionAmount;
	public String ExceptionDescription;
	public String ExceptionApprovedBy;
	public String UserCode;
	public int ReportingGroupID;
	public String ExpenseCodeDescription;
	public String ExpenseGroupFullName;
	public String AccountingDisbursementDescription;
	public String AccountingDisbursementCode;
	public String PayrollDisbursementDescription;
	public String PayrollDisbursementCode;
	public String VendorName;
	public String Company;
	public String RelocateeFirstName;
	public String RelocateeLastName;
	public int RelocateeHomeCurrencyID;
	public int RelocateeHostCurrencyID;
	public int ClientHQCurrencyID;
	public String ClientHQCurrencyCode;
	public double NetCheck;
	public String CheckNumber;
	public double EnteredCurrencyAmount;
	public String EnteredCurrencyCode;
	public String AmountCurrencyCode;
	public double HomeCurrencyAmount;
	public String HomeCurrencyCode;
	public double HostCurrencyAmount;
	public String HostCurrencyCode;
	public double HQCurrencyAmount;
	public String HQCurrencyCode;
	public boolean ShowInCC;
	public boolean ShowInMC;

	public VW_Expense() {
	}

	public VW_Expense(JSONObject result) {
		processJSON(result);
	}

	private void processJSON(final JSONObject result) {
		try {
			if (result.has("EntryDate") && !result.isNull("EntryDate")) {
				EntryDate = result.getString("EntryDate");
			}
			if (result.has("ExpenseID") && !result.isNull("ExpenseID")) {
				ExpenseID = result.getInt("ExpenseID");
			}
			if (result.has("EntityID") && !result.isNull("EntityID")) {
				EntityID = result.getInt("EntityID");
			}
			if (result.has("EntityTypeID") && !result.isNull("EntityTypeID")) {
				EntityTypeID = result.getInt("EntityTypeID");
			}
			if (result.has("ExpenseCodeID") && !result.isNull("ExpenseCodeID")) {
				ExpenseCodeID = result.getInt("ExpenseCodeID");
			}
			if (result.has("SourceCurrencyCode")
					&& !result.isNull("SourceCurrencyCode")) {
				SourceCurrencyCode = result.getString("SourceCurrencyCode");
			}
			if (result.has("CompanyID") && !result.isNull("CompanyID")) {
				CompanyID = result.getInt("CompanyID");
			}
			if (result.has("GrossUpDate") && !result.isNull("GrossUpDate")) {
				GrossUpDate = result.getString("GrossUpDate");
			}
			if (result.has("User_ID") && !result.isNull("User_ID")) {
				User_ID = result.getInt("User_ID");
			}
			if (result.has("EnteredUser") && !result.isNull("EnteredUser")) {
				EnteredUser = result.getInt("EnteredUser");
			}
			if (result.has("PaidDate") && !result.isNull("PaidDate")) {
				PaidDate = result.getString("PaidDate");
			}
			if (result.has("VendorReference")
					&& !result.isNull("VendorReference")) {
				VendorReference = result.getString("VendorReference");
			}
			if (result.has("PRDate") && !result.isNull("PRDate")) {
				PRDate = result.getString("PRDate");
			}
			if (result.has("TargetCurrencyCode")
					&& !result.isNull("TargetCurrencyCode")) {
				TargetCurrencyCode = result.getString("TargetCurrencyCode");
			}
			if (result.has("SourceCurrencyAmount")
					&& !result.isNull("SourceCurrencyAmount")) {
				SourceCurrencyAmount = result.getDouble("SourceCurrencyAmount");
			}
			if (result.has("SourceConvRate")
					&& !result.isNull("SourceConvRate")) {
				SourceConvRate = result.getDouble("SourceConvRate");
			}
			if (result.has("ReportDate") && !result.isNull("ReportDate")) {
				ReportDate = result.getString("ReportDate");
			}
			if (result.has("PaidTo") && !result.isNull("PaidTo")) {
				PaidTo = result.getString("PaidTo");
			}
			if (result.has("ReferenceInfo") && !result.isNull("ReferenceInfo")) {
				ReferenceInfo = result.getString("ReferenceInfo");
			}
			if (result.has("ERDetailID") && !result.isNull("ERDetailID")) {
				ERDetailID = result.getString("ERDetailID");
			}
			if (result.has("ExpenseReportID")
					&& !result.isNull("ExpenseReportID")) {
				ExpenseReportID = result.getInt("ExpenseReportID");
			}
			if (result.has("AdvanceID") && !result.isNull("AdvanceID")) {
				AdvanceID = result.getInt("AdvanceID");
			}
			if (result.has("TransactionNumber")
					&& !result.isNull("TransactionNumber")) {
				TransactionNumber = result.getString("TransactionNumber");
			}
			if (result.has("InvoiceNumber") && !result.isNull("InvoiceNumber")) {
				InvoiceNumber = result.getString("InvoiceNumber");
			}
			if (result.has("PayrollDisbursementsID")
					&& !result.isNull("PayrollDisbursementsID")) {
				PayrollDisbursementsID = result
						.getInt("PayrollDisbursementsID");
			}
			if (result.has("AccountingDisbursementsID")
					&& !result.isNull("AccountingDisbursementsID")) {
				AccountingDisbursementsID = result
						.getInt("AccountingDisbursementsID");
			}
			if (result.has("Amount") && !result.isNull("Amount")) {
				Amount = result.getDouble("Amount");
			}
			if (result.has("SourceCurrencyID")
					&& !result.isNull("SourceCurrencyID")) {
				SourceCurrencyID = result.getInt("SourceCurrencyID");
			}
			if (result.has("InvoiceID") && !result.isNull("InvoiceID")) {
				InvoiceID = result.getInt("InvoiceID");
			}
			if (result.has("ExceptionID") && !result.isNull("ExceptionID")) {
				ExceptionID = result.getInt("ExceptionID");
			}
			if (result.has("ExceptionDate") && !result.isNull("ExceptionDate")) {
				ExceptionDate = result.getString("ExceptionDate");
			}
			if (result.has("ExceptionAmount")
					&& !result.isNull("ExceptionAmount")) {
				ExceptionAmount = result.getDouble("ExceptionAmount");
			}
			if (result.has("ExceptionDescription")
					&& !result.isNull("ExceptionDescription")) {
				ExceptionDescription = result.getString("ExceptionDescription");
			}
			if (result.has("ExceptionApprovedBy")
					&& !result.isNull("ExceptionApprovedBy")) {
				ExceptionApprovedBy = result.getString("ExceptionApprovedBy");
			}
			if (result.has("UserCode") && !result.isNull("UserCode")) {
				UserCode = result.getString("UserCode");
			}
			if (result.has("ReportingGroupID")
					&& !result.isNull("ReportingGroupID")) {
				ReportingGroupID = result.getInt("ReportingGroupID");
			}
			if (result.has("ExpenseCodeDescription")
					&& !result.isNull("ExpenseCodeDescription")) {
				ExpenseCodeDescription = result
						.getString("ExpenseCodeDescription");
			}
			if (result.has("ExpenseGroupFullName")
					&& !result.isNull("ExpenseGroupFullName")) {
				ExpenseGroupFullName = result.getString("ExpenseGroupFullName");
			}
			if (result.has("AccountingDisbursementDescription")
					&& !result.isNull("AccountingDisbursementDescription")) {
				AccountingDisbursementDescription = result
						.getString("AccountingDisbursementDescription");
			}
			if (result.has("AccountingDisbursementCode")
					&& !result.isNull("AccountingDisbursementCode")) {
				AccountingDisbursementCode = result
						.getString("AccountingDisbursementCode");
			}
			if (result.has("PayrollDisbursementDescription")
					&& !result.isNull("PayrollDisbursementDescription")) {
				PayrollDisbursementDescription = result
						.getString("PayrollDisbursementDescription");
			}
			if (result.has("PayrollDisbursementCode")
					&& !result.isNull("PayrollDisbursementCode")) {
				PayrollDisbursementCode = result
						.getString("PayrollDisbursementCode");
			}
			if (result.has("VendorName") && !result.isNull("VendorName")) {
				VendorName = result.getString("VendorName");
			}
			if (result.has("Company") && !result.isNull("Company")) {
				Company = result.getString("Company");
			}
			if (result.has("RelocateeFirstName")
					&& !result.isNull("RelocateeFirstName")) {
				RelocateeFirstName = result.getString("RelocateeFirstName");
			}
			if (result.has("RelocateeLastName")
					&& !result.isNull("RelocateeLastName")) {
				RelocateeLastName = result.getString("RelocateeLastName");
			}
			if (result.has("RelocateeHomeCurrencyID")
					&& !result.isNull("RelocateeHomeCurrencyID")) {
				RelocateeHomeCurrencyID = result
						.getInt("RelocateeHomeCurrencyID");
			}
			if (result.has("RelocateeHostCurrencyID")
					&& !result.isNull("RelocateeHostCurrencyID")) {
				RelocateeHostCurrencyID = result
						.getInt("RelocateeHostCurrencyID");
			}
			if (result.has("ClientHQCurrencyID")
					&& !result.isNull("ClientHQCurrencyID")) {
				ClientHQCurrencyID = result.getInt("ClientHQCurrencyID");
			}
			if (result.has("ClientHQCurrencyCode")
					&& !result.isNull("ClientHQCurrencyCode")) {
				ClientHQCurrencyCode = result.getString("ClientHQCurrencyCode");
			}
			if (result.has("NetCheck") && !result.isNull("NetCheck")) {
				NetCheck = result.getDouble("NetCheck");
			}
			if (result.has("CheckNumber") && !result.isNull("CheckNumber")) {
				CheckNumber = result.getString("CheckNumber");
			}
			if (result.has("EnteredCurrencyAmount")
					&& !result.isNull("EnteredCurrencyAmount")) {
				EnteredCurrencyAmount = result
						.getDouble("EnteredCurrencyAmount");
			}
			if (result.has("EnteredCurrencyCode")
					&& !result.isNull("EnteredCurrencyCode")) {
				EnteredCurrencyCode = result.getString("EnteredCurrencyCode");
			}
			if (result.has("AmountCurrencyCode")
					&& !result.isNull("AmountCurrencyCode")) {
				AmountCurrencyCode = result.getString("AmountCurrencyCode");
			}
			if (result.has("HomeCurrencyAmount")
					&& !result.isNull("HomeCurrencyAmount")) {
				HomeCurrencyAmount = result.getDouble("HomeCurrencyAmount");
			}
			if (result.has("HomeCurrencyCode")
					&& !result.isNull("HomeCurrencyCode")) {
				HomeCurrencyCode = result.getString("HomeCurrencyCode");
			}
			if (result.has("HostCurrencyAmount")
					&& !result.isNull("HostCurrencyAmount")) {
				HostCurrencyAmount = result.getDouble("HostCurrencyAmount");
			}
			if (result.has("HostCurrencyCode")
					&& !result.isNull("HostCurrencyCode")) {
				HostCurrencyCode = result.getString("HostCurrencyCode");
			}
			if (result.has("HQCurrencyAmount")
					&& !result.isNull("HQCurrencyAmount")) {
				HQCurrencyAmount = result.getDouble("HQCurrencyAmount");
			}
			if (result.has("HQCurrencyCode")
					&& !result.isNull("HQCurrencyCode")) {
				HQCurrencyCode = result.getString("HQCurrencyCode");
			}
			if (result.has("ShowInCC") && !result.isNull("ShowInCC")) {
				ShowInCC = result.getBoolean("ShowInCC");
			}
			if (result.has("ShowInMC") && !result.isNull("ShowInMC")) {
				ShowInMC = result.getBoolean("ShowInMC");
			}
		} catch (Exception e) {
			Log.e("Calss VW_Expense", e.getMessage());
		}
	}
}