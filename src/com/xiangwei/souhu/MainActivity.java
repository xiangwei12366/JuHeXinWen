package com.xiangwei.souhu;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.xiangwei.souhu.adapter.NewsFragmentPagerAdapter;
import com.xiangwei.souhu.app.AppApplication;
import com.xiangwei.souhu.bean.ChannelItem;
import com.xiangwei.souhu.bean.ChannelManage;
import com.xiangwei.souhu.db.SQLHelper;
import com.xiangwei.souhu.fragment.CaijingFragment;
import com.xiangwei.souhu.fragment.GuojiFragment;
import com.xiangwei.souhu.fragment.GuoneiFragment;
import com.xiangwei.souhu.fragment.JunshiFragment;
import com.xiangwei.souhu.fragment.KejiFragment;
import com.xiangwei.souhu.fragment.ShehuiFragment;
import com.xiangwei.souhu.fragment.ShishangFragment;
import com.xiangwei.souhu.fragment.TiyuFragment;
import com.xiangwei.souhu.fragment.TopFragment;
import com.xiangwei.souhu.fragment.YuleFragment;
import com.xiangwei.souhu.tool.BaseTools;
import com.xiangwei.souhu.view.ColumnHorizontalScrollView;

public class MainActivity extends FragmentActivity {
	/** 自定义HorizontalScrollView */
	private ColumnHorizontalScrollView mColumnHorizontalScrollView;
	LinearLayout mRadioGroup_content;
	LinearLayout ll_more_columns;
	RelativeLayout rl_column;
	private ViewPager mViewPager;
	private ImageView button_more_columns;
	/** 用户选择的新闻分类列表 */
	private ArrayList<ChannelItem> userChannelList = new ArrayList<ChannelItem>();
	/** 当前选中的栏目 */
	private int columnSelectIndex = 0;
	/** 左阴影部分 */
	public ImageView shade_left;
	/** 右阴影部分 */
	public ImageView shade_right;
	/** 屏幕宽度 */
	private int mScreenWidth = 0;
	/** Item宽度 */
	private int mItemWidth = 0;
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

	protected SlidingMenu side_drawer;
	private static AppApplication mAppApplication;

