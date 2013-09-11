package com.synvata.expensereport.model;

import java.io.Serializable;
import org.json.JSONObject;
import android.util.Log;

public class Relocatee implements Serializable {
	public int PolicyID;
	public int RelocateeID;
	public int UserID;
	public byte CancelFlag;
	public int ClientID;
	public String RelocateeCode;
	public double DestinationPhone;
	public String AlternateNumber;
	public int OriginAddressID;
	public int OriginOfficeAddressID;
	public int InterimAddressID;
	public int DestinationAddressID;
	public int DestinationOfficeAddressID;
	public int OriginPropertyTypeID;
	public int DestinationPropertyTypeID;
	public int RelocateeInfoPhone1;
	public int RelocateeInfoPhone2;
	public int RelocateeInfoPhone3;
	public int RelocateeInfoPhone4;
	public int OriginHomePhone1;
	public int OriginHomePhone2;
	public int OriginHomePhone3;
	public int OriginWorkPhone1;
	public int OriginWorkPhone2;
	public int OriginWorkPhone3;
	public int InterimPhone1;
	public int InterimPhone2;
	public int InterimPhone3;
	public int DestinationHomePhone1;
	public int DestinationHomePhone2;
	public int DestinationHomePhone3;
	public int DestinationWorkPhone1;
	public int DestinationWorkPhone2;
	public int DestinationWorkPhone3;
	public String OriginDepartment;
	public String DestinationDepartment;
	public int SalutationID;
	public String FirstName;
	public String MiddleInitial;
	public String LastName;
	public int StatusID;
	public String StatusDate;
	public String SSN;
	public String EmployeeNbr;
	public String Username;
	public String Password;
	public int eMailID;
	public String InitiationDate;
	public String ExpectedMoveDate;
	public String VacateDate;
	public String JobStartDate;
	public String ProrateDate;
	public String InterimStartDate;
	public String InterimFinishDate;
	public String SpouseFirstName;
	public String SpouseMiddleInitial;
	public String SpouseLastName;
	public String SpouseSSN;
	public int SendMailTo;
	public int CoordinatorID;
	public String CoordAsst;
	public int CoordinatorAsstID;
	public String RequestDestination;
	public String RequestType;
	public int MoveTypeID;
	public String ProgramType;
	public int MoveReasonID;
	public int MoveMiles;
	public int AccommodationID;
	public String SeniorityDate;
	public byte PreviousMoveCount;
	public String ColMultiple;
	public String Title;
	public int CurrencyID;
	public byte Exemptions1040;
	public byte ExemptionsW4;
	public double FICAEarnings;
	public int GrossupToState;
	public String RelocationComplete;
	public int TaxFilingStatusID;
	public int ServiceRepID;
	public String SpecialNeeds;
	public String UrgentInstrctns;
	public int ReferralSourceID;
	public String ReferralOther;
	public String PolicyException;
	public int PreferredCommTypeID;
	public int PreferredCommOptionID;
	public int TypeOfSale;
	public int NewHire;
	public int LoginAttempts;
	public int DefaultVendorMiles;
	public double OrigPurchPrice;
	public int TypeOfProgram;
	public String ClosingCompanyName;
	public String ClosingCompanyAddress1;
	public String ClosingCompanyAddress2;
	public String ClosingCompanyCity;
	public String ClosingCompanyState;
	public String ClosingCompanyPostalCode;
	public String ClosingCompanyCountryCode;
	public int QualifyStatus;
	public int SentToBankOne;
	public int CobrandRemoteUserID;
	public String LastLogin;
	public int EnteredUser;
	public String EnteredDate;
	public int UpdateUser;
	public String UpdateDate;
	public int SentInitLetter;
	public int GlobalContactID;
	public String ReportingDate;
	public String FinalRecDate;
	public String SurveyRespondent;
	public String SurveyComments;
	public int InterviewOverview;
	public int InvoicedInterviewOverview;
	public String FullConversationDate;
	public String ClientNotes;
	public String ClosingCompanyContact;
	public String ClosingCompanyPhone;
	public String ClosingCompanyFax;
	public String ClosingCompanyEmail;
	public String Nickname;
	public String SpouseNickname;
	public int SentToReloviews;
	public int TypeofFile;
	public int GACSAssignmentID;
	public int GACSHostCurrencyID;
	public int GACSHomeCurrencyID;
	public int GACSHQCurrencyID;
	public int CitizenshipPrimaryID;
	public int CitizenshipSecondaryID;
	public String PassportNumber;
	public String PassportIssue;
	public int BirthCountryID;
	public String BirthProvince;
	public String BirthCity;
	public String GeneralLedger;
	public String VendorNumber;
	public String FileNumber;
	public int ExecutiveOfficer;
	public int OriginHomeToOrigOff;
	public int OriginHomeToDeatOff;
	public int GUPPolicyID;
	public int NETPolicyID;
	public String TransferNumber;
	public int PersonID;
	public int AllowDirectDeposit;
	public int BillingRateID;
	public String EffectiveDate;
	public String Canceldate;
	public String Closedate;
	public int UsersID;
	public int HomeCurrencyID;
	public int HostCurrencyID;
	public boolean OverrideMoveMiles;
	public String AlternateContactFirstName;
	public String AlternateContactLastName;
	public String AlternateContactMiddleName;
	public String AlternateContactType;
	public String ReInitiatedDate;

