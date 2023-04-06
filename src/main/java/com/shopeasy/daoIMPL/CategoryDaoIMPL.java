package com.shopeasy.daoIMPL;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopeasy.dao.CategoryDao;
import com.shopeasy.entity.Category;

@Repository
public class CategoryDaoIMPL implements CategoryDao {

	@Autowired
	SessionFactory sf;
	@Override
	public boolean saveCategory(Category category) {
		boolean isSaved =false;
		Session session= null;
		try {
			session = sf.openSession();
			Criteria criteria =  session.createCriteria(Category.class);
			Transaction transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
			isSaved = true;
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return isSaved;
	}

	@Override
	public boolean updateCategory(Category category) {
		Session session = null;
		boolean isUpdated = false;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			List<Category> list = criteria.list();
			for (Category category2 : list) {
				if(category2.getCategoryId()==category.categoryId) {
					int index = list.indexOf(category2);
					list.set(index, category);
					isUpdated = true;
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		Session session = null;
		boolean isDeleted = false;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			List<Category> list = criteria.list();
			for (Category category : list) {
				if(category.getCategoryId()==categoryId) {
					int index = list.indexOf(category);
					list.remove(index);
					isDeleted = true;
				}
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public Category getCategorybyId(int categoryId) {
		Session session = null;
		Category category =null;
		try {
			session= sf.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			List<Category> list = criteria.list();
			category = list.stream().filter(val -> val.categoryId==categoryId).findFirst().get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public List<Category> getAllCategory() {
		Session session = null;
		List<Category> list =null;
		try {
			session= sf.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			 list = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

