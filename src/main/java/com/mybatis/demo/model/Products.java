package com.mybatis.demo.model;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Products extends ResourceSupport {

	private Integer productId;
	private String productName;
	private String productVersion;
	private String productView;
	private String procductDesc;

	/**
	 * 
	 */
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productId
	 * @param productName
	 * @param productVersion
	 * @param productView
	 * @param procductDesc
	 */
	public Products(Integer productId, String productName, String productVersion, String productView,
			String procductDesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productVersion = productVersion;
		this.productView = productView;
		this.procductDesc = procductDesc;
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (procductDesc == null) {
			if (other.procductDesc != null)
				return false;
		} else if (!procductDesc.equals(other.procductDesc))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productVersion == null) {
			if (other.productVersion != null)
				return false;
		} else if (!productVersion.equals(other.productVersion))
			return false;
		if (productView == null) {
			if (other.productView != null)
				return false;
		} else if (!productView.equals(other.productView))
			return false;
		return true;
	}

	/**
	 * @return the procductDesc
	 */
	public String getProcductDesc() {
		return procductDesc;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the productVersion
	 */
	public String getProductVersion() {
		return productVersion;
	}

	/**
	 * @return the productView
	 */
	public String getProductView() {
		return productView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((procductDesc == null) ? 0 : procductDesc.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productVersion == null) ? 0 : productVersion.hashCode());
		result = prime * result + ((productView == null) ? 0 : productView.hashCode());
		return result;
	}

	/**
	 * @param procductDesc
	 *            the procductDesc to set
	 */
	public void setProcductDesc(String procductDesc) {
		this.procductDesc = procductDesc;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(@JsonProperty("productId") Integer productId) {
		this.productId = productId;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param productVersion
	 *            the productVersion to set
	 */
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	/**
	 * @param productView
	 *            the productView to set
	 */
	public void setProductView(String productView) {
		this.productView = productView;
	}

}
