package com.xsy.newsapp.util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {
	private LruCache<String, Bitmap> cache;
	
	public BitmapCache() {
		//��ȡʹ���ڴ�����ֵ, ����������ڴ��ֵ��ϵͳ���׳�OutOfMemory�쳣
		//��ʹ���ڴ�İ˷�һ��Ϊ����Ĵ�С
		int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024) / 8;
		cache = new LruCache<String, Bitmap>(maxSize) {
			/**
			 * ��дsizeOf����,������ÿ��ͼƬ�Ĵ�С
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
