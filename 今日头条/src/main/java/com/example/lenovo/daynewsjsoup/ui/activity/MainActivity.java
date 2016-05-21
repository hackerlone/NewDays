package com.example.lenovo.daynewsjsoup.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lenovo.daynewsjsoup.R;
import com.example.lenovo.daynewsjsoup.adapter.MyFragmentManager;
import com.example.lenovo.daynewsjsoup.application.MainApplication;
import com.example.lenovo.daynewsjsoup.util.MyIndicator;
import com.example.lenovo.daynewsjsoup.util.ThemeUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private MyIndicator indicator;
    private TextView more;
    private ViewPager mContent;
    private RadioGroup radioGroup;
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);//跳转动画
        ThemeUtils.getTheme(this);
        setContentView(R.layout.activity_main);

        initView();

        List<String> titles=new ArrayList<String>();
        int mysize=sp.getInt("mySize", 0);
        for(int i=0;i<mysize;i++){
            String title=sp.getString("my"+i, "");
            titles.add(title);
        }
        //适配器
        FragmentPagerAdapter adapter = new MyFragmentManager(getSupportFragmentManager(), titles);
        mContent.setAdapter(adapter);
        //添加viewPager
        indicator.setViewPager(mContent);
    }

    private void initView() {
        sp = ((MainApplication)getApplication()).getsp();
        editor = ((MainApplication)getApplication()).getEditor();
        indicator = (MyIndicator) findViewById(R.id.indicator);
        more = (TextView) findViewById(R.id.more);
        mContent = (ViewPager) findViewById(R.id.mContent);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more:
//                Intent intent=new Intent(MainActivity.this,AddTitelActivity.class);
//                startActivity(intent);
//                finish();
                break;
        }

    }

    public void myOnclick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.radio0:

                break;
            case R.id.radio1:
//                intent = new Intent(MainActivity.this, ShiPinActivity.class);
//                startActivity(intent);
                break;
            case R.id.radio2:
//                intent = new Intent(MainActivity.this, HuaTiActivity.class);
//                startActivity(intent);
                break;
            case R.id.radio3:
                intent = new Intent(MainActivity.this, MyActivity.class);
                startActivity(intent);
//                onBackPressed();
                break;
        }
    }
}
