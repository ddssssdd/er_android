package com.synvata.expensereport.components;

import com.synvata.expensereport.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class PopupChoose {
	private Context _context;
	public PopupChoose(Context context)
	{
		_context = context;
	}
	public void simple(final String[] choices,final OnChooseItem callback)
	{

		// Wrap our context to inflate list items using correct theme
		final Context dialogContext = new ContextThemeWrapper(_context,
				android.R.style.Theme_Light);
		String cancel = "Cancel";
		
		final ListAdapter adapter = new ArrayAdapter<String>(dialogContext,
				android.R.layout.simple_list_item_1, choices);

		final AlertDialog.Builder builder = new AlertDialog.Builder(
				dialogContext);
		builder.setTitle(_context.getResources().getString(R.string.choose));
		builder.setSingleChoiceItems(adapter, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						callback.onItemClick(which);
					}
				});
		builder.setNegativeButton(cancel,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}

				});
		builder.create().show();
	}
	public interface OnChooseItem
	{
		void onItemClick(final int index);
	}
	
}
