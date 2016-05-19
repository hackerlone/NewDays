package com.xsy.newsapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xsy.newsapp.R;

public class WoDeFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View wodeLayout=inflater.inflate(R.layout.wode_layout,container,false);
		return wodeLayout;
	}
}
