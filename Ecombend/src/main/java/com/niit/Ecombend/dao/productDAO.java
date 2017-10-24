package com.niit.Ecombend.dao;
import java.util.ArrayList;
import java.util.List;

import com.niit.Ecombend.models.Category;
import com.niit.Ecombend.models.Product;

public interface productDAO {
	void saveProduct(Product u);
	List<Product> getAllProduct();
	Product getProductById(int id);
	public void deleteProduct(int id);
	public void updateProduct(Product p);
	public void saveupdateProduct(Product p);
	public List<Product> getprbycatid(int id);
	}



