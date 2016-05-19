package com.xsy.newsapp.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.xsy.newsapp.util.BitmapCache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainApplication extends Application {
	private RequestQueue mQueue;
	private ImageLoader imageLoader;
	private SharedPreferences sp;
	private boolean flag;
	private List<String> myChannel;
	private List<String> channelTuiJian;
	private Editor editor;

	@Override
	public void onCreate() {
		super.onCreate();
		mQueue = Volley.newRequestQueue(this);
		imageLoader = new ImageLoader(mQueue, new BitmapCache());
		sp=getSharedPreferences("items", MODE_PRIVATE);
		editor=sp.edit();
		flag=sp.getBoolean("flag", false);

		if(!flag){
		init();
		}
	}
	
	public RequestQueue getmQueue() {
		return mQueue;
	}
	
	public ImageLoader getImageLoader() {
		return imageLoader;
	}
   
	public SharedPreferences sp(){
		return sp;
	}
	public Editor editor(){
		return editor;
	}
	private void init() {
		myChannel=new ArrayList<String>();
		channelTuiJian=new ArrayList<String>();
		
		myChannel.add("推荐");
		myChannel.add("热点");
		myChannel.add("社会");
		myChannel.add("娱乐");
		myChannel.add("体育");
		myChannel.add("科技");
		myChannel.add("财经");
		myChannel.add("汽车");
		Set<String> my=new HashSet<String>(myChannel);
		channelTuiJian.add("精选");
		channelTuiJian.add("时尚");
		channelTuiJian.add("辟谣");
		channelTuiJian.add("奇葩");
		channelTuiJian.add("育儿");
		channelTuiJian.add("养生");
		channelTuiJian.add("美食");
		channelTuiJian.add("政务");
		channelTuiJian.add("历史");
		channelTuiJian.add("探索");
		channelTuiJian.add("故事");
		channelTuiJian.add("美文");
		channelTuiJian.add("情感");
		channelTuiJian.add("语录");
		channelTuiJian.add("美图");
		channelTuiJian.add("家居");
		channelTuiJian.add("搞笑");
		channelTuiJian.add("星座");
		channelTuiJian.add("文化");
		channelTuiJian.add("教育");
		channelTuiJian.add("旅游");
		channelTuiJian.add("游戏");
		channelTuiJian.add("房产");
		channelTuiJian.add("电影");
		Set<String> tui=new HashSet<String>(channelTuiJian);
		
		editor.putStringSet("myChannel", my);
		editor.putStringSet("channelTuijian", tui);
		editor.putBoolean("flag", true);
		editor.commit();
		
	}

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

