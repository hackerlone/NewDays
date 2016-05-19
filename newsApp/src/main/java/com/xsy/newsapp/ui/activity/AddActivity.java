package com.xsy.newsapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.xsy.newsapp.R;
import com.xsy.newsapp.application.MainApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddActivity extends Activity implements OnClickListener{
	
	private TextView delete;
    private TextView save;
    private GridView gridView1;
    private GridView gridView2;
    private SimpleAdapter sAdapter1,sAdapter2;
	private List<Map<String, Object>> list2;
	private List<Map<String, Object>> list1;
	private List<String> myChannel,channelTuiJian;
	 private SharedPreferences sp;
	    private SharedPreferences.Editor editor;
	    private MainApplication app;
   
    
	
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_more);
    	initView();
    	
    }
    
    private void initView() {
    	app=(MainApplication) getApplication();
    	sp=app.sp();
    	editor=app.editor();
    	Set<String> my=new HashSet<String>();
    	my=sp.getStringSet("myChannel", my);
    	Set<String> tui=new HashSet<String>();
    	tui=sp.getStringSet("channelTuijian", tui);
    	myChannel=new ArrayList<String>(my);
    	channelTuiJian=new ArrayList<String>(tui);
    	
    	delete=(TextView) findViewById(R.id.delete);
    	save=(TextView) findViewById(R.id.save);
    	delete.setOnClickListener(this);
    	save.setOnClickListener(this);
    	gridView1=(GridView) findViewById(R.id.gridView1);
    	gridView2=(GridView) findViewById(R.id.gridView2);
    	
    	list1=new ArrayList<Map<String,Object>>();
    	list2=new ArrayList<Map<String,Object>>();
    	
    	sAdapter1=new SimpleAdapter(getApplicationContext(), getData1(),
    			R.layout.gridview_item, new String[]{"text"}, new int[]{R.id.text});
    	gridView1.setAdapter(sAdapter1);
    	
    	gridView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                HashMap<String, Object> item= (HashMap<String, Object>) arg0.getItemAtPosition(position);
                 list2.add(item);
                 channelTuiJian.add(item.get("text").toString());
                 list1.remove(position);
                 myChannel.remove(item.get("text").toString());
                 sAdapter1.notifyDataSetChanged();
                 sAdapter2.notifyDataSetInvalidated();
                
			}
		});
    	
    	sAdapter2=new SimpleAdapter(getApplicationContext(), getData2(),
    			R.layout.gridview_item, new String[]{"text"}, new int[]{R.id.text});
    	gridView2.setAdapter(sAdapter2);
    	
    	gridView2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				 HashMap<String, Object> item= (HashMap<String, Object>) arg0.getItemAtPosition(position);
				     list1.add(item);
				     channelTuiJian.remove(item.get("text").toString()); 
	                 list2.remove(position);
	                 myChannel.add(item.get("text").toString());
	                 sAdapter1.notifyDataSetChanged();
	                 sAdapter2.notifyDataSetInvalidated();
	               
	            
				
			}
		});
    }
   
   /* protected void onDestroy() {
		super.onDestroy();
		editor.clear();
		Set<String> my=new HashSet<String>(myChannel);
		Set<String> tui=new HashSet<String>(channelTuiJian);
		editor.putStringSet("myChannel", my);
		editor.putStringSet("channelTuijian", tui);
		editor.commit();
	}*/
   
    private List< Map<String,Object >> getData1() {
		for(int i=0;i<myChannel.size();i++){
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("text", myChannel.get(i));
			list1.add(map);
		}
		return list1;
	}
    
    
	private List< Map<String, Object>> getData2() {
       for(int i=0;i<channelTuiJian.size();i++){
    	   Map<String, Object> map=new HashMap<String, Object>();
    	   map.put("text", channelTuiJian.get(i));
    	   list2.add(map);
    	   
       }

		return list2;
	}

     


	@Override
	public void onClick(View v) {
          switch (v.getId()) {
		case R.id.delete:
			
			Intent intent=new Intent(AddActivity.this,MainActivity.class);
			startActivity(intent);
		//	finish();
			break;
		case R.id.save:
			editor.clear();
			Set<String> my=new HashSet<String>(myChannel);
			Set<String> tui=new HashSet<String>(channelTuiJian);
			editor.putStringSet("myChannel", my);
			editor.putStringSet("channelTuijian", tui);
			editor.commit();
			Toast.makeText(getApplicationContext(), "±£´æ³É¹¦", Toast.LENGTH_SHORT).show();
			break;
		}
  
		
	}

	
    
}
