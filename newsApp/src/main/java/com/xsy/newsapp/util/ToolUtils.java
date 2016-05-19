package com.xsy.newsapp.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ToolUtils {
   public static boolean isNetWorkAvailable(Activity activity){
	   Context context = activity.getApplicationContext();
		// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
 ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
 if(connectivityManager==null){
	 return false;
 }else {
	 // 获取NetworkInfo对象
	 NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
	 for(NetworkInfo networkInfo : networkInfos){
			
//				Log.i("test", "===状态==="
//						+ networkInfo.getState());
//				Log.i("test","===类型==="
//						+ networkInfo.getTypeName());
				// 判断当前网络状态是否为连接状态
		 if(networkInfo.getState()==NetworkInfo.State.CONNECTED){
			 return true;
		 }
				
	 }
}
	   return false;
	   
   } 
}
