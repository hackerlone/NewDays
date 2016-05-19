package com.example.lenovo.daynewsjsoup.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by: Lone on 2016/5/18.
 * Contact: 4951048@qq.com
 * 判断网络连接状态
 */
public class ToolUtils {
    public static boolean isNetWorkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(conn == null){
            return false;
        }else{
            // 获取NetworkInfo对象
            NetworkInfo [] networkInfo = conn.getAllNetworkInfo();
            if(networkInfo != null && networkInfo.length > 0){
                for (int i = 0; i < networkInfo.length; i++) {
                    //				Log.i("test", "===状态==="
//						+ networkInfo.getState());
//				Log.i("test","===类型==="
//						+ networkInfo.getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if(networkInfo[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
