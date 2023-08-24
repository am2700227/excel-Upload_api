package com.example.ExcelUpDown.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private Integer productId;
	@Column
	private String productName;
	@Column
	private String productDesc;
	@Column
	private Double productPrice;

	/**
	 * @param productId
	 * @param productName
	 * @param productDesc
	 * @param productPrice
	 */
	public Product(Integer productId, String productName, String productDesc, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}

	/**
	 * 
	 */
	public Product() {
		super();
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * @return the productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param i the productPrice to set
	 */
	public void setProductPrice(double i) {
		this.productPrice = i;
	}

}
