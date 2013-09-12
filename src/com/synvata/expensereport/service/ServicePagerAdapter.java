package com.synvata.expensereport.service;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.BaseFragmentPagerAdapter;
import com.synvata.expensereport.base.HttpExecuteGetTask;
import com.synvata.expensereport.base.HttpSettings;
import com.synvata.expensereport.model.RelocateeService;

public class ServicePagerAdapter extends BaseFragmentPagerAdapter {
	public ServicePagerAdapter(FragmentManager fm) {
		super(fm);
		

	}

	@Override
	public Fragment getItem(int index) {
		Fragment fragment = new ServiceFragment();
		Bundle args = new Bundle();
		args.putSerializable("data", _sections.get(index).items);
		args.putInt("index", index);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {

		return _sections.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return _sections.get(position).title;
	}
	public void loadData()
	{
		
		String url = String.format("relocatee/services/%d", AppSettings.relocateeId);
		new HttpExecuteGetTask(){
			@Override
			protected void onPostExecute(String result) {
				processData(result);
			}
		}.execute(url);
	}
	private void processData(final String result)
	{
		try
		{
			JSONObject json = new JSONObject(result);
			if (HttpSettings.isSuccessJSON(json)){
				
				JSONArray list = json.getJSONArray("result");
				
				_sections.clear();
				
				for(int i=0;i<list.length();i++){
					JSONObject item = list.getJSONObject(i);
					RelocateeService obj = new RelocateeService(item);
					addItemToSection(obj.GroupName,obj);
				
				}
				this.notifyDataSetChanged();
			}
		}
		catch(Exception e)
		{
			HttpSettings.log(e.getMessage());
		}
		
	}
	
}
