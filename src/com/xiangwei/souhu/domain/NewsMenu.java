package com.xiangwei.souhu.domain;

import java.io.Serializable;

/**
 * 分类信息封装 使用Gson解析时,对象书写技巧: 1. 逢{}创建对象, 逢[]创建集合(ArrayList) 2.
 * 所有字段名称要和json返回字段高度一致
 * 
 * @author Administrator
 * 
 */
public class NewsMenu implements Serializable {
	private String reason;
	private Result result;
	private int error_code;

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the results
	 */
	public Result getResults() {
		return result;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(Result result) {
		result = result;
	}

	/**
	 * @return the error_code
	 */
	public int getError_code() {
		return error_code;
	}

	/**
	 * @param error_code
	 *            the error_code to set
	 */
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NewsMenu [reason=" + reason + ", Result=" + result
				+ ", error_code=" + error_code + "]";
	}

}
