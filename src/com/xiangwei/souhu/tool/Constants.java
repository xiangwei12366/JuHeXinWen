package com.xiangwei.souhu.tool;

import java.util.ArrayList;
import java.util.List;

import com.xiangwei.souhu.bean.NewsEntity;

public class Constants {
	/** 获取新闻列表 */
	public static ArrayList<NewsEntity> getNewsList() {
		ArrayList<NewsEntity> newsList = new ArrayList<NewsEntity>();
		for (int i = 0; i < 10; i++) {
			NewsEntity news = new NewsEntity();
			news.setId(i);
			news.setNewsId(i);
			news.setCollectStatus(false);
			news.setCommentNum(i + 10);
			news.setInterestedStatus(true);
			news.setLikeStatus(true);
			news.setReadStatus(false);
			news.setNewsCategory("推荐");
			news.setNewsCategoryId(1);
			news.setSource_url("http://news.sohu.com/20170125/n479566556.shtml");
			news.setTitle("全军“最年轻战区主官”纪录 才两天就被刷新了");
			List<String> url_list = new ArrayList<String>();
			if(i%2 == 1){
				String url1 = "http://photocdn.sohu.com/20170125/Img479566558_ss.jpeg";
				String url2 = "http://photocdn.sohu.com/20170125/Img479566558_ss.jpeg";
				String url3 = "http://photocdn.sohu.com/20170125/Img479566558_ss.jpeg";
				news.setPicOne(url1);
				news.setPicOne(url2);
				news.setPicOne(url3);
			}
		}
		return null;
	}
}
