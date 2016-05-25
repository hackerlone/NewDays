package com.example.wjm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.wjm.R;
import com.example.wjm.application.MyApplication;

import java.util.List;
import java.util.Map;

/**
 * Created by: Lone on 2016/5/23.
 * Contact: 4951048@qq.com
 */
public class TuijianListAdapter extends BaseAdapter {
    private List<Map<String, String>> list;
    private int layoutId;
    private LayoutInflater inflater;
    private ImageLoader imageLoader;

    public TuijianListAdapter(Context context, List<Map<String, String>> list, int layoutId) {
        this.list = list;
        this.layoutId = layoutId;
        this.inflater = LayoutInflater.from(context);
        if (context instanceof Activity) {
            //判断当前的对象是由哪个类初始化的
            //Context是Activity的父类，如果context对象是由Context context = mainActivity
            MyApplication mainApplication = (MyApplication) ((Activity) context).getApplication();
            this.imageLoader = mainApplication.getImageLoader();

        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            view = inflater.inflate(R.layout.listview_adapter, parent, false);
        } else {
            view = convertView;
        }
        final Map<String, String> map = list.get(position);
        if (map == null) {
            return null;
        }
        TextView title = (TextView) view.findViewById(R.id.recommandTitleTextView);
        TextView desc = (TextView) view.findViewById(R.id.recommandDescTextView);
        ImageView iv_img = (ImageView) view.findViewById(R.id.iv_img);
        LinearLayout ll_item = (LinearLayout) view.findViewById(R.id.ll_item);

        title.setText(map.get("recommandTitleTextView"));
        desc.setText(map.get("recommandDescTextView"));

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv_img, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        imageLoader.get(map.get("recommandSingleImageView"), listener);
        ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;

    }
}
