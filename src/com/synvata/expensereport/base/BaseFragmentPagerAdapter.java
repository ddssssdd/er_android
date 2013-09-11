package com.synvata.expensereport.base;


import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public abstract class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

	protected List<SectionTitle> _sections;
	public BaseFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		_sections  = new ArrayList<SectionTitle>();
	}
	abstract public void loadData();
	 
	public class SectionTitle<T>
	{
		public String title;
		public String description;
		public List<T> items;
		
	}
	

}
