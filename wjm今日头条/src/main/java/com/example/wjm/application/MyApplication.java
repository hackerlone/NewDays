package com.example.wjm.application;

import android.app.Application;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.wjm.util.BitmapCache;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by: Lone on 2016/5/22.
 * Contact: 4951048@qq.com
 */
public class MyApplication extends Application {
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private SharedPreferences sp;
    private SharedPreferences.Editor mEditor;
    private List<String> type;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
        mImageLoader = new ImageLoader(mRequestQueue, new BitmapCache());
        sp = getSharedPreferences("type", MODE_PRIVATE);
        mEditor = sp.edit();
        type = new ArrayList<String>();
        initTitle();
    }

    private void initTitle() {
        type.add("推荐");
        type.add("热点");
        type.add("社会");
        type.add("国际");
        type.add("体育");
        type.add("科技");
        type.add("财经");
        type.add("汽车");
        for (int i = 0; i < type.size(); i++) {
            mEditor.putString("my"+i, (String) type.get(i));
        }
        mEditor.putInt("mysize", type.size());
        mEditor.commit();
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public SharedPreferences getSp() {
        return sp;
    }

    public SharedPreferences.Editor getEditor() {
        return mEditor;
    }

    public List<String> getType() {
        return type;
    }
}
