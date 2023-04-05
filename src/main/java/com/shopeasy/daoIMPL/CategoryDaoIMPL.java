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
