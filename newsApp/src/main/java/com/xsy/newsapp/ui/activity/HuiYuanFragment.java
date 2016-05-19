package com.xsy.newsapp.ui.activity;

import com.xsy.newsapp.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HuiYuanFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View huiyuanLayout=inflater.inflate(R.layout.huiyuan_layout,container,false);
		return huiyuanLayout;
	}
}
