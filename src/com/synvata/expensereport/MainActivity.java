package com.synvata.expensereport;

import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.base.BaseFragmentPagerAdapter;
import com.synvata.expensereport.login.LoginActivity;
import com.synvata.expensereport.report.ReportPagerAdapter;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.content.Intent;

public class MainActivity extends FragmentActivity {

	private BaseFragmentPagerAdapter _adapter;
	private ViewPager _viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.main_activity);
		_adapter = new ReportPagerAdapter(getSupportFragmentManager());
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        _viewPager = (ViewPager)findViewById(R.id.pager);
        _viewPager.setAdapter(_adapter);
        
        
		if (!AppSettings.isLogin){
			Intent intent = new Intent(this,LoginActivity.class);
			this.startActivityForResult(intent, AppSettings.LOGIN_SUCCESS);
			return;
		}else
		{
			_adapter.loadData();
		}
		
        
       
	}
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode==RESULT_OK){
			if (requestCode==AppSettings.LOGIN_SUCCESS){
				_adapter.loadData();
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
			
			break;
		case R.id.expense:
			
			break;
		case R.id.service:
			break;
		case R.id.profile:
			
			AppSettings.isLogin = false;
			AppSettings.person = null;
			Intent intent = new Intent(this,LoginActivity.class);
			startActivity(intent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
