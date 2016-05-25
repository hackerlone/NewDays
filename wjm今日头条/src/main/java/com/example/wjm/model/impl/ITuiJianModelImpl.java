package com.example.wjm.model.impl;

import com.example.wjm.model.ITuiJianModel;

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
public class ITuiJianModelImpl implements ITuiJianModel {
    @Override
    public List<Map<String, String>> loadTuiJian() {
        String url = "http://news.sina.cn/?vt=4&pos=108";
        Document doc = null;
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            doc = Jsoup.connect(url).get();
            Elements elements = doc.select("section[data-sudaclick=yaowen]").select("a.carditems");
            for (Element e : elements) {
                Map<String, String> map = new HashMap<String, String>();
                Elements e01 = e.select("dt.f_card_dt > img"); //img图片信息
                for (Element e011 : e01) {
                    map.put("recommandDescURL", e.attr("href"));
                    map.put("recommandSingleImageView", e011.attr("data-src"));
                }
                Elements e02 = e.select("h3.f_card_h3"); //新闻的标题
                for (Element e022 : e02) {
                    map.put("recommandTitleTextView", e022.text());
                }
                Elements e03 = e.select("p.f_card_p"); //新闻的描述
                for (Element e033 : e03) {
                    map.put("recommandDescTextView", e033.text());
                }
                list.add(map);
                list.add(map);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
