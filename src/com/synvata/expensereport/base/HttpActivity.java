package com.synvata.expensereport.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.http.NameValuePair;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class HttpActivity extends Activity {
	
	
	public void httpGetUrl(final String url,final HttpCallback callback)
	{
		new HttpExecuteGetTask(){
			@Override
			protected void onPostExecute(String result) {				
				
				callback.processResponse(result);
			}
		}.execute(url);
				
	}

	public void httpPostUrl(final String url,final List<NameValuePair> params, final HttpCallback callback){
		new HttpExecutePostTask(){
			@Override
			protected void onPostExecute(String result) {				
				super.onPostExecute(result);
				callback.processResponse(result);
			}
			
		}.execute(url,HttpSettings.getOutputParameters(params));
	}
	protected boolean isOnline(){
		ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();		
		return networkInfo!=null && networkInfo.isConnected();
	}
	
	
	
	
}
