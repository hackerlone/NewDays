package com.example.lenovo.daynewsjsoup.application;

import android.app.Application;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.daynewsjsoup.util.BitmapCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Lone on 2016/5/20.
 * Contact: 4951048@qq.com
 */
public class MainApplication extends Application {
    private RequestQueue mQueue;
    private ImageLoader imageLoader;
    private SharedPreferences sp;
    private boolean flag;
    private List<String> myChannel;
    private List<String> channelTuiJian;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();
        mQueue = Volley.newRequestQueue(this);
        imageLoader = new ImageLoader(mQueue, new BitmapCache());
        sp = getSharedPreferences("type", MODE_PRIVATE);
        flag = sp.getBoolean("flag", false);
        editor = sp.edit();
        if (!flag) {
            initTitle();
        }
    }

    private void initTitle() {
        myChannel = new ArrayList<String>();
        channelTuiJian = new ArrayList<String>();
        // 我的频道
        myChannel.add("推荐");
        myChannel.add("热点");
        myChannel.add("社会");
        myChannel.add("国际");
        myChannel.add("体育");
        myChannel.add("科技");
        myChannel.add("财经");
        myChannel.add("汽车");
        // 所有频道
        channelTuiJian.add("精选");
        channelTuiJian.add("电影");
        channelTuiJian.add("数码");
        channelTuiJian.add("游戏");
        channelTuiJian.add("数码");
        channelTuiJian.add("美食");
        channelTuiJian.add("数码");
        channelTuiJian.add("育儿");
        channelTuiJian.add("旅游");
        channelTuiJian.add("搞笑");
        channelTuiJian.add("美女");
        for (int i = 0; i < myChannel.size(); i++) {
            editor.putString("my"+i,myChannel.get(i));
        }
        for (int j = 0; j < channelTuiJian.size(); j++) {
            editor.putString("all"+j,channelTuiJian.get(j));
        }
        editor.putInt("mySize",myChannel.size());
        editor.putInt("allSize",channelTuiJian.size());
        editor.putBoolean("flag", true);
        editor.commit();
    }


    public SharedPreferences getsp() {
        return sp;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public RequestQueue getQueue() {
        return mQueue;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
