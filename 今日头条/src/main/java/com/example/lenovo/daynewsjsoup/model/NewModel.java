package com.example.lenovo.daynewsjsoup.model;

import java.util.List;
import java.util.Map;

/**
 * Created by: Lone on 2016/5/18.
 * Contact: 4951048@qq.com
 */
public interface NewModel {
    public List<Map<String, String>> recommandModel(String url, String label);
}
