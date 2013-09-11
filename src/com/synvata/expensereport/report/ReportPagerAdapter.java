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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


public class ReportPagerAdapter extends BaseFragmentPagerAdapter {
	private List<ExpenseReport> _list;
	public ReportPagerAdapter(FragmentManager fm) {
		super(fm);
		_list = new ArrayList<ExpenseReport>();

	}

	@Override
	public Fragment getItem(int arg0) {
		Fragment fragment = new ReportFragment();
		return fragment;
	}

	@Override
	public int getCount() {

		return _list.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return _list.get(position).Name;
	}
	public void loadData()
	{
		
		String url = String.format("expenseReports/reports?relocateeId=%d", AppSettings.relocateId);
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
				_list.clear();
				for(int i=0;i<list.length();i++){
					JSONObject item = list.getJSONObject(i);
					ExpenseReport er = new ExpenseReport(item);
					_list.add(er);
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
