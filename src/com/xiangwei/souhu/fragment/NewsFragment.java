package com.xiangwei.souhu.fragment;

import java.util.ArrayList;

import com.xiangwei.souhu.R;
import com.xiangwei.souhu.bean.NewsEntity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewsFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.fragment_news, container);
		return view;
	}
//	private final static String TAG = "NewsFragment";
//	Activity activity;
//	ArrayList<NewsEntity> newsList = new ArrayList<NewsEntity>();
//	String text;
//	int channel_id;
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		Bundle args = getArguments();
//		text = args != null ? args.getString("text") : "";
//		channel_id = args != null ? args.getInt("id", 0) : 0;
//		initData();
//		super.onCreate(savedInstanceState);
//	}
//	
//	private void initData() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onAttach(Activity activity) {
//		// TODO Auto-generated method stub
//		this.activity = activity;
//		super.onAttach(activity);
//	}
}
