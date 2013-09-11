package com.synvata.expensereport.model;

import java.io.Serializable;
import org.json.JSONObject;
import android.util.Log;

public class Person implements Serializable {
	public int PersonID;
	public int TransferPersonID;
	public int SystemUserID;
	public String FirstName;
	public String MiddleName;
	public String LastName;
	public String PreferredName;
	public int PreferredContactID;
	public int PreferredContactTypeID;
	public int SalutationID;
	public String TaxID;
	public String DOB;
	public String PrimaryCitizenship;
	public String SecondaryCitizenship;
	public String ExecutiveOfficer;
	public int User_ID;
	public String UpdateDate;
	public String EntryDate;
	public int UpdateSeqNo;
	public String SpouseFirstName;
	public String SpouseMiddleName;
	public String SpouseLastName;
	public String SpouseSSN;
	public String SSN;
	public int EnteredUser;
	public String EnteredDate;
	public int UpdateUser;
	public String Nickname;
	public String SpouseNickname;
	public int birthCountryid;
	public String birthprovince;
	public String birthcity;
	public String passportnumber;
	public String passportissue;
	public int relocateeid;
	public int PersonUserID;
	public String SpouseTaxID;

	public Person() {
	}

	public Person(JSONObject result) {
		processJSON(result);
	}

	private void processJSON(final JSONObject result) {
		try {
			if (result.has("PersonID") && !result.isNull("PersonID")) {
				PersonID = result.getInt("PersonID");
			}
			if (result.has("TransferPersonID")
					&& !result.isNull("TransferPersonID")) {
				TransferPersonID = result.getInt("TransferPersonID");
			}
			if (result.has("SystemUserID") && !result.isNull("SystemUserID")) {
				SystemUserID = result.getInt("SystemUserID");
			}
			if (result.has("FirstName") && !result.isNull("FirstName")) {
				FirstName = result.getString("FirstName");
			}
			if (result.has("MiddleName") && !result.isNull("MiddleName")) {
				MiddleName = result.getString("MiddleName");
			}
			if (result.has("LastName") && !result.isNull("LastName")) {
				LastName = result.getString("LastName");
			}
			if (result.has("PreferredName") && !result.isNull("PreferredName")) {
				PreferredName = result.getString("PreferredName");
			}
			if (result.has("PreferredContactID")
					&& !result.isNull("PreferredContactID")) {
				PreferredContactID = result.getInt("PreferredContactID");
			}
			if (result.has("PreferredContactTypeID")
					&& !result.isNull("PreferredContactTypeID")) {
				PreferredContactTypeID = result
						.getInt("PreferredContactTypeID");
			}
			if (result.has("SalutationID") && !result.isNull("SalutationID")) {
				SalutationID = result.getInt("SalutationID");
			}
			if (result.has("TaxID") && !result.isNull("TaxID")) {
				TaxID = result.getString("TaxID");
			}
			if (result.has("DOB") && !result.isNull("DOB")) {
				DOB = result.getString("DOB");
			}
			if (result.has("PrimaryCitizenship")
					&& !result.isNull("PrimaryCitizenship")) {
				PrimaryCitizenship = result.getString("PrimaryCitizenship");
			}
			if (result.has("SecondaryCitizenship")
					&& !result.isNull("SecondaryCitizenship")) {
				SecondaryCitizenship = result.getString("SecondaryCitizenship");
			}
			if (result.has("ExecutiveOfficer")
					&& !result.isNull("ExecutiveOfficer")) {
				ExecutiveOfficer = result.getString("ExecutiveOfficer");
			}
			if (result.has("User_ID") && !result.isNull("User_ID")) {
				User_ID = result.getInt("User_ID");
			}
			if (result.has("UpdateDate") && !result.isNull("UpdateDate")) {
				UpdateDate = result.getString("UpdateDate");
			}
			if (result.has("EntryDate") && !result.isNull("EntryDate")) {
				EntryDate = result.getString("EntryDate");
			}
			if (result.has("UpdateSeqNo") && !result.isNull("UpdateSeqNo")) {
				UpdateSeqNo = result.getInt("UpdateSeqNo");
			}
			if (result.has("SpouseFirstName")
					&& !result.isNull("SpouseFirstName")) {
				SpouseFirstName = result.getString("SpouseFirstName");
			}
			if (result.has("SpouseMiddleName")
					&& !result.isNull("SpouseMiddleName")) {
				SpouseMiddleName = result.getString("SpouseMiddleName");
			}
			if (result.has("SpouseLastName")
					&& !result.isNull("SpouseLastName")) {
				SpouseLastName = result.getString("SpouseLastName");
			}
			if (result.has("SpouseSSN") && !result.isNull("SpouseSSN")) {
				SpouseSSN = result.getString("SpouseSSN");
			}
			if (result.has("SSN") && !result.isNull("SSN")) {
				SSN = result.getString("SSN");
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
			if (result.has("Nickname") && !result.isNull("Nickname")) {
				Nickname = result.getString("Nickname");
			}
			if (result.has("SpouseNickname")
					&& !result.isNull("SpouseNickname")) {
				SpouseNickname = result.getString("SpouseNickname");
			}
			if (result.has("birthCountryid")
					&& !result.isNull("birthCountryid")) {
				birthCountryid = result.getInt("birthCountryid");
			}
			if (result.has("birthprovince") && !result.isNull("birthprovince")) {
				birthprovince = result.getString("birthprovince");
			}
			if (result.has("birthcity") && !result.isNull("birthcity")) {
				birthcity = result.getString("birthcity");
			}
			if (result.has("passportnumber")
					&& !result.isNull("passportnumber")) {
				passportnumber = result.getString("passportnumber");
			}
			if (result.has("passportissue") && !result.isNull("passportissue")) {
				passportissue = result.getString("passportissue");
			}
			if (result.has("relocateeid") && !result.isNull("relocateeid")) {
				relocateeid = result.getInt("relocateeid");
			}
			if (result.has("PersonUserID") && !result.isNull("PersonUserID")) {
				PersonUserID = result.getInt("PersonUserID");
			}
			if (result.has("SpouseTaxID") && !result.isNull("SpouseTaxID")) {
				SpouseTaxID = result.getString("SpouseTaxID");
			}
		} catch (Exception e) {
			Log.e("Calss Person", e.getMessage());
		}
	}
}