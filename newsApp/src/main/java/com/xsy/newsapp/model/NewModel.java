package com.xsy.newsapp.model;

import java.util.List;
import java.util.Map;

public interface NewModel {
    /**
     * 推荐专题接口
     * @return
     */
	public List<Map<String, String>>  recommandModel();
	
	/**
	 * 热点专题接口
	 * 
	 */
	public List<Map<String, String>> hotModel();
	/**
	 * 社会专题接口
	 * 
	 */
	public List<Map<String, String>> socialModel();
	/**
	 * 体育专题接口
	 * 
	 */
	public List<Map<String, String>> sportsModel();
	/**
	 * 娱乐专题接口
	 */
	public List<Map<String, String>> entertainmentModel();
	
	/**
	 * 科技专题接口
	 */
	
	public List<Map<String, String>> technologyModel();
}
