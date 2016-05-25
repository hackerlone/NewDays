package com.example.lenovo.daynewsjsoup.ui.fragment;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lenovo.daynewsjsoup.R;
import com.example.lenovo.daynewsjsoup.adapter.MyBaseAdapter;
import com.example.lenovo.daynewsjsoup.presenter.IPresenter;
import com.example.lenovo.daynewsjsoup.ui.view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by: Lone on 2016/5/22.
 * Contact: 4951048@qq.com
 */
public class MyFragment<T> extends Fragment implements MainView {
    private View convertView;
    private ListView mLsitView;
    private MyBaseAdapter adapter;
    private List<Map<String, String>> list;
    private static final String KEY_CONTENT = "TestFragment:Content";
    private String mContent;
    private IPresenter presenter;
    public MyFragment(Class c) {
//         fragment.mContent = content;
        try {
            presenter = (IPresenter) c.newInstance();
            presenter.setMainView(this);
        } catch (java.lang.InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//    	Log.i("fragment", mContent);
        convertView = inflater.inflate(R.layout.news_content, null);
        mLsitView = (ListView) convertView.findViewById(R.id.mlistView);
        list = new ArrayList<Map<String, String>>();
        mLsitView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int positon,
                                    long arg3) {
//                Intent intent = new Intent(getActivity(),WebViewActivity.class);
//                intent.putExtra("url", list.get(positon).get("recommandUrlTextView"));
//                startActivity(intent);
            }
        });
        new LoadTask().execute();
        return convertView;
    }
    class LoadTask extends AsyncTask<Void, Void, List<Map<String, String>>> {

        @Override
        protected List<Map<String, String>> doInBackground(Void... params) {

//			CarPresenter cp = new CarPresenter(
//					MyFragment.this);
//			cp.loadRecommand();
            presenter.loadRecommand();
            return list;
        }

        @Override
        protected void onPostExecute(List<Map<String, String>> result) {
            adapter = new MyBaseAdapter(getActivity(), list);
            mLsitView.setAdapter(adapter);
        }
    }
    @Override
    public void loadRecommand(List<Map<String, String>> list) {
        this.list = list;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }
}
