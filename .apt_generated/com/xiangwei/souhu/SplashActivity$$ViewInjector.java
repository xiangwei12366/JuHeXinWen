// Generated code from Butter Knife. Do not modify!
package com.xiangwei.souhu;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SplashActivity$$ViewInjector {
  public static void inject(Finder finder, final com.xiangwei.souhu.SplashActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034131, "field 'mImageView'");
    target.mImageView = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131034130, "field 'rlRoot'");
    target.rlRoot = (android.widget.RelativeLayout) view;
  }

  public static void reset(com.xiangwei.souhu.SplashActivity target) {
    target.mImageView = null;
    target.rlRoot = null;
  }
}
