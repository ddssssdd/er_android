package com.synvata.expensereport.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import android.util.Log;

public class HttpSettings {
	public static boolean isOutputDebug = true;
	public static final int READ_TIMEOUT = 10;
	public static final int CONNECT_TIMEOUT = 15;
	
	
	public static final String ServerUrl = "http://10.4.30.190:4205/api/";
	
	
	public static String readInputStream(InputStream stream) throws IOException,UnsupportedEncodingException{
		
		Reader reader =null;
		reader = new InputStreamReader(stream,"UTF-8");
		char[] buffer = new char[256];
		StringBuilder sb = new StringBuilder();
		while (reader.read(buffer)!=-1)
		{
			sb.append(buffer);
		}
		return sb.toString();
	}
	public static String getOutputParameters(List<NameValuePair> params){
		
		
		StringBuilder result = new StringBuilder();
	    boolean first = true;
	    try
	    {
	    	for (NameValuePair pair : params)
		    {
		        if (first)
		            first = false;
		        else
		            result.append("&");

		        result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
		        result.append("=");
		        result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
		    }

	    	
	    }catch( UnsupportedEncodingException e){
	    	log(e.getMessage());
	    }
	    
	    return result.toString();
		
	}
	public static void log(String logInformation)
	{
		if (HttpSettings.isOutputDebug){
			Log.d("Http.Information", logInformation);
		}
		
	}
	public static boolean isSuccessJSON(final JSONObject json)
	{
		try
		{
			if (json.has("status") && !json.isNull("status")){
				return json.getBoolean("status");
			}
			
			
		}catch(Exception e)
		{
			log(e.getMessage());
		}
		return false;
	}
}
