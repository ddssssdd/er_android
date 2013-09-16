package com.synvata.expensereport.profile;

import java.util.List;

import com.synvata.expensereport.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
	public List<CellData> _items;
	private ListView _listview;
	private ProfileAdapter _adapter;
	
	@Override
	public void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		_items = ((List<CellData>) getArguments().getSerializable("data"));
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_report,	container,false);
		_listview = (ListView)view.findViewById(R.id.listview);
		_adapter = new ProfileAdapter(this.getActivity());
		_listview.setAdapter(_adapter);
		return view;
	}
	protected void onListItemClick(View view,int index){
		
	}
	
	protected void setupListItem(ViewHolder holder,CellData info){
		holder.title.setText(info.Title);
		holder.detail.setText(info.Detail);
		
	}
	
	protected void initListItem(ViewHolder holder,View convertView){
		holder.title = (TextView)convertView.findViewById(R.id.txt_left);
		holder.detail = (TextView)convertView.findViewById(R.id.txt_right);
		
		convertView.setTag(holder);
//		convertView.setBackgroundDrawable(R.drawable.corner_list_item);
//		convertView.setBackgroundResource(R.drawable.bk2);
	}
	class ViewHolder{
		
		public TextView title;
		public TextView detail;
		
	}
	public class ProfileAdapter extends BaseAdapter
	{
		private LayoutInflater mInflater = null;
		public ProfileAdapter(Context context){
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
				convertView = mInflater.inflate(R.layout.listitem_leftright, null);
				initListItem(holder,convertView);
				
			}else{
				holder = (ViewHolder)convertView.getTag();
			}
			CellData info = (CellData)_items.get(position);
			setupListItem(holder,info);
			return convertView;
		}
		
	}
}
