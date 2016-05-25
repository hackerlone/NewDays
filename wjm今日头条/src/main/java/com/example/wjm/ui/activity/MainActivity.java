package com.example.wjm.ui.activity;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wjm.R;
import com.example.wjm.adapter.pagerAdpater;
import com.example.wjm.application.MyApplication;
import com.example.wjm.ui.fragment.guojiFragment;
import com.example.wjm.ui.fragment.redianFragment;
import com.example.wjm.ui.fragment.shehuiFragment;
import com.example.wjm.ui.fragment.tuijianFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private FrameLayout title;
    private SharedPreferences sp;
    String TAG = "info";
    private ViewPager content;
    private pagerAdpater mpagerAdpater;
    private ArrayList<Fragment> list;
    private static final int current = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        title.addView(initTitle());

        list = new ArrayList<Fragment>();
        list.add(new tuijianFragment());
        list.add(new redianFragment());
        list.add(new shehuiFragment());
        list.add(new guojiFragment());

        mpagerAdpater = new pagerAdpater(getSupportFragmentManager(), list);
        content.setAdapter(mpagerAdpater);
        content.setCurrentItem(current);
    }

    private void initView(){
        title = (FrameLayout) findViewById(R.id.title);
        content = (ViewPager) findViewById(R.id.contend);
        sp = ((MyApplication)getApplication()).getSp();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private View initTitle(){
        LinearLayout titles = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        titles.setLayoutParams(params);
        params1.setMargins(50,10,0,0);
        for (int i = 0; i < sp.getInt("mysize",0); i++) {
            final TextView text = new TextView(this);
            text.setText(sp.getString("my"+i,null));
            text.setTextSize(18);
            text.setBackground(getResources().getDrawable(R.drawable.text_title));
            text.requestFocus();
           // text.setLayoutParams(params1);
            final int finalI = i;
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    content.setCurrentItem(finalI);
//                    ((TextView)v).setSelected(true);
                }
            });

            titles.addView(text,params1);
        }

        return titles;
    }
}
