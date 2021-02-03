package com.assesment.ProductCatalog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.ProductCatalog.dao.ProductCatalogDAO;
import com.assesment.ProductCatalog.entity.Product;


@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {
	
	@Autowired
	private ProductCatalogDAO productCatalogDAO;

	@Override
	public Product registerProduct(Product newProduct) {
	 
	 Product registeredProduct = productCatalogDAO.save(newProduct);
	 return registeredProduct;
	}
	

	@Override
	public String getProductById(int Id) {
		Optional<Product> productContainer = productCatalogDAO.findById(Id);
		
		if(productContainer.isPresent())
		return "success";
		
		else
			return "failure";
		
	}

	
	@Override
	public String deleteProduct(int Id) {
		
		if(productCatalogDAO.existsById(Id)) {
			productCatalogDAO.deleteById(Id);
			return "success";
		}else {
			
			return "failure";
		}
			

	}

	@Override
	public String udpateProductInfo(Product product, int id) {
		
		if(productCatalogDAO.existsById(id)) {
		Product updatedProduct = productCatalogDAO.save(product);
		return "success";	
		}else {
			return "failure";
		}
			
	}

}
