package com.shopeasy.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopeasy.dao.CategoryDao;
import com.shopeasy.entity.Category;
import com.shopeasy.service.CategoryService;

@Service
public class CategoryServiceIMPL implements CategoryService {

	@Autowired
	private CategoryDao dao;
	@Override
	public boolean saveCategory(Category category) {
		boolean isSaved = dao.saveCategory(category);
		return isSaved;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category getCategorybyId(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
