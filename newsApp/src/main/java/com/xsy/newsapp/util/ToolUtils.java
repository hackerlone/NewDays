package com.xsy.newsapp.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ToolUtils {
   public static boolean isNetWorkAvailable(Activity activity){
	   Context context = activity.getApplicationContext();
		// ��ȡ�ֻ��������ӹ�����󣨰�����wi-fi,net�����ӵĹ���
 ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
 if(connectivityManager==null){
	 return false;
 }else {
	 // ��ȡNetworkInfo����
	 NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
	 for(NetworkInfo networkInfo : networkInfos){
			
//				Log.i("test", "===״̬==="
//						+ networkInfo.getState());
//				Log.i("test","===����==="
//						+ networkInfo.getTypeName());
				// �жϵ�ǰ����״̬�Ƿ�Ϊ����״̬
		 if(networkInfo.getState()==NetworkInfo.State.CONNECTED){
			 return true;
		 }
				
	 }
}
	   return false;
	   
   } 
}
