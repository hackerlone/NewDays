package com.example.lenovo.daynewsjsoup.ui.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.lenovo.daynewsjsoup.R;
import com.example.lenovo.daynewsjsoup.application.MainApplication;
import com.example.lenovo.daynewsjsoup.util.ThemeUtils;

/**
 * Created by: Lone on 2016/5/21.
 * Contact: 4951048@qq.com
 */
public class MyActivity extends Activity {
    private ToggleButton mode;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeUtils.getTheme(this);
        setContentView(R.layout.my_layout);
        mode = (ToggleButton) findViewById(R.id.mode);
        sp = ((MainApplication)getApplication()).getsp();
        mode.setChecked(sp.getBoolean("ischecked",false));
        mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ThemeUtils.changeTheme(MyActivity.this, isChecked);
            }
        });
    }
}
