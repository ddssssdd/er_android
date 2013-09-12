package com.synvata.expensereport.report;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.BaseFragmentPagerAdapter;
import com.synvata.expensereport.base.HttpExecuteGetTask;
import com.synvata.expensereport.base.HttpSettings;
import com.synvata.expensereport.model.ExpenseReport;
import com.synvata.expensereport.model.ReportStatus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


public class ReportPagerAdapter extends BaseFragmentPagerAdapter {
	public ReportPagerAdapter(FragmentManager fm) {
		super(fm);
		

	}

	@Override
	public Fragment getItem(int index) {
		Fragment fragment = new ReportFragment();
		Bundle args = new Bundle();
		args.putSerializable("data", _sections.get(index).items);
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
		
		String url = String.format("expenseReports/reports?relocateeId=%d", AppSettings.relocateeId);
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
					ExpenseReport er = new ExpenseReport(item);
					ReportStatus rs = ReportStatus.find(er.ReportStatusID);
					if (rs!=null){
						this.addItemToSection(rs.Description, er);
					}
				
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
