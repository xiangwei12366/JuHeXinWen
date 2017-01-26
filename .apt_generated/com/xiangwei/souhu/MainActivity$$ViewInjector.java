// Generated code from Butter Knife. Do not modify!
package com.xiangwei.souhu;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.xiangwei.souhu.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034143, "field 'top_refresh'");
    target.top_refresh = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034135, "field 'top_head'");
    target.top_head = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034123, "field 'mRadioGroup_content'");
    target.mRadioGroup_content = (android.widget.RadioGroup) view;
    view = finder.findRequiredView(source, 2131034126, "field 'll_more_columns'");
    target.ll_more_columns = (android.widget.LinearLayout) view;
    view = finder.findRequiredView(source, 2131034137, "field 'top_more'");
    target.top_more = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034122, "field 'mColumnHorizontalScrollView'");
    target.mColumnHorizontalScrollView = (com.xiangwei.souhu.view.ColumnHorizontalScrollView) view;
    view = finder.findRequiredView(source, 2131034144, "field 'top_progress'");
    target.top_progress = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034127, "field 'buttom_more_columns'");
    target.buttom_more_columns = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034124, "field 'shade_left'");
    target.shade_left = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034125, "field 'shade_right'");
    target.shade_right = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034121, "field 'rl_column'");
    target.rl_column = (android.widget.RelativeLayout) view;
  }

  public static void reset(com.xiangwei.souhu.MainActivity target) {
    target.top_refresh = null;
    target.top_head = null;
    target.mRadioGroup_content = null;
    target.ll_more_columns = null;
    target.top_more = null;
    target.mColumnHorizontalScrollView = null;
    target.top_progress = null;
    target.buttom_more_columns = null;
    target.shade_left = null;
    target.shade_right = null;
    target.rl_column = null;
  }
}
