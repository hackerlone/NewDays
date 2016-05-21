package com.example.lenovo.daynewsjsoup.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by: Lone on 2016/5/21.
 * Contact: 4951048@qq.com
 */
public class MyFragmentManager extends FragmentPagerAdapter {
    List<String> titles;
    public MyFragmentManager(FragmentManager fm, List<String> titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0){
            fragment=new MyFragment(RecommandPresenter.class);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.size();
    }
    public CharSequence getPageTitle(int position) {
        return titles.get(position % titles.size());
    }
}
