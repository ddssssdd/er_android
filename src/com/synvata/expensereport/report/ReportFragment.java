package com.synvata.expensereport.report;

import java.util.List;
import java.util.Map;
import com.synvata.expensereport.R;
import com.synvata.expensereport.model.ExpenseReport;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ReportFragment extends Fragment {
	public List<Object> _reports;
	private ListView _listview;
	private ReportAdapter _adapter;
	
	@Override
	public void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		_reports = ((List<Object>) getArguments().getSerializable("data"));
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_report,	container,false);
		_listview = (ListView)view.findViewById(R.id.listview);
		_adapter = new ReportAdapter(this.getActivity());
		_listview.setAdapter(_adapter);
		return view;
	}
	protected void onListItemClick(View view,int index){
		
	}
	
	protected void setupListItem(ViewHolder holder,ExpenseReport info){
		//String detail = info.PeriodBeginDate.substring(0, 10)+" - "+info.PeriodEndDate.substring(0,10);
		holder.title.setText(info.Name);
		holder.detail.setText(info.detail());
		holder.action.setText(info.Description);
	}
	
	protected void initListItem(ViewHolder holder,View convertView){
		holder.title = (TextView)convertView.findViewById(R.id.txt_listitem_detail_title);
		holder.detail = (TextView)convertView.findViewById(R.id.txt_listitem_detail_detail);
		holder.action = (TextView)convertView.findViewById(R.id.txt_listitem_detail_right);
		convertView.setTag(holder);
//		convertView.setBackgroundDrawable(R.drawable.corner_list_item);
//		convertView.setBackgroundResource(R.drawable.bk2);
	}
	class ViewHolder{
		
		public TextView title;
		public TextView detail;
		public TextView action;
	}
	public class ReportAdapter extends BaseAdapter
	{
		private LayoutInflater mInflater = null;
		public ReportAdapter(Context context){
			this.mInflater = LayoutInflater.from(context);
		}
		
		@Override
		public int getCount() {
			if (_reports==null)
				return 0;
			else
				return _reports.size();
		}

		@Override
		public Object getItem(int position) {
	
			return position;
		}

		@Override
		public long getItemId(int position) {
	
            return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView==null){
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.listitem_report, null);
				initListItem(holder,convertView);
				
			}else{
				holder = (ViewHolder)convertView.getTag();
			}
			ExpenseReport info = (ExpenseReport)_reports.get(position);
			setupListItem(holder,info);
			return convertView;
		}
		
	}
}
