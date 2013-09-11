package com.synvata.expensereport.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

public class HttpExecuteGetTask extends AsyncTask<String, Void, String> {
	private static final String DEBUG_TAG = "Http.Get";	
	@Override
	protected String doInBackground(String... urls) {
		try{
			return httpGetUrl(urls[0]);
		}catch(Exception e){
			
			return "Unable to retrieve the url. URL may be invalid. return:"+e.getMessage();
		}
	}

	@Override
	protected void onPostExecute(String result) {
		
	}
	private String httpGetUrl(final String urlString) throws IOException
	{
		InputStream is = null;
		try
		{
			URL url = new URL(HttpSettings.ServerUrl+urlString);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setReadTimeout(1000*HttpSettings.READ_TIMEOUT);
			conn.setConnectTimeout(1000*HttpSettings.CONNECT_TIMEOUT);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.connect();
			int response = conn.getResponseCode();			
			is = conn.getInputStream();
			String result = HttpSettings.readInputStream(is);
			HttpSettings.log(result);
			return result;
		}
		finally
		{
			if (is!=null)
				is.close();
			
		}
	}
	
}
