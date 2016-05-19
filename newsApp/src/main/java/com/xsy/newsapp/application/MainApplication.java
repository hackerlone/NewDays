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
		
		myChannel.add("�Ƽ�");
		myChannel.add("�ȵ�");
		myChannel.add("���");
		myChannel.add("����");
		myChannel.add("����");
		myChannel.add("�Ƽ�");
		myChannel.add("�ƾ�");
		myChannel.add("����");
		Set<String> my=new HashSet<String>(myChannel);
		channelTuiJian.add("��ѡ");
		channelTuiJian.add("ʱ��");
		channelTuiJian.add("��ҥ");
		channelTuiJian.add("����");
		channelTuiJian.add("����");
		channelTuiJian.add("����");
		channelTuiJian.add("��ʳ");
		channelTuiJian.add("����");
		channelTuiJian.add("��ʷ");
		channelTuiJian.add("̽��");
		channelTuiJian.add("����");
		channelTuiJian.add("����");
		channelTuiJian.add("���");
		channelTuiJian.add("��¼");
		channelTuiJian.add("��ͼ");
		channelTuiJian.add("�Ҿ�");
		channelTuiJian.add("��Ц");
		channelTuiJian.add("����");
		channelTuiJian.add("�Ļ�");
		channelTuiJian.add("����");
		channelTuiJian.add("����");
		channelTuiJian.add("��Ϸ");
		channelTuiJian.add("����");
		channelTuiJian.add("��Ӱ");
		Set<String> tui=new HashSet<String>(channelTuiJian);
		
		editor.putStringSet("myChannel", my);
		editor.putStringSet("channelTuijian", tui);
		editor.putBoolean("flag", true);
		editor.commit();
		
	}

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

