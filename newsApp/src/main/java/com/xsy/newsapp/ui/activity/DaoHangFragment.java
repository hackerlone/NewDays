package com.xsy.newsapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xsy.newsapp.R;

public class DaoHangFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View daohangLayout=inflater.inflate(R.layout.shipping_layout,container,false);
		return daohangLayout;
	}
}
