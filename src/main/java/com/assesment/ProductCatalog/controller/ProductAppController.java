package com.assesment.ProductCatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.ProductCatalog.bo.GenericAPIResponse;
import com.assesment.ProductCatalog.dao.ProductCatalogDAO;
import com.assesment.ProductCatalog.entity.Product;
import com.assesment.ProductCatalog.service.ProductCatalogService;

@RestController
@RequestMapping("ProductCatalog/api/v1")
public class ProductAppController {
	
	@Autowired
	private ProductCatalogService productCatalogService;
	
	@Autowired
	private ProductCatalogDAO productCatalogDAO;
	
	
	@PostMapping("registerNewProduct")
	public Product registerProduct(@RequestBody Product newProduct) {
		return productCatalogService.registerProduct(newProduct);
		
	}
	
	@GetMapping("getProductById/{pId}")
	public ResponseEntity<?> getProductById(@PathVariable int pId) {
		
		String dbStatus = productCatalogService.getProductById(pId);
		
		if(dbStatus =="success") {
			Product fetchedProduct = productCatalogDAO.findById(pId).get();	
			return new ResponseEntity<>(fetchedProduct,HttpStatus.OK);
		}
		else {
		     GenericAPIResponse response = new GenericAPIResponse();	
		     response.setStatus("failure");
		     response.setMessage("No Products found for the given Id:"+pId);
		     return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("updateProductInfo/{Id}")
	public ResponseEntity<?> updateProductInfo(@RequestBody Product product, @PathVariable int Id) {
		String dbStatus = productCatalogService.udpateProductInfo(product,Id);
		
		if(dbStatus =="success") {
			GenericAPIResponse response = new GenericAPIResponse();
			response.setStatus("success");
			response.setMessage("Product info with productId:"+Id+" has been updated successfully.");
			return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
		}else {
			 GenericAPIResponse response = new GenericAPIResponse();	
		     response.setStatus("failure");
		     response.setMessage("No Products found for the given Id:"+Id);
		     return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("removeProduct/{pId}")
	public ResponseEntity<?> delteProduct(@PathVariable int pId) {
		String dbStatus = productCatalogService.deleteProduct(pId);
		
		if(dbStatus =="success") {
			GenericAPIResponse response = new GenericAPIResponse();
			response.setStatus("success");
			response.setMessage("Product Info has been deleted successfully");
			return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
		}else {
			GenericAPIResponse response = new GenericAPIResponse();
			 response.setStatus("failure");
		     response.setMessage("No Products found for the given Id:"+pId);
		     return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		
	}

}
