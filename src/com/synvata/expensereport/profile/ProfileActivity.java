package com.synvata.expensereport.profile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.synvata.expensereport.R;
import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.BaseFragmentPagerAdapter.SectionTitle;
import com.synvata.expensereport.base.HttpExecuteGetTask;
import com.synvata.expensereport.base.HttpSettings;
import com.synvata.expensereport.expense.ExpensePagerAdapter;
import com.synvata.expensereport.login.LoginActivity;
import com.synvata.expensereport.report.ReportPagerAdapter;
import com.synvata.expensereport.service.ServicePagerAdapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;

public class ProfileActivity extends FragmentActivity implements
		ActionBar.TabListener {

	private ViewPager _viewPager;
	private ProfilePagerAdapter _adapter;
	private List<ProfileSection> _sections;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		_sections = new ArrayList<ProfileSection>();
		final ActionBar actionBar = getActionBar();
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setTitle("Profile");
		_adapter = new ProfilePagerAdapter(this.getSupportFragmentManager());
		_viewPager = (ViewPager) findViewById(R.id.pager);
		_viewPager.setAdapter(_adapter);
		_viewPager
				.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);

					}

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {

					}

					@Override
					public void onPageScrollStateChanged(int arg0) {

					}
				});
		loadData();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_profile, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.logout:
			AppSettings.isLogin = false;
			AppSettings.person = null;
			Intent intent = new Intent(this,LoginActivity.class);
			startActivityForResult(intent, AppSettings.LOGIN_SUCCESS);
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		_viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}
	public void loadData()
	{
		new HttpExecuteGetTask(){

			@Override
			protected void onPostExecute(String result) {
				processData(result);
				
			}}.execute(String.format("relocatee/summary/%d", AppSettings.relocateeId));
	}
	private void processData(final String result){
		try
		{
			JSONObject json =new JSONObject(result);
			if (HttpSettings.isSuccessJSON(json)){
				_sections.clear();
				JSONArray list = json.getJSONArray("result");
				for(int i=0;i<list.length();i++){
					JSONObject item = list.getJSONObject(i);
					ProfileSection ps = new ProfileSection();
					ps.title = item.getString("title");
					_sections.add(ps);
					JSONArray items = item.getJSONArray("list");
					for(int j=0;j<items.length();j++)
					{
						JSONObject item2 = items.getJSONObject(j);
						CellData cd = new CellData();
						cd.Title = item2.getString("Title");
						cd.Detail = item2.getString("Detail");
						if (item2.has("Url") && !item2.isNull("Url")){
							cd.Url = item2.getString("Url");
						}
						ps.items.add(cd);
					}
				}
				final ActionBar actionBar = getActionBar();
				for (int i = 0; i < _adapter.getCount(); i++) {
					actionBar.addTab(actionBar.newTab()
							.setText(_adapter.getPageTitle(i)).setTabListener(this));
				}
				
			}
		}
		catch(Exception e){
			HttpSettings.log(e.getLocalizedMessage());
		}
	}
	public class ProfilePagerAdapter extends FragmentPagerAdapter {
		
		public ProfilePagerAdapter(FragmentManager fm) {
			super(fm);
			
			
		}
		
		
		@Override
		public Fragment getItem(int i) {
			Fragment f = new ProfileFragment();
			Bundle bundle = new Bundle();
			bundle.putSerializable("data", _sections.get(i).items);			
			f.setArguments(bundle);
			return f;
		}

		@Override
		public int getCount() {
			return _sections.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return _sections.get(position).title;
		}
	}
	public class CellData implements Serializable
	{
	
		private static final long serialVersionUID = 1L;
		public String Title;
		public String Detail;
		public String Url;
	}
	public class ProfileSection
	{
		public String title;
		public ArrayList<CellData> items;
		public ProfileSection()
		{
			items = new ArrayList<CellData>();
		}
	}

}
