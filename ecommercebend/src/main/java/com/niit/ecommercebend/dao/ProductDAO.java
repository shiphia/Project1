package com.niit.ecommercebend.dao;

import java.util.List;

import com.niit.ecommercebend.model.Product;



public interface ProductDAO {
	void saveProduct();
	List<Product> getAllProducts();
	Product getProductById();

}
