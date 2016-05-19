package com.xsy.newsapp.ui.activity;

import java.util.ArrayList;
import java.util.List;

import com.xsy.newsapp.R;
import com.xsy.newsapp.ui.fragment.CarsFragment;
import com.xsy.newsapp.ui.fragment.EconomicsFragment;
import com.xsy.newsapp.ui.fragment.EntertainmentFragment;
import com.xsy.newsapp.ui.fragment.HotFragment;
import com.xsy.newsapp.ui.fragment.RecommandFragment;
import com.xsy.newsapp.ui.fragment.SocialFragment;
import com.xsy.newsapp.ui.fragment.SportsFragment;
import com.xsy.newsapp.ui.fragment.TechnologyFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TuiJianFragment extends Fragment{
	private ViewPager viewPager;
	private List<Fragment> list;
	private MyFragmentPagerAdapter adapter;
	private TextView more;
	private int[] columnTab = {R.id.recommand, R.id.hot, R.id.social, R.id.entertainment, R.id.sports, R.id.technology, R.id.economics, R.id.cars};
	private TextView[] columnTabTextView;
	private Context TuiJianFragment;
	private View tuijianLayout;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		tuijianLayout=inflater.inflate(R.layout.shouye_layout,container,false);
		initColumnTextView();
	    initView();
	    initListener();
		return tuijianLayout;
		
	}
	
	
	
	
	
	private void initColumnTextView() {
		findViewById();
	}





	private void findViewById() {
		columnTabTextView = new TextView[columnTab.length];
		for (int i = 0;i < columnTab.length; i++) {
			columnTabTextView[i] = (TextView) tuijianLayout.findViewById(columnTab[i]);
		}
		
	}



	@SuppressWarnings("deprecation")
	private void initView() {
		viewPager = (ViewPager) tuijianLayout. findViewById(R.id.viewpager);
		more=(TextView) tuijianLayout.findViewById(R.id.more);
		list = new ArrayList<Fragment>();
		list.add(new RecommandFragment());
		list.add(new HotFragment());
		list.add(new SocialFragment());
		list.add(new EntertainmentFragment());
		list.add(new SportsFragment());
		list.add(new TechnologyFragment());
		list.add(new EconomicsFragment());
		list.add(new CarsFragment());
		
		adapter = new MyFragmentPagerAdapter(getFragmentManager(), list);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				viewPager.setCurrentItem(arg0);
				selectColumnTab(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}
	
/*	private FragmentManager getSupportFragmentManager() {
		// TODO Auto-generated method stub
		return null;
	}*/





	private void selectColumnTab(int position) {
		for (int i = 0; i < columnTabTextView.length; i++) {
			if (i == position) {
				columnTabTextView[i].setTextColor(getResources().getColorStateList(R.color.top_text_color));
			} else {
				columnTabTextView[i].setTextColor(getResources().getColorStateList(R.color.top_text_color_foucs));
			}
		}
	}
	
	private void initListener() {
		for (int i = 0; i < columnTabTextView.length; i++) {
			columnTabTextView[i].setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					for (int i = 0; i < columnTab.length; i++) {
						if (v.getId() == columnTab[i]) {
							((TextView) v).setTextColor(getResources().getColorStateList(R.color.top_text_color));
							viewPager.setCurrentItem(i);
						} else {
							columnTabTextView[i].setTextColor(getResources().getColorStateList(R.color.top_text_color_foucs));
						}
					}
				}
			});
		}
		more.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

	    Intent intent=new Intent(getActivity(),AddActivity.class);
				startActivity(intent);
			}
		});
		
	}
	
	class MyFragmentPagerAdapter extends FragmentPagerAdapter {
		private List<Fragment> list;

		public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
			super(fm);
			this.list = list;
		}

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			return list.size();
		}
		
	}
}
