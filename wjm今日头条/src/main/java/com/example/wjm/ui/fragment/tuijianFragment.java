package com.example.wjm.ui.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.wjm.R;
import com.example.wjm.adapter.TuijianListAdapter;
import com.example.wjm.presenter.TuiJianPresenter;
import com.example.wjm.ui.IMainView;

import java.util.List;
import java.util.Map;

/**
 * Created by: Lone on 2016/5/22.
 * Contact: 4951048@qq.com
 */
public class tuijianFragment extends Fragment implements IMainView {

    private List<Map<String,String>> list;
    private ListView tjListView;
    TuiJianPresenter mTuiJianPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuijian_fragment,null);
        tjListView = (ListView) view.findViewById(R.id.tjListView);

        new GetData().execute();
        return view;
    }

    class GetData extends AsyncTask<Void, Void, List<Map<String, String>>> {
        @Override
        protected List<Map<String, String>> doInBackground(Void... params) {
            mTuiJianPresenter = new TuiJianPresenter(tuijianFragment.this);
            mTuiJianPresenter.loadTuiJian();
            return list;
        }
        @Override
        protected void onPostExecute(List<Map<String, String>> result) {
            TuijianListAdapter adapter = new TuijianListAdapter(getActivity(), list, R.layout.listview_adapter);
            tjListView.setAdapter(adapter);
        }
    }
    /**
     * 会接收Model传递回来的数据
     */
    @Override
    public void loadTuiJian(List<Map<String, String>> list) {
        this.list = list;
    }
}
