package com.xsy.newsapp.presenter;

import com.xsy.newsapp.model.NewModel;
import com.xsy.newsapp.model.imp.NewModelImpl;
import com.xsy.newsapp.ui.view.MainView;

import java.util.List;
import java.util.Map;


public class RecommandPresenter {
	private MainView mainView;
	private NewModel newModel;
	
	public RecommandPresenter(MainView mainView) {
		this.mainView = mainView;
		this.newModel = new NewModelImpl();
	}
	
	public void loadRecommand() {
		List<Map<String, String>> list = newModel.recommandModel();
		mainView.loadRecommand(list);
	}
	
	public void loadSports() {
		List<Map<String, String>> list = newModel.sportsModel();
		mainView.loadSports(list);
	}
	
	public void loadSocial() {
		List<Map<String, String>> list = newModel.socialModel();
		mainView.loadSocial(list);
	}

	public void loadHot() {
		List<Map<String, String>> list = newModel.hotModel();
		mainView.loadHot(list);
		
	}
	public void loadEntertainment() {
		List<Map<String, String>> list = newModel.entertainmentModel();
		mainView.loadEntertainment(list);
		
	}
	public void loadTechnology() {
		List<Map<String, String>> list = newModel.technologyModel();
		mainView.loadTechnology(list);
		
	}
}
