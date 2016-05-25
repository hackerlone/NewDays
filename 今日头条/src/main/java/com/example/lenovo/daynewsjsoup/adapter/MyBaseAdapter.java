package com.example.lenovo.daynewsjsoup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.daynewsjsoup.R;
import com.example.lenovo.daynewsjsoup.util.BitmapCache;

import java.util.List;
import java.util.Map;

/**
 * Created by: Lone on 2016/5/22.
 * Contact: 4951048@qq.com
 */
public class MyBaseAdapter extends BaseAdapter {
    private List<Map<String, String>> list;
    private Context context;
    private LayoutInflater linfalte;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    final int VIEW_TYPE = 3;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    final int TYPE_3 = 2;

    public MyBaseAdapter(Context context, List<Map<String, String>> list) {
        super();
        this.context = context;
        this.list = list;
        linfalte = LayoutInflater.from(context);
        requestQueue = Volley.newRequestQueue(context);
        imageLoader = new ImageLoader(requestQueue, new BitmapCache());
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
    public int getItemViewType(int position) {
        int p = position;
//		if (p >= 0)
//			return TYPE_1;
        if (p>=0)
            return TYPE_2;
        else
            return TYPE_2;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    private class Hover {
        ImageView img;
        TextView title;
        TextView desc;
    }


    public View getViewView(int position, View convertView, ViewGroup parent) {
        Hover hover;
        int type = getItemViewType(position);
        Map<String, String> map = list.get(position);
        switch (type) {
            case TYPE_1:
                if (convertView == null) {
                    convertView = linfalte.inflate(R.layout.list_recommand, null);
                    hover = new Hover();
                    convertView.findViewById(R.id.item2).setVisibility(View.GONE);
                    convertView.findViewById(R.id.item3).setVisibility(View.GONE);
                    hover.img = (ImageView) convertView.findViewById(R.id.item1img);
                    hover.title = (TextView) convertView
                            .findViewById(R.id.item1title);
                    convertView.setTag(hover);
                } else {
                    hover = (Hover) convertView.getTag();
                }
                String url2 = map.get("recommandSingleImageView");
                hover.title.setText(map.get("recommandTitleTextView"));
                ImageLoader.ImageListener listener2 = imageLoader.getImageListener(hover.img,
                        R.drawable.ic_launcher,

                        R.drawable.ic_launcher);
                imageLoader.get(url2, listener2);
                break;
            case TYPE_2:
                if (convertView == null) {
                    convertView = linfalte.inflate(R.layout.list_recommand, null);
                    hover = new Hover();
                    convertView.findViewById(R.id.item1).setVisibility(View.GONE);
                    convertView.findViewById(R.id.item2).setVisibility(View.GONE);
                    hover.img = (ImageView) convertView.findViewById(R.id.item_img);
                    hover.title = (TextView) convertView
                            .findViewById(R.id.item_titel);
                    hover.desc = (TextView) convertView
                            .findViewById(R.id.item_desc);
                    convertView.setTag(hover);
                } else {
                    hover = (Hover) convertView.getTag();
                }
                String url = map.get("recommandSingleImageView");
                hover.title.setText(map.get("recommandTitleTextView"));
                hover.desc.setText(map.get("recommandDescTextView"));
                ImageLoader.ImageListener listener = imageLoader.getImageListener(hover.img,
                        R.drawable.ic_launcher, R.drawable.ic_launcher);
                imageLoader.get(url, listener);
                break;

            case TYPE_3:
                if (convertView == null) {
                    convertView = linfalte.inflate(R.layout.list_recommand, null);
                    hover = new Hover();
                    convertView.findViewById(R.id.item1).setVisibility(View.GONE);
                    convertView.findViewById(R.id.item3).setVisibility(View.GONE);
                    hover.img = (ImageView) convertView.findViewById(R.id.item1img);
                    hover.title = (TextView) convertView
                            .findViewById(R.id.item1title);
                    convertView.setTag(hover);
                } else {
                    hover = (Hover) convertView.getTag();
                }
                String url3 = map.get("recommandSingleImageView");
                hover.title.setText(map.get("recommandTitleTextView"));
                ImageLoader.ImageListener listener3 = imageLoader.getImageListener(hover.img,
                        R.drawable.ic_launcher,

                        R.drawable.ic_launcher);
                imageLoader.get(url3, listener3);
                break;
        }

        return convertView;
    }

}