	public Relocatee() {
	}

	public Relocatee(JSONObject result) {
		processJSON(result);
	}

	private void processJSON(final JSONObject result) {
		try {
			if (result.has("PolicyID") && !result.isNull("PolicyID")) {
				PolicyID = result.getInt("PolicyID");
			}
			if (result.has("RelocateeID") && !result.isNull("RelocateeID")) {
				RelocateeID = result.getInt("RelocateeID");
			}
			if (result.has("UserID") && !result.isNull("UserID")) {
				UserID = result.getInt("UserID");
			}
			if (result.has("CancelFlag") && !result.isNull("CancelFlag")) {
				CancelFlag = (byte)result.getInt("CancelFlag");
			}
			if (result.has("ClientID") && !result.isNull("ClientID")) {
				ClientID = result.getInt("ClientID");
			}
			if (result.has("RelocateeCode") && !result.isNull("RelocateeCode")) {
				RelocateeCode = result.getString("RelocateeCode");
			}
			if (result.has("DestinationPhone")
					&& !result.isNull("DestinationPhone")) {
				DestinationPhone = result.getDouble("DestinationPhone");
			}
			if (result.has("AlternateNumber")
					&& !result.isNull("AlternateNumber")) {
				AlternateNumber = result.getString("AlternateNumber");
			}
			if (result.has("OriginAddressID")
					&& !result.isNull("OriginAddressID")) {
				OriginAddressID = result.getInt("OriginAddressID");
			}
			if (result.has("OriginOfficeAddressID")
					&& !result.isNull("OriginOfficeAddressID")) {
				OriginOfficeAddressID = result.getInt("OriginOfficeAddressID");
			}
			if (result.has("InterimAddressID")
					&& !result.isNull("InterimAddressID")) {
				InterimAddressID = result.getInt("InterimAddressID");
			}
			if (result.has("DestinationAddressID")
					&& !result.isNull("DestinationAddressID")) {
				DestinationAddressID = result.getInt("DestinationAddressID");
			}
			if (result.has("DestinationOfficeAddressID")
					&& !result.isNull("DestinationOfficeAddressID")) {
				DestinationOfficeAddressID = result
						.getInt("DestinationOfficeAddressID");
			}
			if (result.has("OriginPropertyTypeID")
					&& !result.isNull("OriginPropertyTypeID")) {
				OriginPropertyTypeID = result.getInt("OriginPropertyTypeID");
			}
			if (result.has("DestinationPropertyTypeID")
					&& !result.isNull("DestinationPropertyTypeID")) {
				DestinationPropertyTypeID = result
						.getInt("DestinationPropertyTypeID");
			}
			if (result.has("RelocateeInfoPhone1")
					&& !result.isNull("RelocateeInfoPhone1")) {
				RelocateeInfoPhone1 = result.getInt("RelocateeInfoPhone1");
			}
			if (result.has("RelocateeInfoPhone2")
					&& !result.isNull("RelocateeInfoPhone2")) {
				RelocateeInfoPhone2 = result.getInt("RelocateeInfoPhone2");
			}
			if (result.has("RelocateeInfoPhone3")
					&& !result.isNull("RelocateeInfoPhone3")) {
				RelocateeInfoPhone3 = result.getInt("RelocateeInfoPhone3");
			}
			if (result.has("RelocateeInfoPhone4")
					&& !result.isNull("RelocateeInfoPhone4")) {
				RelocateeInfoPhone4 = result.getInt("RelocateeInfoPhone4");
			}
			if (result.has("OriginHomePhone1")
					&& !result.isNull("OriginHomePhone1")) {
				OriginHomePhone1 = result.getInt("OriginHomePhone1");
			}
			if (result.has("OriginHomePhone2")
					&& !result.isNull("OriginHomePhone2")) {
				OriginHomePhone2 = result.getInt("OriginHomePhone2");
			}
			if (result.has("OriginHomePhone3")
					&& !result.isNull("OriginHomePhone3")) {
				OriginHomePhone3 = result.getInt("OriginHomePhone3");
			}
			if (result.has("OriginWorkPhone1")
					&& !result.isNull("OriginWorkPhone1")) {
				OriginWorkPhone1 = result.getInt("OriginWorkPhone1");
			}
			if (result.has("OriginWorkPhone2")
					&& !result.isNull("OriginWorkPhone2")) {
				OriginWorkPhone2 = result.getInt("OriginWorkPhone2");
			}
			if (result.has("OriginWorkPhone3")
					&& !result.isNull("OriginWorkPhone3")) {
				OriginWorkPhone3 = result.getInt("OriginWorkPhone3");
			}
			if (result.has("InterimPhone1") && !result.isNull("InterimPhone1")) {
				InterimPhone1 = result.getInt("InterimPhone1");
			}
			if (result.has("InterimPhone2") && !result.isNull("InterimPhone2")) {
				InterimPhone2 = result.getInt("InterimPhone2");
			}
			if (result.has("InterimPhone3") && !result.isNull("InterimPhone3")) {
				InterimPhone3 = result.getInt("InterimPhone3");
			}
			if (result.has("DestinationHomePhone1")
					&& !result.isNull("DestinationHomePhone1")) {
				DestinationHomePhone1 = result.getInt("DestinationHomePhone1");
			}
			if (result.has("DestinationHomePhone2")
					&& !result.isNull("DestinationHomePhone2")) {
				DestinationHomePhone2 = result.getInt("DestinationHomePhone2");
			}
			if (result.has("DestinationHomePhone3")
					&& !result.isNull("DestinationHomePhone3")) {
				DestinationHomePhone3 = result.getInt("DestinationHomePhone3");
			}
			if (result.has("DestinationWorkPhone1")
					&& !result.isNull("DestinationWorkPhone1")) {
				DestinationWorkPhone1 = result.getInt("DestinationWorkPhone1");
			}
			if (result.has("DestinationWorkPhone2")
					&& !result.isNull("DestinationWorkPhone2")) {
				DestinationWorkPhone2 = result.getInt("DestinationWorkPhone2");
			}
			if (result.has("DestinationWorkPhone3")
					&& !result.isNull("DestinationWorkPhone3")) {
				DestinationWorkPhone3 = result.getInt("DestinationWorkPhone3");
			}
			if (result.has("OriginDepartment")
					&& !result.isNull("OriginDepartment")) {
				OriginDepartment = result.getString("OriginDepartment");
			}
			if (result.has("DestinationDepartment")
					&& !result.isNull("DestinationDepartment")) {
				DestinationDepartment = result
						.getString("DestinationDepartment");
			}
			if (result.has("SalutationID") && !result.isNull("SalutationID")) {
				SalutationID = result.getInt("SalutationID");
			}
			if (result.has("FirstName") && !result.isNull("FirstName")) {
				FirstName = result.getString("FirstName");
			}
			if (result.has("MiddleInitial") && !result.isNull("MiddleInitial")) {
				MiddleInitial = result.getString("MiddleInitial");
			}
			if (result.has("LastName") && !result.isNull("LastName")) {
				LastName = result.getString("LastName");
			}
			if (result.has("StatusID") && !result.isNull("StatusID")) {
				StatusID = result.getInt("StatusID");
			}
			if (result.has("StatusDate") && !result.isNull("StatusDate")) {
				StatusDate = result.getString("StatusDate");
			}
			if (result.has("SSN") && !result.isNull("SSN")) {
				SSN = result.getString("SSN");
			}
			if (result.has("EmployeeNbr") && !result.isNull("EmployeeNbr")) {
				EmployeeNbr = result.getString("EmployeeNbr");
			}
			if (result.has("Username") && !result.isNull("Username")) {
				Username = result.getString("Username");
			}
			if (result.has("Password") && !result.isNull("Password")) {
				Password = result.getString("Password");
			}
			if (result.has("eMailID") && !result.isNull("eMailID")) {
				eMailID = result.getInt("eMailID");
			}
			if (result.has("InitiationDate")
					&& !result.isNull("InitiationDate")) {
				InitiationDate = result.getString("InitiationDate");
			}
			if (result.has("ExpectedMoveDate")
					&& !result.isNull("ExpectedMoveDate")) {
				ExpectedMoveDate = result.getString("ExpectedMoveDate");
			}
			if (result.has("VacateDate") && !result.isNull("VacateDate")) {
				VacateDate = result.getString("VacateDate");
			}
			if (result.has("JobStartDate") && !result.isNull("JobStartDate")) {
				JobStartDate = result.getString("JobStartDate");
			}
			if (result.has("ProrateDate") && !result.isNull("ProrateDate")) {
				ProrateDate = result.getString("ProrateDate");
			}
			if (result.has("InterimStartDate")
					&& !result.isNull("InterimStartDate")) {
				InterimStartDate = result.getString("InterimStartDate");
			}
			if (result.has("InterimFinishDate")
					&& !result.isNull("InterimFinishDate")) {
				InterimFinishDate = result.getString("InterimFinishDate");
			}
			if (result.has("SpouseFirstName")
					&& !result.isNull("SpouseFirstName")) {
				SpouseFirstName = result.getString("SpouseFirstName");
			}
			if (result.has("SpouseMiddleInitial")
					&& !result.isNull("SpouseMiddleInitial")) {
				SpouseMiddleInitial = result.getString("SpouseMiddleInitial");
			}
			if (result.has("SpouseLastName")
					&& !result.isNull("SpouseLastName")) {
				SpouseLastName = result.getString("SpouseLastName");
			}
			if (result.has("SpouseSSN") && !result.isNull("SpouseSSN")) {
				SpouseSSN = result.getString("SpouseSSN");
			}
			if (result.has("SendMailTo") && !result.isNull("SendMailTo")) {
				SendMailTo = result.getInt("SendMailTo");
			}
			if (result.has("CoordinatorID") && !result.isNull("CoordinatorID")) {
				CoordinatorID = result.getInt("CoordinatorID");
			}
			if (result.has("CoordAsst") && !result.isNull("CoordAsst")) {
				CoordAsst = result.getString("CoordAsst");
			}
			if (result.has("CoordinatorAsstID")
					&& !result.isNull("CoordinatorAsstID")) {
				CoordinatorAsstID = result.getInt("CoordinatorAsstID");
			}
			if (result.has("RequestDestination")
					&& !result.isNull("RequestDestination")) {
				RequestDestination = result.getString("RequestDestination");
			}
			if (result.has("RequestType") && !result.isNull("RequestType")) {
				RequestType = result.getString("RequestType");
			}
			if (result.has("MoveTypeID") && !result.isNull("MoveTypeID")) {
				MoveTypeID = result.getInt("MoveTypeID");
			}
			if (result.has("ProgramType") && !result.isNull("ProgramType")) {
				ProgramType = result.getString("ProgramType");
			}
			if (result.has("MoveReasonID") && !result.isNull("MoveReasonID")) {
				MoveReasonID = result.getInt("MoveReasonID");
			}
			if (result.has("MoveMiles") && !result.isNull("MoveMiles")) {
				MoveMiles = result.getInt("MoveMiles");
			}
			if (result.has("AccommodationID")
					&& !result.isNull("AccommodationID")) {
				AccommodationID = result.getInt("AccommodationID");
			}
			if (result.has("SeniorityDate") && !result.isNull("SeniorityDate")) {
				SeniorityDate = result.getString("SeniorityDate");
			}
			if (result.has("PreviousMoveCount")
					&& !result.isNull("PreviousMoveCount")) {
				PreviousMoveCount =(byte) result.getInt("PreviousMoveCount");
			}
			if (result.has("ColMultiple") && !result.isNull("ColMultiple")) {
				ColMultiple = result.getString("ColMultiple");
			}
			if (result.has("Title") && !result.isNull("Title")) {
				Title = result.getString("Title");
			}
			if (result.has("CurrencyID") && !result.isNull("CurrencyID")) {
				CurrencyID = result.getInt("CurrencyID");
			}
			if (result.has("Exemptions1040")
					&& !result.isNull("Exemptions1040")) {
				Exemptions1040 = (byte)result.getInt("Exemptions1040");
			}
			if (result.has("ExemptionsW4") && !result.isNull("ExemptionsW4")) {
				ExemptionsW4 =(byte) result.getInt("ExemptionsW4");
			}
			if (result.has("FICAEarnings") && !result.isNull("FICAEarnings")) {
				FICAEarnings = result.getDouble("FICAEarnings");
			}
			if (result.has("GrossupToState")
					&& !result.isNull("GrossupToState")) {
				GrossupToState = result.getInt("GrossupToState");
			}
			if (result.has("RelocationComplete")
					&& !result.isNull("RelocationComplete")) {
				RelocationComplete = result.getString("RelocationComplete");
			}
			if (result.has("TaxFilingStatusID")
					&& !result.isNull("TaxFilingStatusID")) {
				TaxFilingStatusID = result.getInt("TaxFilingStatusID");
			}
			if (result.has("ServiceRepID") && !result.isNull("ServiceRepID")) {
				ServiceRepID = result.getInt("ServiceRepID");
			}
			if (result.has("SpecialNeeds") && !result.isNull("SpecialNeeds")) {
				SpecialNeeds = result.getString("SpecialNeeds");
			}
			if (result.has("UrgentInstrctns")
					&& !result.isNull("UrgentInstrctns")) {
				UrgentInstrctns = result.getString("UrgentInstrctns");
			}
			if (result.has("ReferralSourceID")
					&& !result.isNull("ReferralSourceID")) {
				ReferralSourceID = result.getInt("ReferralSourceID");
			}
			if (result.has("ReferralOther") && !result.isNull("ReferralOther")) {
				ReferralOther = result.getString("ReferralOther");
			}
			if (result.has("PolicyException")
					&& !result.isNull("PolicyException")) {
				PolicyException = result.getString("PolicyException");
			}
			if (result.has("PreferredCommTypeID")
					&& !result.isNull("PreferredCommTypeID")) {
				PreferredCommTypeID = result.getInt("PreferredCommTypeID");
			}
			if (result.has("PreferredCommOptionID")
					&& !result.isNull("PreferredCommOptionID")) {
				PreferredCommOptionID = result.getInt("PreferredCommOptionID");
			}
			if (result.has("TypeOfSale") && !result.isNull("TypeOfSale")) {
				TypeOfSale = result.getInt("TypeOfSale");
			}
			if (result.has("NewHire") && !result.isNull("NewHire")) {
				NewHire = result.getInt("NewHire");
			}
			if (result.has("LoginAttempts") && !result.isNull("LoginAttempts")) {
				LoginAttempts = result.getInt("LoginAttempts");
			}
			if (result.has("DefaultVendorMiles")
					&& !result.isNull("DefaultVendorMiles")) {
				DefaultVendorMiles = result.getInt("DefaultVendorMiles");
			}
			if (result.has("OrigPurchPrice")
					&& !result.isNull("OrigPurchPrice")) {
				OrigPurchPrice = result.getDouble("OrigPurchPrice");
			}
			if (result.has("TypeOfProgram") && !result.isNull("TypeOfProgram")) {
				TypeOfProgram = result.getInt("TypeOfProgram");
			}
			if (result.has("ClosingCompanyName")
					&& !result.isNull("ClosingCompanyName")) {
				ClosingCompanyName = result.getString("ClosingCompanyName");
			}
			if (result.has("ClosingCompanyAddress1")
					&& !result.isNull("ClosingCompanyAddress1")) {
				ClosingCompanyAddress1 = result
						.getString("ClosingCompanyAddress1");
			}
			if (result.has("ClosingCompanyAddress2")
					&& !result.isNull("ClosingCompanyAddress2")) {
				ClosingCompanyAddress2 = result
						.getString("ClosingCompanyAddress2");
			}
			if (result.has("ClosingCompanyCity")
					&& !result.isNull("ClosingCompanyCity")) {
				ClosingCompanyCity = result.getString("ClosingCompanyCity");
			}
			if (result.has("ClosingCompanyState")
					&& !result.isNull("ClosingCompanyState")) {
				ClosingCompanyState = result.getString("ClosingCompanyState");
			}
			if (result.has("ClosingCompanyPostalCode")
					&& !result.isNull("ClosingCompanyPostalCode")) {
				ClosingCompanyPostalCode = result
						.getString("ClosingCompanyPostalCode");
			}
			if (result.has("ClosingCompanyCountryCode")
					&& !result.isNull("ClosingCompanyCountryCode")) {
				ClosingCompanyCountryCode = result
						.getString("ClosingCompanyCountryCode");
			}
			if (result.has("QualifyStatus") && !result.isNull("QualifyStatus")) {
				QualifyStatus = result.getInt("QualifyStatus");
			}
			if (result.has("SentToBankOne") && !result.isNull("SentToBankOne")) {
				SentToBankOne = result.getInt("SentToBankOne");
			}
			if (result.has("CobrandRemoteUserID")
					&& !result.isNull("CobrandRemoteUserID")) {
				CobrandRemoteUserID = result.getInt("CobrandRemoteUserID");
			}
			if (result.has("LastLogin") && !result.isNull("LastLogin")) {
				LastLogin = result.getString("LastLogin");
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
			if (result.has("SentInitLetter")
					&& !result.isNull("SentInitLetter")) {
				SentInitLetter = result.getInt("SentInitLetter");
			}
			if (result.has("GlobalContactID")
					&& !result.isNull("GlobalContactID")) {
				GlobalContactID = result.getInt("GlobalContactID");
			}
			if (result.has("ReportingDate") && !result.isNull("ReportingDate")) {
				ReportingDate = result.getString("ReportingDate");
			}
			if (result.has("FinalRecDate") && !result.isNull("FinalRecDate")) {
				FinalRecDate = result.getString("FinalRecDate");
			}
			if (result.has("SurveyRespondent")
					&& !result.isNull("SurveyRespondent")) {
				SurveyRespondent = result.getString("SurveyRespondent");
			}
			if (result.has("SurveyComments")
					&& !result.isNull("SurveyComments")) {
				SurveyComments = result.getString("SurveyComments");
			}
			if (result.has("InterviewOverview")
					&& !result.isNull("InterviewOverview")) {
				InterviewOverview = result.getInt("InterviewOverview");
			}
			if (result.has("InvoicedInterviewOverview")
					&& !result.isNull("InvoicedInterviewOverview")) {
				InvoicedInterviewOverview = result
						.getInt("InvoicedInterviewOverview");
			}
			if (result.has("FullConversationDate")
					&& !result.isNull("FullConversationDate")) {
				FullConversationDate = result.getString("FullConversationDate");
			}
			if (result.has("ClientNotes") && !result.isNull("ClientNotes")) {
				ClientNotes = result.getString("ClientNotes");
			}
			if (result.has("ClosingCompanyContact")
					&& !result.isNull("ClosingCompanyContact")) {
				ClosingCompanyContact = result
						.getString("ClosingCompanyContact");
			}
			if (result.has("ClosingCompanyPhone")
					&& !result.isNull("ClosingCompanyPhone")) {
				ClosingCompanyPhone = result.getString("ClosingCompanyPhone");
			}
			if (result.has("ClosingCompanyFax")
					&& !result.isNull("ClosingCompanyFax")) {
				ClosingCompanyFax = result.getString("ClosingCompanyFax");
			}
			if (result.has("ClosingCompanyEmail")
					&& !result.isNull("ClosingCompanyEmail")) {
				ClosingCompanyEmail = result.getString("ClosingCompanyEmail");
			}
			if (result.has("Nickname") && !result.isNull("Nickname")) {
				Nickname = result.getString("Nickname");
			}
			if (result.has("SpouseNickname")
					&& !result.isNull("SpouseNickname")) {
				SpouseNickname = result.getString("SpouseNickname");
			}
			if (result.has("SentToReloviews")
					&& !result.isNull("SentToReloviews")) {
				SentToReloviews = result.getInt("SentToReloviews");
			}
			if (result.has("TypeofFile") && !result.isNull("TypeofFile")) {
				TypeofFile = result.getInt("TypeofFile");
			}
			if (result.has("GACSAssignmentID")
					&& !result.isNull("GACSAssignmentID")) {
				GACSAssignmentID = result.getInt("GACSAssignmentID");
			}
			if (result.has("GACSHostCurrencyID")
					&& !result.isNull("GACSHostCurrencyID")) {
				GACSHostCurrencyID = result.getInt("GACSHostCurrencyID");
			}
			if (result.has("GACSHomeCurrencyID")
					&& !result.isNull("GACSHomeCurrencyID")) {
				GACSHomeCurrencyID = result.getInt("GACSHomeCurrencyID");
			}
			if (result.has("GACSHQCurrencyID")
					&& !result.isNull("GACSHQCurrencyID")) {
				GACSHQCurrencyID = result.getInt("GACSHQCurrencyID");
			}
			if (result.has("CitizenshipPrimaryID")
					&& !result.isNull("CitizenshipPrimaryID")) {
				CitizenshipPrimaryID = result.getInt("CitizenshipPrimaryID");
			}
			if (result.has("CitizenshipSecondaryID")
					&& !result.isNull("CitizenshipSecondaryID")) {
				CitizenshipSecondaryID = result
						.getInt("CitizenshipSecondaryID");
			}
			if (result.has("PassportNumber")
					&& !result.isNull("PassportNumber")) {
				PassportNumber = result.getString("PassportNumber");
			}
			if (result.has("PassportIssue") && !result.isNull("PassportIssue")) {
				PassportIssue = result.getString("PassportIssue");
			}
			if (result.has("BirthCountryID")
					&& !result.isNull("BirthCountryID")) {
				BirthCountryID = result.getInt("BirthCountryID");
			}
			if (result.has("BirthProvince") && !result.isNull("BirthProvince")) {
				BirthProvince = result.getString("BirthProvince");
			}
			if (result.has("BirthCity") && !result.isNull("BirthCity")) {
				BirthCity = result.getString("BirthCity");
			}
			if (result.has("GeneralLedger") && !result.isNull("GeneralLedger")) {
				GeneralLedger = result.getString("GeneralLedger");
			}
			if (result.has("VendorNumber") && !result.isNull("VendorNumber")) {
				VendorNumber = result.getString("VendorNumber");
			}
			if (result.has("FileNumber") && !result.isNull("FileNumber")) {
				FileNumber = result.getString("FileNumber");
			}
			if (result.has("ExecutiveOfficer")
					&& !result.isNull("ExecutiveOfficer")) {
				ExecutiveOfficer = result.getInt("ExecutiveOfficer");
			}
			if (result.has("OriginHomeToOrigOff")
					&& !result.isNull("OriginHomeToOrigOff")) {
				OriginHomeToOrigOff = result.getInt("OriginHomeToOrigOff");
			}
			if (result.has("OriginHomeToDeatOff")
					&& !result.isNull("OriginHomeToDeatOff")) {
				OriginHomeToDeatOff = result.getInt("OriginHomeToDeatOff");
			}
			if (result.has("GUPPolicyID") && !result.isNull("GUPPolicyID")) {
				GUPPolicyID = result.getInt("GUPPolicyID");
			}
			if (result.has("NETPolicyID") && !result.isNull("NETPolicyID")) {
				NETPolicyID = result.getInt("NETPolicyID");
			}
			if (result.has("TransferNumber")
					&& !result.isNull("TransferNumber")) {
				TransferNumber = result.getString("TransferNumber");
			}
			if (result.has("PersonID") && !result.isNull("PersonID")) {
				PersonID = result.getInt("PersonID");
			}
			if (result.has("AllowDirectDeposit")
					&& !result.isNull("AllowDirectDeposit")) {
				AllowDirectDeposit = result.getInt("AllowDirectDeposit");
			}
			if (result.has("BillingRateID") && !result.isNull("BillingRateID")) {
				BillingRateID = result.getInt("BillingRateID");
			}
			if (result.has("EffectiveDate") && !result.isNull("EffectiveDate")) {
				EffectiveDate = result.getString("EffectiveDate");
			}
			if (result.has("Canceldate") && !result.isNull("Canceldate")) {
				Canceldate = result.getString("Canceldate");
			}
			if (result.has("Closedate") && !result.isNull("Closedate")) {
				Closedate = result.getString("Closedate");
			}
			if (result.has("UsersID") && !result.isNull("UsersID")) {
				UsersID = result.getInt("UsersID");
			}
			if (result.has("HomeCurrencyID")
					&& !result.isNull("HomeCurrencyID")) {
				HomeCurrencyID = result.getInt("HomeCurrencyID");
			}
			if (result.has("HostCurrencyID")
					&& !result.isNull("HostCurrencyID")) {
				HostCurrencyID = result.getInt("HostCurrencyID");
			}
			if (result.has("OverrideMoveMiles")
					&& !result.isNull("OverrideMoveMiles")) {
				OverrideMoveMiles = result.getBoolean("OverrideMoveMiles");
			}
			if (result.has("AlternateContactFirstName")
					&& !result.isNull("AlternateContactFirstName")) {
				AlternateContactFirstName = result
						.getString("AlternateContactFirstName");
			}
			if (result.has("AlternateContactLastName")
					&& !result.isNull("AlternateContactLastName")) {
				AlternateContactLastName = result
						.getString("AlternateContactLastName");
			}
			if (result.has("AlternateContactMiddleName")
					&& !result.isNull("AlternateContactMiddleName")) {
				AlternateContactMiddleName = result
						.getString("AlternateContactMiddleName");
			}
			if (result.has("AlternateContactType")
					&& !result.isNull("AlternateContactType")) {
				AlternateContactType = result.getString("AlternateContactType");
			}
			if (result.has("ReInitiatedDate")
					&& !result.isNull("ReInitiatedDate")) {
				ReInitiatedDate = result.getString("ReInitiatedDate");
			}
		} catch (Exception e) {
			Log.e("Calss Relocatee", e.getMessage());
		}
	}
}