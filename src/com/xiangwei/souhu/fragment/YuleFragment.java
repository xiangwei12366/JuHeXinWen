package com.xiangwei.souhu.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.xiangwei.souhu.DetailsActivity;
import com.xiangwei.souhu.R;
import com.xiangwei.souhu.adapter.NewsAdapter;
import com.xiangwei.souhu.domain.NewsMenu;
import com.xiangwei.souhu.tool.Constants;
import com.xiangwei.souhu.tool.GlobalConstants;

public class YuleFragment extends BaseFragment {

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		getDataFromServer();

	}

	public void getDataFromServer() {
		HttpUtils utils = new HttpUtils();
		utils.send(HttpMethod.GET, GlobalConstants.SERVER_YULE_URL,
				new RequestCallBack<String>() {

					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {
						// 请求成功
						String result = responseInfo.result;// 获取服务器返回结果
						System.out.println("服务器返回结果:" + result);

						// JsonObject, Gson
						processData(result);

						/*
						 * // 写缓存
						 * CacheUtils.setCache(GlobalConstants.CATEGORY_URL,
						 * result, mActivity);
						 */
					}

					@Override
					public void onFailure(HttpException error, String msg) {
						// 请求失败
						error.printStackTrace();
						Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT)
								.show();
					}
				});
	}

	/**
	 * 解析数据
	 */
	protected void processData(String json) {
		// Gson: Google Json
		Gson gson = new Gson();
		mNewsData = gson.fromJson(json, NewsMenu.class);
		mResult = mNewsData.getResults();
		mData = mResult.getData();
		mAdapter = new NewsAdapter(activity, mData);
		mListView.setAdapter(mAdapter);
		mListView.setOnScrollListener(mAdapter);
		mListView.setPinnedHeaderView(LayoutInflater.from(activity).inflate(
				R.layout.list_item_section, mListView, false));
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(activity, DetailsActivity.class);
				if (channel_id == Constants.CHANNEL_CITY) {
					if (position != 0) {
						intent.putExtra("news", mAdapter.getItem(position - 1));
						startActivity(intent);
						activity.overridePendingTransition(
								R.anim.slide_in_right, R.anim.slide_out_left);
					}
				} else {
					intent.putExtra("news", mAdapter.getItem(position));
					startActivity(intent);
					activity.overridePendingTransition(R.anim.slide_in_right,
							R.anim.slide_out_left);
				}
			}
		});
	}
}
