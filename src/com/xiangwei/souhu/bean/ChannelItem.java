package com.xiangwei.souhu.bean;

import java.io.Serializable;

/**
 * ITEM的对应可序化队列属性
 * */
public class ChannelItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6465237897027410019L;
	/** 栏目对应ID */
	public Integer id;
	/** 栏目对应NAME */
	public String name;
	/** 栏目在整体中的排序 */
	public Integer orderId;
	/** 栏目是否选中 */
	public Integer selected;

	public ChannelItem() {
	}

	public ChannelItem(Integer id, String name, Integer orderId,
			Integer selected) {
		super();
		this.id = id;
		this.name = name;
		this.orderId = orderId;
		this.selected = selected;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * @param prderId
	 *            the prderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the selected
	 */
	public Integer getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChannelItem [id=" + id + ", name=" + name + ", prderId="
				+ orderId + ", selected=" + selected + "]";
	}

}
