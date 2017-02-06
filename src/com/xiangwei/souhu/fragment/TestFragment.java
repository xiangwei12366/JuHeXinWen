package com.xiangwei.souhu.fragment;

import com.xiangwei.souhu.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View.inflate(getActivity(), R.layout.fragment_test, container);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
