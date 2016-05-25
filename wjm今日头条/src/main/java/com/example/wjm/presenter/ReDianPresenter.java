package com.example.wjm.presenter;

import com.example.wjm.model.IReDianModel;
import com.example.wjm.model.impl.IReDianModelImpl;
import com.example.wjm.ui.IReDianView;

/**
 * Created by: Lone on 2016/5/23.
 * Contact: 4951048@qq.com
 */
public class ReDianPresenter {
    private IReDianView mIReDianView;
    private IReDianModel mIReDianModel;
    public ReDianPresenter(IReDianView mIReDianView) {
        this.mIReDianView = mIReDianView;
        mIReDianModel = new IReDianModelImpl();
    }

    public void LoadReDian(){
        mIReDianView.LoadReDian(mIReDianModel.LoadReDian());
    }
}
