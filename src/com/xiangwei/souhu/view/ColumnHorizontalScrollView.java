package com.xiangwei.souhu.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class ColumnHorizontalScrollView extends HorizontalScrollView {
	/** 传入整体布局 */
	private View ll_content;
	/** 传入更多栏目选择布局 */
	private View ll_more;
	/** 传入拖动栏布局 */
	private View rl_column;
	/** 传入右阴影图片 */
	private ImageView rightImage;
	/** 传入左阴影图片 */
	private ImageView leftImage;
	/** 屏幕宽度 */
	private int mScreenWidth = 0;
	/** 父类活动的Activity */
	private Activity activity;

	public ColumnHorizontalScrollView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public ColumnHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ColumnHorizontalScrollView(Context context) {
		super(context);
	}

	/**
	 * 在拖动时执行 参数1:为变化后的X轴 参数2:为变化后的Y轴 参数3:为原来的X轴 参数4:为原来的X轴
	 */
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		shade_ShowOrHide();
		if (!activity.isFinishing() && ll_content != null && leftImage != null
				&& rightImage != null && ll_more != null && rl_column != null) {
			if (ll_content.getWidth() <= mScreenWidth) {
				leftImage.setVisibility(View.GONE);
				rightImage.setVisibility(View.GONE);
			}
		} else {
			return;
		}
		if (l == 0) {
			leftImage.setVisibility(View.GONE);
			rightImage.setVisibility(View.VISIBLE);
			return;
		}
		if (ll_content.getWidth() - l + ll_more.getWidth()
				+ rl_column.getLeft() == mScreenWidth) {
			leftImage.setVisibility(View.VISIBLE);
			rightImage.setVisibility(View.GONE);
			return;
		}
		leftImage.setVisibility(View.VISIBLE);
		rightImage.setVisibility(View.VISIBLE);
	}

	/**
	 * 传入父类布局中的资源文件
	 * */
	public void setParam(Activity activity, int mScreenWitdh, View paramView1,
			ImageView paramView2, ImageView paramView3, View paramView4,
			View paramView5) {
		this.activity = activity;
		this.mScreenWidth = mScreenWitdh;
		ll_content = paramView1;
		leftImage = paramView2;
		rightImage = paramView3;
		ll_more = paramView4;
		rl_column = paramView5;
	}

	/**
	 * 判断左右阴影的显示效果
	 */
	public void shade_ShowOrHide() {
		if (!activity.isFinishing() && ll_content != null) {
			measure(0, 0);
			// 如果整体宽度小于屏幕宽度，那左右阴影都需隐藏
			if (mScreenWidth >= getMeasuredWidth()) {
				leftImage.setVisibility(View.GONE);
				rightImage.setVisibility(View.GONE);
			}
		} else {
			return;
		}
		// 如果滑动到最左边的时候，左边阴影隐藏。
		if (getLeft() == 0) {
			leftImage.setVisibility(View.GONE);
			rightImage.setVisibility(View.VISIBLE);
			return;
		}
		if (getRight() == getMeasuredWidth() - mScreenWidth) {
			leftImage.setVisibility(View.VISIBLE);
			rightImage.setVisibility(View.GONE);
			return;
		}
		//否则，滑动在中间，两边都显示
		leftImage.setVisibility(View.VISIBLE);
		rightImage.setVisibility(View.VISIBLE);
	}

}
