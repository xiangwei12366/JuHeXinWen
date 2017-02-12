package com.xiangwei.souhu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.xiangwei.souhu.util.PrefUtils;

public class SplashActivity extends Activity {

	@InjectView(R.id.imageview1)
	ImageView mImageView;
	@InjectView(R.id.rl_root)
	RelativeLayout rlRoot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		ButterKnife.inject(this);

		/*// 缩放动画
		ScaleAnimation animScale = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		animScale.setDuration(1000);
		animScale.setFillAfter(true);*/
		
		//位移动画
		TranslateAnimation animTran = new TranslateAnimation(0, 0, 480, 0);
		animTran.setDuration(500);
		animTran.setFillAfter(true);
		
		//动画集合
		AnimationSet set = new AnimationSet(true);
		set.addAnimation(animTran);
		
		//启动动画
		rlRoot.startAnimation(set);
		set.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				//动画结束，跳转页面
				//如果是第一次进入，进入新手引导
				//否则跳主页面
				boolean isFirstEnter = PrefUtils.getBoolean(SplashActivity.this, "is_first_enter", true);
				Intent intent;
				if(isFirstEnter){
					intent = new Intent(getApplicationContext(), GuideActivity.class);
				}else{
					intent = new Intent(getApplicationContext(),MainActivity.class);
				}
				startActivity(intent);
				finish();//结束当前页面
			}
		});
	}
}
