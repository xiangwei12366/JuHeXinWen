package com.xiangwei.souhu.domain;

import java.io.Serializable;


public class Data implements Serializable{

	/**新闻标识*/
	private String uniquekey;
	/**新闻item标题*/
	private String title;
	/**新闻更新日期*/
	private String date;
	/**新闻类型*/
	private String category;
	/**新闻来源-网站*/
	private String author_name;
	/**新闻URL*/
	private String url;
	/**新闻图片1地址*/
	private String thumbnail_pic_s;
	/**新闻图片2地址*/
	private String thumbnail_pic_s02;
	/**新闻图片3地址*/
	private String thumbnail_pic_s03;
	/**
	 * @return the uniquekey
	 */
	public String getUniquekey() {
		return uniquekey;
	}
	/**
	 * @param uniquekey the uniquekey to set
	 */
	public void setUniquekey(String uniquekey) {
		this.uniquekey = uniquekey;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the author_name
	 */
	public String getAuthor_name() {
		return author_name;
	}
	/**
	 * @param author_name the author_name to set
	 */
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the thumbnail_pic_s
	 */
	public String getThumbnail_pic_s() {
		return thumbnail_pic_s;
	}
	/**
	 * @param thumbnail_pic_s the thumbnail_pic_s to set
	 */
	public void setThumbnail_pic_s(String thumbnail_pic_s) {
		this.thumbnail_pic_s = thumbnail_pic_s;
	}
	/**
	 * @return the thumbnail_pic_s02
	 */
	public String getThumbnail_pic_s02() {
		return thumbnail_pic_s02;
	}
	/**
	 * @param thumbnail_pic_s02 the thumbnail_pic_s02 to set
	 */
	public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
		this.thumbnail_pic_s02 = thumbnail_pic_s02;
	}
	/**
	 * @return the thumbnail_pic_s03
	 */
	public String getThumbnail_pic_s03() {
		return thumbnail_pic_s03;
	}
	/**
	 * @param thumbnail_pic_s03 the thumbnail_pic_s03 to set
	 */
	public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
		this.thumbnail_pic_s03 = thumbnail_pic_s03;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Data [uniquekey=" + uniquekey + ", title=" + title + ", date="
				+ date + ", category=" + category + ", author_name="
				+ author_name + ", url=" + url + ", thumbnail_pic_s="
				+ thumbnail_pic_s + ", thumbnail_pic_s02=" + thumbnail_pic_s02
				+ ", thumbnail_pic_s03=" + thumbnail_pic_s03 + "]";
	}

	

}
