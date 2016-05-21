package com.example.lenovo.daynewsjsoup.util;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.lenovo.daynewsjsoup.R;
import com.example.lenovo.daynewsjsoup.application.MainApplication;

/**
 * Created by: Lone on 2016/5/21.
 * Contact: 4951048@qq.com
 */
public class ThemeUtils {
    private static int dark_light;
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;
    public static void changeTheme(Activity activity,boolean isChecked){
        sp = ((MainApplication)activity.getApplication()).getsp();
        editor = ((MainApplication)activity.getApplication()).getEditor();
        if(isChecked){
            editor.putInt("dark_light",0);
        }else{
            editor.putInt("dark_light",1);
        }
        editor.putBoolean("ischecked", isChecked);
        editor.commit();
        //重绘当前的activity
//        Intent intent = activity.getIntent();
//        activity.overridePendingTransition(0, 0);
//        activity.finish();
//        activity.overridePendingTransition(0, 0);
//        activity.startActivity(intent);

        //重启应用程序
        final Intent intent1 = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.overridePendingTransition(0, 0);
        activity.startActivity(intent1);

    }

    public static void getTheme(Activity activity){
        sp = ((MainApplication)activity.getApplication()).getsp();
        editor = ((MainApplication)activity.getApplication()).getEditor();
        dark_light = sp.getInt("dark_light", 1);
        switch (dark_light) {
            case 0:
                activity.setTheme(R.style.AppThemeDark);
                break;
            case 1:
                activity.setTheme(R.style.AppTheme);
                break;
        }

    }
}
