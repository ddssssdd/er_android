package com.synvata.expensereport.expense;

import java.util.List;

import com.synvata.expensereport.R;
import com.synvata.expensereport.base.KeyValue;
import com.synvata.expensereport.model.VW_Expense;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ExpenseFragment extends Fragment {
	public List<Object> _items;
	private ListView _listview;
	private ExpenseAdapter _adapter;
	private int index;
	@Override
	public void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		_items = ((List<Object>) getArguments().getSerializable("data"));
		index = getArguments().getInt("index");
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_report,	container,false);
		_listview = (ListView)view.findViewById(R.id.listview);
		_adapter = new ExpenseAdapter(this.getActivity());
		_listview.setAdapter(_adapter);
		return view;
	}
	protected void onListItemClick(View view,int index){
		
	}
	
	protected void setupListItem(ViewHolder holder,Object obj){
		if (index==1){
			VW_Expense info = (VW_Expense)obj;
			holder.title.setText(info.ExpenseCodeDescription);
			holder.detail.setText(info.ExpenseGroupFullName);
			if (info.ReportDate!=null)
				holder.action.setText(info.ReportDate.substring(0, 10));
			
		}else{
			KeyValue info = (KeyValue)obj;
			holder.title.setText(info.key);
			holder.detail.setText(info.value);
		}
	}
	
	protected void initListItem(ViewHolder holder,View convertView){
		if (index==1){
			holder.title = (TextView)convertView.findViewById(R.id.txt_listitem_detail_title);
			holder.detail = (TextView)convertView.findViewById(R.id.txt_listitem_detail_detail);
			holder.action = (TextView)convertView.findViewById(R.id.txt_listitem_detail_right);
		}else{
			holder.title = (TextView)convertView.findViewById(R.id.txt_left);
			holder.detail = (TextView)convertView.findViewById(R.id.txt_right);
		}
		convertView.setTag(holder);

	}
	class ViewHolder{
		
		public TextView title;
		public TextView detail;
		public TextView action;
	}
	public class ExpenseAdapter extends BaseAdapter
	{
		private LayoutInflater mInflater = null;
		public ExpenseAdapter(Context context){
			this.mInflater = LayoutInflater.from(context);
		}
		
		@Override
		public int getCount() {
			if (_items==null)
				return 0;
			else
				return _items.size();
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
				if (index==1)
					convertView = mInflater.inflate(R.layout.listitem_report, null);
				else
					convertView = mInflater.inflate(R.layout.listitem_leftright, null);
				initListItem(holder,convertView);
				
			}else{
				holder = (ViewHolder)convertView.getTag();
			}
			
			setupListItem(holder,_items.get(position));
			return convertView;
		}
		
	}
}
