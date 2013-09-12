package com.synvata.expensereport.expense;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.BaseFragmentPagerAdapter;
import com.synvata.expensereport.base.HttpExecuteGetTask;
import com.synvata.expensereport.base.HttpSettings;
import com.synvata.expensereport.base.KeyValue;
import com.synvata.expensereport.model.VW_Expense;

public class ExpensePagerAdapter extends BaseFragmentPagerAdapter {
	public ExpensePagerAdapter(FragmentManager fm) {
		super(fm);
		

	}

	@Override
	public Fragment getItem(int index) {
		Fragment fragment = new ExpenseFragment();
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
		
		String url = String.format("expenseReports/expense?relocateeId=%d", AppSettings.relocateeId);
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
				JSONObject sum = json.getJSONObject("result");
				JSONArray list = sum.getJSONArray("list");
				
				_sections.clear();
				SectionTitle st1  = new SectionTitle();
				st1.title="Expense Summary";
				st1.items.add(new KeyValue("Total Records",String.valueOf(sum.getInt("count"))));
				st1.items.add(new KeyValue("Grand Total",String.valueOf(sum.getDouble("amount"))));
				st1.items.add(new KeyValue("Netcheck Total",String.valueOf(sum.getDouble("netcheck"))));
				_sections.add(st1);
				SectionTitle st2 =new SectionTitle();
				st2.title="Expenses";
				_sections.add(st2);
				for(int i=0;i<list.length();i++){
					JSONObject item = list.getJSONObject(i);
					VW_Expense obj = new VW_Expense(item);
					st2.items.add(obj);
				
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
