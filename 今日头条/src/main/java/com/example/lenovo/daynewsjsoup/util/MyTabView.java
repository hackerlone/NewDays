package com.example.lenovo.daynewsjsoup.util;

import android.content.Context;
import android.widget.TextView;

public class MyTabView extends TextView {

	public int index;
	
    public MyTabView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
    
    public MyTabView(Context context, int index) {
          	super(context);
    	  	this.index = index;
    }
}
