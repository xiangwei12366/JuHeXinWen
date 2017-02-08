package com.xiangwei.souhu.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.xiangwei.souhu.R;
import com.xiangwei.souhu.domain.Data;
import com.xiangwei.souhu.tool.Constants;
import com.xiangwei.souhu.tool.DataTools;
import com.xiangwei.souhu.tool.Options;
import com.xiangwei.souhu.view.HeadListView;
import com.xiangwei.souhu.view.HeadListView.HeaderAdapter;

public class NewsAdapter extends BaseAdapter implements SectionIndexer,
		HeaderAdapter, OnScrollListener {
	ArrayList<Data> datas;
	Activity activity;
	LayoutInflater inflater = null;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	DisplayImageOptions options;
	private PopupWindow popupWindow;
	private List<Integer> mPositions;
	private List<String> mSections;

	public NewsAdapter(Activity activity, ArrayList<Data> mData) {
		this.activity = activity;
		this.datas = mData;
		inflater = LayoutInflater.from(activity);
		options = Options.getListOptions();
		initPopWindow();
		initDateHead();
	}

	private void initDateHead() {
		mSections = new ArrayList<String>();
		mPositions = new ArrayList<Integer>();
		for (int i = 0; i < datas.size(); i++) {
			if (i == 0) {
//				mSections.add(DataTools.getSection(String.valueOf(datas.get(i)
//						.getDate())));
				mPositions.add(i);
				continue;
			}
			if (i != datas.size()) {
				if (!datas.get(i).getDate().equals(datas.get(i - 1).getDate())) {
					// mSections.add(DataTools.getSection(String.valueOf(datas
					// .get(i).getDate())));
					mPositions.add(i);
				}
			}
		}
	}

	@Override
	public int getCount() {
		return datas == null ? 0 : datas.size();
	}

	@Override
	public Data getItem(int position) {
		if (datas != null && datas.size() != 0) {
			System.out.println(datas.get(position));
			return datas.get(position);

		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mHolder;
		View view = convertView;
//		if (view == null) {
			view = inflater.inflate(R.layout.list_item, null);
			mHolder = new ViewHolder();
			mHolder.item_layout = (LinearLayout) view
					.findViewById(R.id.item_layout);
			mHolder.title = (TextView) view.findViewById(R.id.item_title);
			mHolder.date = (TextView) view.findViewById(R.id.publish_time);
			mHolder.author_name = (TextView) view
					.findViewById(R.id.item_source);
			mHolder.pic_url1 = (ImageView) view.findViewById(R.id.item_image_0);
			mHolder.pic_url2 = (ImageView) view.findViewById(R.id.item_image_1);
			mHolder.pic_url3 = (ImageView) view.findViewById(R.id.item_image_2);
//		} else {
//			mHolder = (ViewHolder) view.getTag();
//		}
		// 获取position对应的数据
		Data datas = getItem(position);
		System.out.println("Data数据++++++++++++" + datas);
		mHolder.title.setText(datas.getTitle());
		mHolder.date.setText(datas.getDate());
		mHolder.author_name.setText(datas.getAuthor_name());
		imageLoader.displayImage(datas.getThumbnail_pic_s(), mHolder.pic_url1,
				options);
		System.out.println("图片地址++++++++++++" + datas.getThumbnail_pic_s());
		imageLoader.displayImage(datas.getThumbnail_pic_s02(),
				mHolder.pic_url2, options);
		imageLoader.displayImage(datas.getThumbnail_pic_s03(),
				mHolder.pic_url3, options);
		return view;
	}

	/** 根据属性获取对应的资源ID */
	public int getAltMarkResID(int mark, boolean isfavor) {
		if (isfavor) {
			return R.drawable.ic_mark_favor;
		}
		switch (mark) {
		case Constants.mark_recom:
			return R.drawable.ic_mark_recommend;
		case Constants.mark_hot:
			return R.drawable.ic_mark_hot;
		case Constants.mark_frist:
			return R.drawable.ic_mark_first;
		case Constants.mark_exclusive:
			return R.drawable.ic_mark_exclusive;
		case Constants.mark_favor:
			return R.drawable.ic_mark_favor;
		default:
			break;
		}
		return -1;
	}

	/** popWindow 关闭按钮 */
	private ImageView btn_pop_close;

	/**
	 * 初始化弹出的pop
	 * */
	private void initPopWindow() {
		View popView = inflater.inflate(R.layout.list_item_pop, null);
		popupWindow = new PopupWindow(popView, LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		popupWindow.setBackgroundDrawable(new ColorDrawable(0));
		// 设置popwindow出现和消失动画
		popupWindow.setAnimationStyle(R.style.PopMenuAnimation);
		btn_pop_close = (ImageView) popView.findViewById(R.id.btn_pop_close);
	}

	/**
	 * 显示popWindow
	 * */
	public void showPop(View parent, int x, int y, int postion) {
		// 设置popwindow显示位置
		popupWindow.showAtLocation(parent, 0, x, y);
		// 获取popwindow焦点
		popupWindow.setFocusable(true);
		// 设置popwindow如果点击外面区域，便关闭。
		popupWindow.setOutsideTouchable(true);
		popupWindow.update();
		if (popupWindow.isShowing()) {

		}
		btn_pop_close.setOnClickListener(new OnClickListener() {
			public void onClick(View paramView) {
				popupWindow.dismiss();
			}
		});
	}

	/**
	 * 每个ITEM中more按钮对应的点击动作
	 * */
	public class popAction implements OnClickListener {
		int position;

		public popAction(int position) {
			this.position = position;
		}

		@Override
		public void onClick(View v) {
			int[] arrayOfInt = new int[2];
			// 获取点击按钮的坐标
			v.getLocationOnScreen(arrayOfInt);
			int x = arrayOfInt[0];
			int y = arrayOfInt[1];
			showPop(v, x, y, position);
		}
	}

	/* 是不是城市频道， true：是 false :不是 */
	public boolean isCityChannel = false;

	/* 是不是第一个ITEM， true：是 false :不是 */
	public boolean isfirst = true;

	/*
	 * 设置是不是特殊的频道（城市频道）
	 */
	public void setCityChannel(boolean iscity) {
		isCityChannel = iscity;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		System.out.println("发生滑动");
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		if (view instanceof HeadListView) {
			Log.d("first", "first:" + view.getFirstVisiblePosition());
			if (isCityChannel) {
				if (view.getFirstVisiblePosition() == 0) {
					isfirst = true;
				} else {
					isfirst = false;
				}
				((HeadListView) view).configureHeaderView(firstVisibleItem - 1);
			} else {
				((HeadListView) view).configureHeaderView(firstVisibleItem);
			}
		}
	}

	@Override
	public int getHeaderState(int position) {
		// TODO Auto-generated method stub
		int realPosition = position;
		if (isCityChannel) {
			if (isfirst) {
				return HEADER_GONE;
			}
		}
		if (realPosition < 0 || position >= getCount()) {
			return HEADER_GONE;
		}
		int section = getSectionForPosition(realPosition);
		int nextSectionPosition = getPositionForSection(section + 1);
		if (nextSectionPosition != -1
				&& realPosition == nextSectionPosition - 1) {
			return HEADER_PUSHED_UP;
		}
		return HEADER_VISIBLE;
	}

	@Override
	public void configureHeader(View header, int position, int alpha) {
//		int realPosition = position;
//		int section = getSectionForPosition(realPosition);
//		String title = (String) getSections()[section];
//		((TextView) header.findViewById(R.id.section_text)).setText(title);
//		((TextView) header.findViewById(R.id.section_day)).setText("今天");
	}

	@Override
	public Object[] getSections() {
		// TODO Auto-generated method stub
		return mSections.toArray();
	}

	@Override
	public int getPositionForSection(int sectionIndex) {
		if (sectionIndex < 0 || sectionIndex >= mPositions.size()) {
			return -1;
		}
		return mPositions.get(sectionIndex);
	}

	@Override
	public int getSectionForPosition(int position) {
		if (position < 0 || position >= getCount()) {
			return -1;
		}
		int index = Arrays.binarySearch(mPositions.toArray(), position);
		return index >= 0 ? index : -index - 2;
	}

	static class ViewHolder {
		LinearLayout item_layout;
		/** 新闻item标题 */
		TextView title;
		/** 新闻更新日期 */
		TextView date;
		/** 新闻来源-网站 */
		TextView author_name;
		/** 新闻图片1 */
		ImageView pic_url1;
		/** 新闻图片2 */
		ImageView pic_url2;
		/** 新闻图片3 */
		ImageView pic_url3;
	}

}
