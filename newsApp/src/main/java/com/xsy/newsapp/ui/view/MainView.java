package com.xsy.newsapp.ui.view;

import java.util.List;
import java.util.Map;

public interface MainView {
	public void loadRecommand(List<Map<String, String>> list);
	public void loadSocial(List<Map<String, String>> list);
	public void loadSports(List<Map<String, String>> list);
	public void loadHot(List<Map<String, String>> list);
	public void loadEntertainment(List<Map<String, String>> list);
	public void loadTechnology(List<Map<String, String>> list);
	
}
