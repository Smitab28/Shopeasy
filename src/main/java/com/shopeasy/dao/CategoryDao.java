package com.shopeasy.dao;

import java.util.List;

import com.shopeasy.entity.Category;

public interface CategoryDao {

	public boolean saveCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryId);
	public Category getCategorybyId(int categoryId);
	public List<Category> getAllCategory();
	
}
