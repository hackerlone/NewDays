package com.xsy.newsapp.model;

import java.util.List;
import java.util.Map;

public interface NewModel {
    /**
     * �Ƽ�ר��ӿ�
     * @return
     */
	public List<Map<String, String>>  recommandModel();
	
	/**
	 * �ȵ�ר��ӿ�
	 * 
	 */
	public List<Map<String, String>> hotModel();
	/**
	 * ���ר��ӿ�
	 * 
	 */
	public List<Map<String, String>> socialModel();
	/**
	 * ����ר��ӿ�
	 * 
	 */
	public List<Map<String, String>> sportsModel();
	/**
	 * ����ר��ӿ�
	 */
	public List<Map<String, String>> entertainmentModel();
	
	/**
	 * �Ƽ�ר��ӿ�
	 */
	
	public List<Map<String, String>> technologyModel();
}