	/** head 头部 的中间的loading */
	private ProgressBar top_progress;
	/** head 头部 中间的刷新按钮 */
	private ImageView top_refresh;
	/** head 头部 的左侧菜单 按钮 */
	private ImageView top_head;
	/** head 头部 的右侧菜单 按钮 */
	private ImageView top_more;
	/** 请求CODE */
	public final static int CHANNELREQUEST = 1;
	/** 调整返回的RESULTCODE */
	public final static int CHANNELRESULT = 10;
	private SQLHelper sqlHelper;
	private String[] userChannels;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);
		mScreenWidth = BaseTools.getWindowsWidth(this);
		mItemWidth = mScreenWidth / 7;// 一条的item的长度是屏幕的7/1;
		sqlHelper = new SQLHelper(mAppApplication);
		initView();
		// initSlidingMenu();
	}

	/** 初始化layout控件 */
	private void initView() {
		mColumnHorizontalScrollView = (ColumnHorizontalScrollView) findViewById(R.id.mColumnHorizontalScrollView);
		mRadioGroup_content = (LinearLayout) findViewById(R.id.mRadioGroup_content);
		// ll_more_columns = (LinearLayout) findViewById(R.id.ll_more_columns);
		rl_column = (RelativeLayout) findViewById(R.id.rl_column);
		// button_more_columns = (ImageView)
		// findViewById(R.id.buttom_more_columns);
		mViewPager = (ViewPager) findViewById(R.id.mViewPager);
		shade_left = (ImageView) findViewById(R.id.shade_left);
		shade_right = (ImageView) findViewById(R.id.shade_right);
		// top_head = (ImageView) findViewById(R.id.top_head);
		// top_more = (ImageView) findViewById(R.id.top_more);
		// top_refresh = (ImageView) findViewById(R.id.top_refresh);
		top_progress = (ProgressBar) findViewById(R.id.top_progress);
		// button_more_columns.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// }
		// });
		// top_head.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// if (side_drawer.isMenuShowing()) {
		// side_drawer.showContent();
		// } else {
		// side_drawer.showMenu();
		// }
		// }
		// });
		// top_more.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// if (side_drawer.isSecondaryMenuShowing()) {
		// side_drawer.showContent();
		// } else {
		// side_drawer.showSecondaryMenu();
		// }
		// }
		// });
		initFragmentList();
		setChangelView();
	}

	private void initFragmentList() {
		fragmentList = new ArrayList<Fragment>();
		TopFragment topFragment = new TopFragment();// 头条
		ShehuiFragment shehuiFragment = new ShehuiFragment();// 社会
		GuoneiFragment guoneiFragment = new GuoneiFragment();// 国内
		GuojiFragment guojiFragment = new GuojiFragment();// 国际
		YuleFragment yuleFragment = new YuleFragment();// 娱乐
		TiyuFragment tiyuFragment = new TiyuFragment();// 体育
		JunshiFragment junshiFragment = new JunshiFragment();// 军事
		KejiFragment kejiFragment = new KejiFragment();// 科技
		CaijingFragment caijingFragment = new CaijingFragment();// 财经
		ShishangFragment shishangFragment = new ShishangFragment();// 时尚
		fragmentList.add(topFragment);
		fragmentList.add(shehuiFragment);
		fragmentList.add(guoneiFragment);
		fragmentList.add(guojiFragment);
		fragmentList.add(yuleFragment);
		fragmentList.add(tiyuFragment);
		// fragmentList.add(junshiFragment);
		fragmentList.add(kejiFragment);
		fragmentList.add(caijingFragment);
		fragmentList.add(shishangFragment);
	}

	/** 当栏目项发生变化的时候调用 */
	private void setChangelView() {
		initColumnData();// 获取Column栏目数据
		initTabColumn();// 初始化Column栏目
		initFragment();// 初始化Fragment
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
		System.out.println("count总数为===================" + count);
		mColumnHorizontalScrollView.setParam(this, mScreenWidth,
				mRadioGroup_content, shade_left, shade_right, ll_more_columns,
				rl_column);
		for (int i = 0; i < count; i++) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					mItemWidth, LayoutParams.WRAP_CONTENT);
			params.leftMargin = 5;
			params.rightMargin = 5;
			// TextView localTextView = (TextView)
			// mInflater.inflate(R.layout.column_radio_item, null);
			TextView columnTextView = new TextView(this);
			columnTextView.setTextAppearance(this,
					R.style.top_category_scroll_view_item_text);
			// localTextView.setBackground(getResources().getDrawable(R.drawable.top_category_scroll_text_view_bg));
			columnTextView.setBackgroundResource(R.drawable.radio_buttong_bg);
			columnTextView.setGravity(Gravity.CENTER);
			columnTextView.setPadding(5, 5, 5, 5);
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

	/**
	 * 选择的Column里面的Tab
	 * */
	private void selectTab(int tab_postion) {
		columnSelectIndex = tab_postion;
		for (int i = 0; i < mRadioGroup_content.getChildCount(); i++) {
			View checkView = mRadioGroup_content.getChildAt(tab_postion);
			int k = checkView.getMeasuredWidth();
			int l = checkView.getLeft();
			int i2 = l + k / 2 - mScreenWidth / 2;
			// rg_nav_content.getParent()).smoothScrollTo(i2, 0);
			mColumnHorizontalScrollView.smoothScrollTo(i2, 0);
			// mColumnHorizontalScrollView.smoothScrollTo((position - 2) *
			// mItemWidth , 0);
		}
		// 判断是否选中
		for (int j = 0; j < mRadioGroup_content.getChildCount(); j++) {
			View checkView = mRadioGroup_content.getChildAt(j);
			boolean ischeck;
			if (j == tab_postion) {
				ischeck = true;
			} else {
				ischeck = false;
			}
			checkView.setSelected(ischeck);
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
			// TestFragment testfragment = new TestFragment();
			Fragment fragment = fragmentList.get(i);
			fragment.setArguments(data);
			fragments.add(fragment);
		}
		NewsFragmentPagerAdapter mAdapetr = new NewsFragmentPagerAdapter(
				getSupportFragmentManager(), fragments);
		// mViewPager.setOffscreenPageLimit(0);
		mViewPager.setAdapter(mAdapetr);
		mViewPager.setOnPageChangeListener(pageListener);
	}

	/**
	 * ViewPager切换监听方法
	 * */
	public OnPageChangeListener pageListener = new OnPageChangeListener() {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			mViewPager.setCurrentItem(position);
			selectTab(position);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private long mExitTime;
	private ArrayList<Fragment> fragmentList;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (side_drawer.isMenuShowing()
					|| side_drawer.isSecondaryMenuShowing()) {
				side_drawer.showContent();
			} else {
				if ((System.currentTimeMillis() - mExitTime) > 2000) {
					Toast.makeText(this, "在按一次退出", Toast.LENGTH_SHORT).show();
					mExitTime = System.currentTimeMillis();
				} else {
					finish();
				}
			}
			return true;
		}
		// 拦截MENU按钮点击事件，让他无任何操作
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case CHANNELREQUEST:
			if (resultCode == CHANNELRESULT) {
				setChangelView();
			}
			break;

		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	// private void initSlidingMenu() {
	// side_drawer = new DrawerView(this).initSlidingMenu();
	// }

}
