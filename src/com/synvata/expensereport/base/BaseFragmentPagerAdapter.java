package com.synvata.expensereport.base;


import java.util.ArrayList;
import java.util.List;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public abstract class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter  {

	protected List<SectionTitle> _sections;
	public BaseFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		_sections  = new ArrayList<SectionTitle>();
	}
	abstract public void loadData();
	
	protected void addItemToSection(String title,Object item){
		for(int i=0;i<_sections.size();i++){
			SectionTitle st =_sections.get(i); 
			if (st.title.equals(title)){
				st.items.add(item);
				return;
			}
		}
		SectionTitle st = new SectionTitle();
		st.title = title;
		st.items.add(item);
		_sections.add(st);
		
	}
	public class SectionTitle
	{
		public String title;
		public String description;
		public ArrayList<Object> items;
		public SectionTitle()
		{
			items = new ArrayList<Object>();
		}
	}
	
	
	
	

}
