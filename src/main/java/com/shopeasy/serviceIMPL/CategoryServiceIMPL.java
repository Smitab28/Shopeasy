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
		boolean isUpdated = dao.updateCategory(category);
		return isUpdated;
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		boolean isDeleted = dao.deleteCategory(categoryId);
		return isDeleted;
	}

	@Override
	public Category getCategorybyId(int categoryId) {
		Category category = dao.getCategorybyId(categoryId);
		return category;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> list = dao.getAllCategory();
		return list;
	}

}
