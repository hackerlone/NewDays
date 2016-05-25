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
import com.example.wjm.presenter.ReDianPresenter;
import com.example.wjm.ui.IReDianView;

import java.util.List;
import java.util.Map;

/**
 * Created by: Lone on 2016/5/22.
 * Contact: 4951048@qq.com
 */
public class redianFragment extends Fragment implements IReDianView{
    private List<Map<String,String>> list;
    private ReDianPresenter mReDianPresenter;
    private ListView rdListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.redian_fragment,null);
        rdListView = (ListView) view.findViewById(R.id.rdListView);
       new GetData().execute();
        return view;
    }
    class GetData extends AsyncTask<Void, Void, List<Map<String, String>>> {
        @Override
        protected List<Map<String, String>> doInBackground(Void... params) {
            mReDianPresenter = new ReDianPresenter(redianFragment.this);
            mReDianPresenter.LoadReDian();
            return list;
        }
        @Override
        protected void onPostExecute(List<Map<String, String>> result) {
            TuijianListAdapter adapter = new TuijianListAdapter(getActivity(), list, R.layout.listview_adapter);
            rdListView.setAdapter(adapter);
        }
    }
    public void LoadReDian(List<Map<String, String>> list) {
        this.list = list;
    }
}
