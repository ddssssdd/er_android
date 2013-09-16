package com.synvata.expensereport.profile;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfileSection  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String title;
	public ArrayList<CellData> items;
	public ProfileSection()
	{
		items = new ArrayList<CellData>();
	}
}
