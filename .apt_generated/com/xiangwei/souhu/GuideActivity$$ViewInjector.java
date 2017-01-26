// Generated code from Butter Knife. Do not modify!
package com.xiangwei.souhu;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class GuideActivity$$ViewInjector {
  public static void inject(Finder finder, final com.xiangwei.souhu.GuideActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034118, "field 'btnStart'");
    target.btnStart = (android.widget.Button) view;
    view = finder.findRequiredView(source, 2131034117, "field 'mViewPager'");
    target.mViewPager = (android.support.v4.view.ViewPager) view;
    view = finder.findRequiredView(source, 2131034120, "field 'ivRedPoint'");
    target.ivRedPoint = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034119, "field 'llContainer'");
    target.llContainer = (android.widget.LinearLayout) view;
  }

  public static void reset(com.xiangwei.souhu.GuideActivity target) {
    target.btnStart = null;
    target.mViewPager = null;
    target.ivRedPoint = null;
    target.llContainer = null;
  }
}
