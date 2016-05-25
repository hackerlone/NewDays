package com.xsy.newsapp.model.imp;

import com.xsy.newsapp.model.NewModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewModelImpl implements NewModel{
    /**
     * 实现推荐专题方法
     */
	@Override
	public List<Map<String, String>> recommandModel() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Document doc = null;

		try {
			doc = Jsoup.connect("http://news.sina.cn/?vt=4&pos=108").get();
			Elements recommand = doc.select("section[data-sudaclick=yaowen]").select("a.carditems");
			for (Element e : recommand) {
				Map<String, String> map = new HashMap<String, String>();
				Elements img = e.select("dt.f_card_dt > img");
				for (Element e1 : img) {
					map.put("recommandSingleImageView", e1.attr("data-src"));
				}
				Elements title = e.select("h3.f_card_h3");
				for (Element e2 : title) {
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
	
    /**
     * 实现热点专题方法     
     */
	
	@Override
	public List<Map<String, String>> hotModel() {
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		Document doc =null;
		try {
			doc=Jsoup.connect("http://sina.cn/?vt=4&pos=3").get();
			Elements hot= doc.select("section[data-channel=yaowen]") .select("a");
			for(Element e:hot){
				Map<String, String> map=new HashMap<String, String>();
				Elements img=e.select("dl.f_card > dt.f_card_dt > img");
				for(Element e1:img){
					map.put("recommandImageTextView", e1.attr("src"));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
    /**
     * 实现社会专题方法    
     */
	
	@Override
	public List<Map<String, String>> socialModel() {
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		Document doc =null;
		try {
			doc=Jsoup.connect("http://news.sina.cn/pl?vt=4&pos=3").get();
			Elements social= doc.select(" div.carditems_box").select("a");
			for(Element e:social){
				Map<String, String> map=new HashMap<String, String>();
				Elements img=e.select("dl.carditems_list>a>img");
				for(Element e1:img){
					map.put("recommandImageTextView", e1.attr("data-src"));
				}
                Elements title=e.select("h3.carditems_list_h3")	;
                for(Element e2:title){
                	map.put("recommandTitleTextView", e2.text());
                }
                Elements desc = e.select("h4.carditems_list_h4");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
    /**
     * 实现体育专题方法  
     */
	
	@Override
	public List<Map<String, String>> sportsModel() {
		List<Map<String, String>> list =new ArrayList<Map<String,String>>();
		Document doc=null;
	try {
			doc=Jsoup.connect("http://sports.sina.cn/?vt=4&pos=108").get();
			Elements sports=doc.select("div.carditems").select("a");
			for(Element e : sports){
				Map<String, String> map=new HashMap<String, String>();
				
				Elements img=e.select("dt.carditems_list_dt > img");
				for(Element e1 : img){
					map.put("recommandSingleImageView", e1.attr("src"));
				}
				Elements title=e.select("h3.carditems_list_h3");
				for(Element e2 :title){
					map.put("recommandTitleTextView",e2.text());
				}
				Elements desc=e.select("h4.carditems_list_h4");
				for(Element e3:desc){
					map.put("recommandDescTextView", e3.text());
				}
				Elements a=e.select("a");
				for(Element e4 :a ){
					map.put("recommandUrlTextView", e4.attr("href"));
				}
				list.add(map);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
  /**
   * 实现娱乐的方法
   */
	@Override
	public List<Map<String, String>> entertainmentModel() {
		List<Map<String, String>> list =new ArrayList<Map<String,String>>();
		Document doc=null;
	try {
			doc=Jsoup.connect("http://ent.sina.cn/?vt=4&pos=108").get();
			Elements entertainment=doc.select("div.carditems").select("a");
			for(Element e : entertainment){
				Map<String, String> map=new HashMap<String, String>();
				
				Elements img = e.select("dt.carditems_list_dt > img");
				for (Element e1 : img) {
					map.put("recommandSingleImageView", e1.attr("src"));
				}
				Elements title = e.select("h3.carditems_list_h3");
				for (Element e2 : title) {
					map.put("recommandTitleTextView", e2.text());
				}
				Elements desc = e.select("h4.carditems_list_h4");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
  /**
   * 实现科技的方法    dt.f_card_dt>
   */
	@Override
	public List<Map<String, String>> technologyModel() {
		List<Map<String, String>> list =new ArrayList<Map<String,String>>();
		Document doc=null;
	try {
			doc=Jsoup.connect("http://tech.sina.cn/?vt=4&pos=3").get();
			Elements technology=doc.select("section.card_module").select("dl.f_card.carditems");
			for(Element e : technology) {
				Map<String, String> map = new HashMap<String, String>();
				Elements img = e.select("dt.f_card_dt>a> img");
				for (Element e1 : img) {
					map.put("recommandSingleImageView", e1.attr("data-src"));
				}
				Elements title = e.select("h4.f_card_h4");
				for (Element e2 : title) {
					map.put("recommandTitleTextView", e2.text());
				}
				Elements desc = e.select("span.f_sourse");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
