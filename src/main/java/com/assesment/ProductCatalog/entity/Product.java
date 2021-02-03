package com.assesment.ProductCatalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="products_information")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	@NotNull(message ="Product Name cannot be empty.")
	private String productName;
	
	@Column(name="serial_number")
	@NotNull(message="SerialNumber is mandatory.")
	private String serialNumber;
	
	@Column(name="price")
	private int price;
	
	Product(){
		
	}

	public Product(int productId, String productName, String serialNumber, int price) {
	
		this.productId = productId;
		this.productName = productName;
		this.serialNumber = serialNumber;
		this.price = price;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", serialNumber=" + serialNumber
				+ ", price=" + price + "]";
	}
	
	

}
