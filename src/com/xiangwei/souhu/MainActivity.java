package com.xiangwei.souhu;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.xiangwei.souhu.app.AppApplication;
import com.xiangwei.souhu.bean.ChannelItem;
import com.xiangwei.souhu.bean.ChannelManage;
import com.xiangwei.souhu.tool.BaseTools;
import com.xiangwei.souhu.view.ColumnHorizontalScrollView;

public class MainActivity extends FragmentActivity {
	@InjectView(R.id.mColumnHorizontalScrollView)
	ColumnHorizontalScrollView mColumnHorizontalScrollView;
	@InjectView(R.id.rl_column)
	RelativeLayout rl_column;
	@InjectView(R.id.mRadioGroup_content)
	RadioGroup mRadioGroup_content;
	@InjectView(R.id.shade_left)
	ImageView shade_left;
	@InjectView(R.id.shade_right)
	ImageView shade_right;
	@InjectView(R.id.ll_more_columns)
	LinearLayout ll_more_columns;
	@InjectView(R.id.buttom_more_columns)
	ImageView buttom_more_columns;
	@InjectView(R.id.top_head)
	ImageView top_head;
	@InjectView(R.id.top_more)
	ImageView top_more;
	@InjectView(R.id.top_refresh)
	ImageView top_refresh;
	@InjectView(R.id.top_progress)
	ImageView top_progress;

	private ViewPager mViewPager;
	/** 请求CODE */
	private final static int CHANNELREQUEST = 1;

	/** 屏幕的宽度 */
	private int mScreenWidth;
	/** item的宽度 */
	private int mItemWidth = 0;
	/** 当前选中的栏目 */
	private int columnSelectIndex = 0;
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

	protected SlidingMenu side_drawer;
	// 用户选择的新闻列表分类
	private ArrayList<ChannelItem> userChannelList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);
		mScreenWidth = BaseTools.getWindowsWidth(this);
		int mItemWidth = mScreenWidth / 7;// 一条的item的长度是屏幕的7/1;
		initView();
//		initSlidingMenu();
	}

	/** 初始化layout控件 */
	private void initView() {
		buttom_more_columns.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent_channel = new Intent(getApplicationContext(),
						ChannelActivity.class);
				startActivityForResult(intent_channel, CHANNELREQUEST);
				overridePendingTransition(R.anim.slide_in_right,
						R.anim.slide_in_left);
			}
		});

		top_head.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (side_drawer.isMenuShowing()) {
					side_drawer.showContent();
				} else {
					side_drawer.showContent();
				}
			}
		});

		top_more.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (side_drawer.isSecondaryMenuShowing()) {
					side_drawer.showContent();
				} else {
					side_drawer.showContent();
				}
			}
		});
		// 当栏目项发生变化的时候调用
		setChangView();
	}

	/** 当栏目项发生变化的时候调用 */
	private void setChangView() {
		initColumnData();// 获取Column栏目数据
		initTabColumn();// 初始化Column栏目
//		initFragment();// 初始化Fragment
	}

	/** 获取Column栏目数据 */
	private void initColumnData() {
		userChannelList = (ArrayList<ChannelItem>) ChannelManage.getManage(
				AppApplication.getApp().getSQLHelper()).getUserChannel();
	}

	/** 初始化Column栏目项 */
	private void initTabColumn() {
		mRadioGroup_content.removeAllViews();
		int count = userChannelList.size();
		mColumnHorizontalScrollView.setParam(this, mScreenWidth,
				mRadioGroup_content, shade_left, shade_right, ll_more_columns,
				rl_column);
		for (int i = 0; i < count; i++) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					mItemWidth, LayoutParams.WRAP_CONTENT);
			params.leftMargin = 5;
			params.rightMargin = 5;
			TextView columnTextView = new TextView(this);
			columnTextView.setTextAppearance(this,
					R.style.top_category_scroll_view_item_text);
			columnTextView.setBackgroundResource(R.drawable.radio_buttong_bg);
			columnTextView.setGravity(Gravity.CENTER);
			columnTextView.setId(i);
			columnTextView.setText(userChannelList.get(i).getName());
			columnTextView.setTextColor(getResources().getColorStateList(
					R.color.top_category_scroll_text_color_day));
			if (columnSelectIndex == i) {
				columnTextView.setSelected(true);
			}
			columnTextView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					for (int i = 0; i < mRadioGroup_content.getChildCount(); i++) {
						View localView = mRadioGroup_content.getChildAt(i);
						if (localView != v)
							localView.setSelected(false);
						else {
							localView.setSelected(true);
							mViewPager.setCurrentItem(i);
						}
					}
					Toast.makeText(getApplicationContext(),
							userChannelList.get(v.getId()).getName(),
							Toast.LENGTH_SHORT).show();

				}
			});
			mRadioGroup_content.addView(columnTextView, i, params);
		}
	}

	/** 初始化Fragment */
	private void initFragment() {
		fragments.clear();// 清空
		int count = userChannelList.size();
		for (int i = 0; i < count; i++) {
			Bundle data = new Bundle();
			data.putString("text", userChannelList.get(i).getName());
			data.putInt("id", userChannelList.get(i).getId());
		}
	}

	private void initSlidingMenu() {
		// TODO Auto-generated method stub

	}

}
