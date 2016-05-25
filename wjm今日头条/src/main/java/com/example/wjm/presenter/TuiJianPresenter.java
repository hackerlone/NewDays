package com.example.wjm.presenter;

import com.example.wjm.model.ITuiJianModel;
import com.example.wjm.model.impl.ITuiJianModelImpl;
import com.example.wjm.ui.IMainView;

/**
 * Created by: Lone on 2016/5/23.
 * Contact: 4951048@qq.com
 */
public class TuiJianPresenter {
    private IMainView mIMainView;
    private ITuiJianModel mITuiJianModel;
    public TuiJianPresenter(IMainView mIMainView) {
        this.mIMainView = mIMainView;
        mITuiJianModel = new ITuiJianModelImpl();
    }

    public void loadTuiJian(){
        mIMainView.loadTuiJian(mITuiJianModel.loadTuiJian());
    }
}
