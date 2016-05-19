package com.xsy.newsapp.util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {
	private LruCache<String, Bitmap> cache;
	
	public BitmapCache() {
		//获取使用内存的最大值, 如果超过此内存的值则系统会抛出OutOfMemory异常
		//将使用内存的八分一作为缓存的大小
		int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024) / 8;
		cache = new LruCache<String, Bitmap>(maxSize) {
			/**
			 * 重写sizeOf方法,来计算每张图片的大小
			 */
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return super.sizeOf(key, value);
			}
		};
	}

	@Override
	public Bitmap getBitmap(String url) {
		return cache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		cache.put(url, bitmap);
	}

}
