package com.niit.Ecombend.dao;

import java.util.List;

import com.niit.Ecombend.models.Category;



public interface categoryDAO {
	void saveCategory(Category c);
	
	public List<Category> getallcategory();
	public Category getcatbyid(int cat);
	public void deletecategory(int id);
	public void updatecategory(Category c);
	public void saveupdatecategory(Category c);

}

