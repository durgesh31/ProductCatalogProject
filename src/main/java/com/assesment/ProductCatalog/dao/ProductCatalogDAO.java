package com.assesment.ProductCatalog.dao;

import org.springframework.data.repository.CrudRepository;

import com.assesment.ProductCatalog.entity.Product;

public interface ProductCatalogDAO extends CrudRepository<Product, Integer> {

}
