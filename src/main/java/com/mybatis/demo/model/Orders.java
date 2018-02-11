package com.mybatis.demo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Orders {

	private Integer productOrderId;
	private Integer productUserId;
	private String productAmount;
	private Date productOrderedDate;
	private Date productSaleDate;
	private Date productShipedDate;

	/**
	 * 
	 */
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productOrderId
	 * @param productUserId
	 * @param productAmount
	 * @param productOrderedDate
	 * @param productSaleDate
	 * @param productShipedDate
	 */
	public Orders(Integer productOrderId, Integer productUserId, String productAmount, Date productOrderedDate,
			Date productSaleDate, Date productShipedDate) {
		super();
		this.productOrderId = productOrderId;
		this.productUserId = productUserId;
		this.productAmount = productAmount;
		this.productOrderedDate = productOrderedDate;
		this.productSaleDate = productSaleDate;
		this.productShipedDate = productShipedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (productAmount == null) {
			if (other.productAmount != null)
				return false;
		} else if (!productAmount.equals(other.productAmount))
			return false;
		if (productOrderId == null) {
			if (other.productOrderId != null)
				return false;
		} else if (!productOrderId.equals(other.productOrderId))
			return false;
		if (productOrderedDate == null) {
			if (other.productOrderedDate != null)
				return false;
		} else if (!productOrderedDate.equals(other.productOrderedDate))
			return false;
		if (productSaleDate == null) {
			if (other.productSaleDate != null)
				return false;
		} else if (!productSaleDate.equals(other.productSaleDate))
			return false;
		if (productShipedDate == null) {
			if (other.productShipedDate != null)
				return false;
		} else if (!productShipedDate.equals(other.productShipedDate))
			return false;
		if (productUserId == null) {
			if (other.productUserId != null)
				return false;
		} else if (!productUserId.equals(other.productUserId))
			return false;
		return true;
	}

	/**
	 * @return the productAmount
	 */
	public String getProductAmount() {
		return productAmount;
	}

	/**
	 * @return the productOrderedDate
	 */
	public Date getProductOrderedDate() {
		return productOrderedDate;
	}

	/**
	 * @return the productOrderId
	 */
	public Integer getProductOrderId() {
		return productOrderId;
	}

	/**
	 * @return the productSaleDate
	 */
	public Date getProductSaleDate() {
		return productSaleDate;
	}

	/**
	 * @return the productShipedDate
	 */
	public Date getProductShipedDate() {
		return productShipedDate;
	}

	/**
	 * @return the productUserId
	 */
	public Integer getProductUserId() {
		return productUserId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productAmount == null) ? 0 : productAmount.hashCode());
		result = prime * result + ((productOrderId == null) ? 0 : productOrderId.hashCode());
		result = prime * result + ((productOrderedDate == null) ? 0 : productOrderedDate.hashCode());
		result = prime * result + ((productSaleDate == null) ? 0 : productSaleDate.hashCode());
		result = prime * result + ((productShipedDate == null) ? 0 : productShipedDate.hashCode());
		result = prime * result + ((productUserId == null) ? 0 : productUserId.hashCode());
		return result;
	}

	/**
	 * @param productAmount
	 *            the productAmount to set
	 */
	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}

	/**
	 * @param productOrderedDate
	 *            the productOrderedDate to set
	 */
	public void setProductOrderedDate(Date productOrderedDate) {
		this.productOrderedDate = productOrderedDate;
	}

	/**
	 * @param productOrderId
	 *            the productOrderId to set
	 */
	public void setProductOrderId(@JsonProperty("productOrderId") Integer productOrderId) {
		this.productOrderId = productOrderId;
	}

	/**
	 * @param productSaleDate
	 *            the productSaleDate to set
	 */
	public void setProductSaleDate(Date productSaleDate) {
		this.productSaleDate = productSaleDate;
	}

	/**
	 * @param productShipedDate
	 *            the productShipedDate to set
	 */
	public void setProductShipedDate(Date productShipedDate) {
		this.productShipedDate = productShipedDate;
	}

	/**
	 * @param productUserId
	 *            the productUserId to set
	 */
	public void setProductUserId(Integer productUserId) {
		this.productUserId = productUserId;
	}

}
