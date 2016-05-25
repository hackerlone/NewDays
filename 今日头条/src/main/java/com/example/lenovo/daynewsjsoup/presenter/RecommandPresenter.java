package com.example.lenovo.daynewsjsoup.presenter;

import com.example.lenovo.daynewsjsoup.model.NewModel;
import com.example.lenovo.daynewsjsoup.model.impl.NewModelImpl;
import com.example.lenovo.daynewsjsoup.ui.view.MainView;

import java.util.List;
import java.util.Map;

/**
 * Created by: Lone on 2016/5/22.
 * Contact: 4951048@qq.com
 */
public class RecommandPresenter implements IPresenter {
    private MainView mainView;
    private NewModel newModel;

    public RecommandPresenter() {
        super();
        this.newModel = new NewModelImpl();
    }

    public RecommandPresenter(MainView mainView) {
        this.mainView = mainView;
        this.newModel = new NewModelImpl();
    }

    @Override
    public void loadRecommand() {
        List<Map<String, String>> list = newModel.recommandModel("http://news.sina.cn/?vt=4&pos=108","section[data-sudaclick=yaowen]");
        mainView.loadRecommand(list);
    }

    @Override
    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }
}
