package com.synvata.expensereport.login;

import java.util.List;

import com.synvata.expensereport.R;
import com.synvata.expensereport.base.AppSettings;
import com.synvata.expensereport.components.PopupChoose;
import com.synvata.expensereport.components.PopupChoose.OnChooseItem;

import com.synvata.expensereport.http.Login;
import com.synvata.expensereport.http.Login.GetRelocatees;
import com.synvata.expensereport.http.Login.LoginFinish;
import com.synvata.expensereport.http.Login.LoginList;
import com.synvata.expensereport.model.Person;
import com.synvata.expensereport.model.Relocatee;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity {
	private EditText txtUsername;
	private EditText txtPassword;
	private Button btnLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		txtUsername = (EditText)findViewById(R.id.txtUsername);
		txtPassword  = (EditText)findViewById(R.id.txtPassword);
		btnLogin = (Button)findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				doLogin();
				
			}});
		LoginList histroy = (new Login(this)).loginHistroy();
		if (histroy.lastLoginUser!=null){
			txtUsername.setText(histroy.lastLoginUser.username);
			txtPassword.setText(histroy.lastLoginUser.password);
		}
	}
	private void doLogin()
	{
		new Login(this).login(txtUsername.getText().toString(), txtPassword.getText().toString(), new LoginFinish(){

			@Override
			public void loginStatus(boolean isLogin, Person person) {
				if (isLogin){
					chooseRelocatee();
				}
				
			}});		
	}
	private void chooseRelocatee(){
		new Login(this).getRelocatee(new GetRelocatees(){

			@Override
			public void relocatees(List<Relocatee> list) {
				if (list.size()==1){
					//only one relocatee,no need to choose
					choose(list.get(0));
				}else
				{
					popupChoose();
				}
				
			}});
	}
	private void popupChoose(){
		String[] choices = new String[AppSettings.relocatees.size()];
		for(int i=0;i<AppSettings.relocatees.size();i++)
		{
			Relocatee r = AppSettings.relocatees.get(i);
			choices[i] = String.format("%s %s", r.FirstName.trim(),r.LastName.trim());
		}
		new PopupChoose(LoginActivity.this).simple(choices, new OnChooseItem(){

			@Override
			public void onItemClick(int index) {
				choose(AppSettings.relocatees.get(index));
				
			}});		
	}
	private void choose(Relocatee relocatee){
		AppSettings.relocatee = relocatee;
		AppSettings.relocateeId = relocatee.RelocateeID;
		AppSettings.save(this);
		this.setResult(RESULT_OK);
		finish();
	}
}
