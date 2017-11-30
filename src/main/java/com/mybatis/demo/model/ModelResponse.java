package com.mybatis.demo.model;

public class ModelResponse {

	private String error;
	private int satus = 0;

	/**
	 * @return the satus
	 */
	public int getSatus() {
		return satus;
	}

	/**
	 * @param satus the satus to set
	 */
	public void setSatus(int satus) {
		this.satus = satus;
	}

	/**
	 * 
	 */
	public ModelResponse() {
		super();
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

}
