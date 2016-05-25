package com.example.wjm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by: Lone on 2016/5/22.
 * Contact: 4951048@qq.com
 */
public class pagerAdpater extends FragmentPagerAdapter {
    ArrayList<Fragment> list;
    public pagerAdpater(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }
}
