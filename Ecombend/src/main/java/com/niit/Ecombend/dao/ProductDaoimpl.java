package com.niit.Ecombend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Ecombend.models.Category;
import com.niit.Ecombend.models.Product;
import com.niit.Ecombend.models.Supplier;

@Repository("ProductDaoimpl")
public class ProductDaoimpl implements productDAO{

	@Autowired
			SessionFactory sessionFactory;
			@Autowired
			public void ProductDaoImpl(SessionFactory sessionfactory)
			{
				this.sessionFactory=sessionfactory;
			}

		
			public void saveProduct(Product product) 
			{
				Session s=sessionFactory.openSession();
				Transaction t=s.beginTransaction();
				s.save(product);
				t.commit();
				s.close();
				
			}


	public List<Product> getAllProduct() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		
		List<Product> l=(List<Product>) ssn.createCriteria(Product.class).list();
		
        t.commit();
        ssn.close();
		
		return l;
	}

	public Product  getProductById(int id)  {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Product l = (Product) ssn.get(Product.class, id);
        System.out.println(l.getName()+l.getId());
		
        t.commit();
        
        ssn.close();
		
		return l;
	}


	public void deleteProduct(int id) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Product l = (Product) ssn.get(Product.class, id);
		ssn.delete(l);
				
		
        t.commit();
        
        ssn.close();
		
		
	}


	public void updateProduct(Product p) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		 ssn.update(p);
		
        t.commit();
        
        ssn.close();
		
	}


	public void saveupdateProduct(Product p) {
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.update(p);
		t.commit();
		s.close();
		
		
	}


	public List<Product> getprbycatid(int id) {
		Session s=sessionFactory.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Product where cid="+id);
		List<Product> cat=(List<Product>)q.list();

        t.commit();
        s.close();
		return cat;
	}


	

	

}