package com.example.lenovo.daynewsjsoup.util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by: Lone on 2016/5/18.
 * Contact: 4951048@qq.com
 */
public class BitmapCache implements ImageLoader.ImageCache{
    private LruCache<String,Bitmap> mCache;

    public BitmapCache() {
        mCache = new LruCache<String, Bitmap>(8*1024*1024){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String s) {
        return null;
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {

    }
}
