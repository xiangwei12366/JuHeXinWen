package com.xiangwei.souhu.domain;

import java.util.ArrayList;

public class Result {

	private int stat;
	private ArrayList<Data> data;

	/**
	 * @return the stat
	 */
	public int getStat() {
		return stat;
	}

	/**
	 * @param stat
	 *            the stat to set
	 */
	public void setStat(int stat) {
		this.stat = stat;
	}

	/**
	 * @return the datas
	 */
	public ArrayList<Data> getData() {
		return data;
	}

	/**
	 * @param datas
	 *            the datas to set
	 */
	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Result [stat=" + stat + ", data=" + data + "]";
	}

}
