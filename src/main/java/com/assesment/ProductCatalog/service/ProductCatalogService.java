package com.assesment.ProductCatalog.service;

import com.assesment.ProductCatalog.entity.Product;

public interface ProductCatalogService {
	
	public Product registerProduct(Product newProduct);
	
	public String getProductById(int Id);
		
	public String deleteProduct(int Id);

	public String udpateProductInfo(Product product, int id);

}
