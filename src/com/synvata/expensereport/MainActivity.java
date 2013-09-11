package com.synvata.expensereport;

import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.HttpActivity;

import com.synvata.expensereport.expense.ExpenseListFragment;
import com.synvata.expensereport.login.LoginActivity;
import com.synvata.expensereport.profile.ProfileFragment;
import com.synvata.expensereport.report.ReportListFragment;
import com.synvata.expensereport.service.ServiceListFragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.FragmentManager;

public class MainActivity extends HttpActivity {

	private Fragment _currentFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.main_activity);
		if (!AppSettings.isLogin){
			Intent intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
		}else
		{
			//load latest data;			
		}
		/*
		ActionBar bar = this.getActionBar();
		bar.setTitle("ExpenseReport");
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		Tab tab1 = bar.newTab();
		tab1.setText("Tab1");
		tab1.setTabListener(new TabListener(){

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}});
		bar.addTab(tab1);
		Tab tab2 = bar.newTab();
		tab2.setText("Tab2");
		tab2.setTabListener(new TabListener(){

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}});
		bar.addTab(tab2);
		*/
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		
		
		switch(item.getItemId()){
		case R.id.report:
			createFragment( new ReportListFragment());			
			
			break;
		case R.id.expense:
			
			createFragment( new ExpenseListFragment());
			break;
		case R.id.service:
			createFragment( new ServiceListFragment());
			break;
		case R.id.profile:
			createFragment( new ProfileFragment());
			
			AppSettings.isLogin = false;
			AppSettings.person = null;
			Intent intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	private void createFragment(Fragment f)
	{
		FragmentManager fragmentManger = getFragmentManager();
		FragmentTransaction transaction = fragmentManger.beginTransaction();
		if (_currentFragment!=null){
			transaction.remove(_currentFragment);
			_currentFragment = null;
		}
		_currentFragment = f;
		
		transaction.add(R.id.content,f);
		transaction.commit();
		
	}
	
}
