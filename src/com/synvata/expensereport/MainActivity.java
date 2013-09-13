package com.synvata.expensereport;

import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.BaseFragmentPagerAdapter;
import com.synvata.expensereport.expense.ExpensePagerAdapter;
import com.synvata.expensereport.init.InitData;
import com.synvata.expensereport.login.LoginActivity;
import com.synvata.expensereport.profile.ProfileActivity;
import com.synvata.expensereport.report.ReportPagerAdapter;
import com.synvata.expensereport.service.ServicePagerAdapter;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.content.Intent;

public class MainActivity extends FragmentActivity {

	private BaseFragmentPagerAdapter _adapter;
	private ExpensePagerAdapter _expenseAdapter;
	private ServicePagerAdapter _serviceAdapter;
	private ViewPager _viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.main_activity);
		
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        _viewPager = (ViewPager)findViewById(R.id.pager);
        actionBar.setHomeButtonEnabled(false);
        
        AppSettings.load(this);
		if (!AppSettings.isLogin){
			Intent intent = new Intent(this,LoginActivity.class);
			startActivityForResult(intent, AppSettings.LOGIN_SUCCESS);
			return;
		}else
		{
			initData();
		}
		
        
       
	}
	
	private void initData()
	{
		new InitData(this).Init();
		_adapter =null;
		_adapter = new ReportPagerAdapter(getSupportFragmentManager());
		_viewPager.setAdapter(_adapter);
		_adapter.loadData();
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode==RESULT_OK){
			if (requestCode==AppSettings.LOGIN_SUCCESS){
				initData();
			}
		}
		
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
			if (_adapter==null){
				_adapter = new ReportPagerAdapter(getSupportFragmentManager());
				_adapter.loadData();
			}
			
			 _viewPager.setAdapter(_adapter);
			 _adapter.notifyDataSetChanged();
			break;
		case R.id.expense:
			if (_expenseAdapter==null)
			{
				_expenseAdapter = new ExpensePagerAdapter(getSupportFragmentManager());
				_expenseAdapter.loadData();
			}
			//_viewPager.setAdapter(null);
			_viewPager.setAdapter(_expenseAdapter);
			_expenseAdapter.notifyDataSetChanged();
			//_expenseAdapter.startUpdate(_viewPager);
			break;
		case R.id.service:
			if (_serviceAdapter==null)
			{
				_serviceAdapter = new ServicePagerAdapter(getSupportFragmentManager());
				_serviceAdapter.loadData();
			}
			
			_viewPager.setAdapter(_serviceAdapter);
			_serviceAdapter.notifyDataSetChanged();
			
			break;
		case R.id.profile:
			/*
			_adapter = null;
			_expenseAdapter = null;
			_serviceAdapter = null;
			*/
			
			Intent intent = new Intent(this,ProfileActivity.class);
			startActivity(intent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
