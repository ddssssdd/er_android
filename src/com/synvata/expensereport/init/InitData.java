package com.synvata.expensereport.init;

import android.content.Context;

public class InitData {
	
	private Context _context; 
	public InitData(Context c)
	{
		_context = c;
	}
	public void Init()
	{
		new InitReportStatus(_context);
		new InitPurpose(_context);
		new InitReportService(_context);
	}

}
