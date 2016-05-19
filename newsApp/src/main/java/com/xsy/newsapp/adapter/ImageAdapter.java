package com.xsy.newsapp.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.xsy.newsapp.R;
import com.xsy.newsapp.application.MainApplication;

import java.util.List;
import java.util.Map;

public class ImageAdapter extends BaseAdapter {
	private List<Map<String, String>> list;
	private ImageLoader imageLoader;
	private LayoutInflater inflater;
	private int layoutId;

	public ImageAdapter(Activity activity, List<Map<String, String>> list,
			int layoutId) {
		this.list = list;
		this.layoutId = layoutId;
		this.inflater = LayoutInflater.from(activity);
		this.imageLoader = ((MainApplication) activity.getApplication())
				.getImageLoader();
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

	private class Holver {
		ImageView recommandTopImgView;
		ImageView recommandSingleImageView;
		TextView recommandTitleTextView;
		TextView recommandDescTextView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Holver holver = null;
		if (convertView == null) {
			convertView = inflater.inflate(layoutId, parent, false);
			holver = new Holver();
			holver.recommandTopImgView = (ImageView) convertView
					.findViewById(R.id.recommandTopImgView);
			holver.recommandSingleImageView = (ImageView) convertView
					.findViewById(R.id.recommandSingleImageView);
			holver.recommandTitleTextView = (TextView) convertView
					.findViewById(R.id.recommandTitleTextView);
			holver.recommandDescTextView = (TextView) convertView
					.findViewById(R.id.recommandDescTextView);
			convertView.setTag(holver);
		} else {
			holver = (Holver) convertView.getTag();
		}
		Map<String, String> map = list.get(position);
		if (map == null) {
			return convertView;
		}
		
		holver.recommandDescTextView.setText(map.get("recommandDescTextView"));
		holver.recommandTitleTextView.setText(map.get("recommandTitleTextView"));

		if (!TextUtils.isEmpty(map.get("recommandSingleImageView"))) {
			ImageListener listener = ImageLoader.getImageListener(
					holver.recommandSingleImageView,
					android.R.drawable.ic_menu_rotate,
					android.R.drawable.ic_delete);
			imageLoader.get(map.get("recommandSingleImageView"), listener);
		} else if (!TextUtils.isEmpty(map.get("recommandTopImgView"))) {
			ImageListener listener = ImageLoader.getImageListener(
					holver.recommandTopImgView, android.R.drawable.ic_menu_rotate,
					android.R.drawable.ic_delete);
			imageLoader.get(map.get("recommandTopImgView"), listener);
			holver.recommandTopImgView.setVisibility(View.VISIBLE);
		}
		
		return convertView;
	}

}
