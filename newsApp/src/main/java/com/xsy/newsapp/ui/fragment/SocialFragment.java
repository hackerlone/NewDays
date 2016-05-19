package com.xsy.newsapp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.xsy.newsapp.R;
import com.xsy.newsapp.adapter.ImageAdapter;
import com.xsy.newsapp.presenter.RecommandPresenter;
import com.xsy.newsapp.ui.activity.WebViewActivity;
import com.xsy.newsapp.ui.view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SocialFragment extends Fragment implements MainView{

	private ListView socialListView;
	private List<Map<String,String>> list;
	private ImageAdapter imageAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, container, false);
		socialListView = (ListView) view.findViewById(R.id.listview);
		list = new ArrayList<Map<String,String>>();
		
		//imageAdapter = new ImageAdapter(getActivity(), list, R.layout.listview_recommand);
		
//		MyAdapter adapter = new MyAdapter(getActivity());
//	recommandListView.setAdapter(adapter);
		socialListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                   Intent intent=new Intent(getActivity(),WebViewActivity.class);
                     intent.putExtra("url", list.get(position).get("recommandUrlTextView"));
                   startActivity(intent);
                      
			}
		});
		new LoadTask().execute();
		
		return view;
	}
	
	class LoadTask extends AsyncTask<Void, Void, List<Map<String, String>>> {

		@Override
		protected List<Map<String, String>> doInBackground(Void... params) {
			
			RecommandPresenter rp = new RecommandPresenter(SocialFragment.this); 
			rp.loadSocial();			
			return list;
		}
		
		@Override
		protected void onPostExecute(List<Map<String, String>> result) {
//			super.onPostExecute(result);
//			imageAdapter.notifyDataSetChanged();
//			Log.v("====", ""+list);
			updateListView();
		}
		
	}
	
	class MyAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		
		public MyAdapter(Context context) {
			inflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = null;
			if (convertView == null) {
				view = inflater.inflate(R.layout.fragment_layout, parent, false);
			} else {
				view = convertView;
			}
			return view;
		}
		
	}

	@Override
	public void loadRecommand(List<Map<String, String>> list) {
		this.list = list;
	}
	
	private void updateListView() {
		imageAdapter = new ImageAdapter(getActivity(), this.list, R.layout.list_item);
		socialListView.setAdapter(imageAdapter);
	}

	@Override
	public void loadSocial(List<Map<String, String>> list) {
		this.list = list;
		
	}

	@Override
	public void loadSports(List<Map<String, String>> list) {
		this.list = list;
		
	}

	@Override
	public void loadHot(List<Map<String, String>> list) {
		this.list = list;
	}

	@Override
	public void loadEntertainment(List<Map<String, String>> list) {
		this.list = list;
		
	}

	@Override
	public void loadTechnology(List<Map<String, String>> list) {
		this.list = list;
		
	}
}
