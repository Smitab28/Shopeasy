package com.shopeasy.daoIMPL;

import java.util.Comparator;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopeasy.dao.ProductDao;
import com.shopeasy.entity.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean saveProduct(Product product) {
		Session session= null;
		boolean isSaved = false;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Product.class);
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				isSaved = true;
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return isSaved;
	}

	@Override
	public boolean saveMultipleProduct(List<Product> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session = null;
		boolean isUpdated = false;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Product.class);
				Transaction transaction = session.beginTransaction();
				List<Product> list = criteria.list();
				Product unupdatedProduct =  getSingleProductById(product.getProductId());
				int index = list.indexOf(unupdatedProduct);
				list.set(index, product);
				isUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return isUpdated;
	}

	@Override
	public Product getSingleProductById(String productId) {
		Session session= null;
		
		List<Product> list = null;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Product.class);
				list = criteria.list();
				for (Product product : list) {
					if(product.productId.equals(productId))
						return product;
				}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		Session session= null;
		List<Product> list = null;
		try {
				session = sf.openSession();
				Criteria criteria = session.createCriteria(Product.class);
				list = criteria.list();
				return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return null;
	}

	@Override
	public boolean deleteProduct(String productId) {
		boolean isDeleted =false;
		Session session = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public int getCountOfTotalProduct() {
		Session session = null;
		int count =0;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			count = criteria.list().size();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return count;
	}

	@Override
	public double sumOfProductPrice() {
		Session session = null;
		double sum=0;
		try {
			session =sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			List<Product> list = criteria.list();
			for (Product product : list) {
				sum += product.getProductPrice();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;
	}

	@Override
	public List<Product> sortProductById_ASC() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();
			list  = (List<Product>) list.stream().sorted();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<Product> sortProductByName_DESC() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			list  = (List<Product>) criteria.addOrder(Order.desc("productName"));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public Product getMaxPriceProduct() {
		Session session =null;
		Product product =null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			List<Product> list = criteria.list();
		    product = list.stream().max(Comparator.comparingDouble(val -> val.getProductPrice())).get();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return product;
	}

	@Override
	public Product getMinPriceProduct() {
		Session session =null;
		Product product =null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			List<Product> list = criteria.list();
		    product = list.stream().min(Comparator.comparingDouble(val -> val.getProductPrice())).get();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return product;
	}

}
