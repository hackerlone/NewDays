package com.example.wjm.model.impl;

import android.util.Log;

import com.example.wjm.model.IReDianModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: Lone on 2016/5/23.
 * Contact: 4951048@qq.com
 */
public class IReDianModelImpl implements IReDianModel {
    @Override
    public List<Map<String, String>> LoadReDian() {
        List<Map<String, String>> list=new ArrayList<Map<String,String>>();
        Document doc =null;
        try {
            doc= Jsoup.connect("http://sina.cn/?vt=4&pos=3").get();
            Elements hot= doc.select("section[data-channel=yaowen]") .select("a");
            for(Element e:hot){
                Map<String, String> map=new HashMap<String, String>();
                Elements img=e.select("dl.f_card > dt.f_card_dt > img");
                for(Element e1:img){
                    map.put("recommandSingleImageView", e1.attr("data-src"));
                    Log.i("info", "===============: "+e1.attr("data-src"));
                }
                Elements title=e.select("h3.f_card_h3")	;
                for(Element e2:title){
                    map.put("recommandTitleTextView", e2.text());
                }
                Elements desc = e.select("p.f_card_p");
                for (Element e3 : desc) {
                    map.put("recommandDescTextView", e3.text());
                }
                Elements a=e.select("a");
                for(Element e4 : a){
                    map.put("recommandUrlTextView", e4.attr("href"));
                }
                list.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
