package com.niit.Ecombend.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.Ecombend.models.Category;

@Repository("CategoryDaoimpl")
public class CategoryDaoimpl implements categoryDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public void CategoryDaoimpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}


	public void saveCategory(Category category) 
	{
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.save(category);
		t.commit();
		s.close();
		
	}
	public List<Category> getallcategory() {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Query q= ssn.createQuery("from Category");
		List<Category> l=(List<Category>) q.list();
		
        t.commit();
        ssn.close();
		
		return l;
	}
	public Category getcatbyid(int cat) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Category l = (Category) ssn.get(Category.class, cat);
        System.out.println(l.getName()+l.getId());
		
        t.commit();
        
        ssn.close();
		
		return l;
	}
	public void deletecategory(int id) {
	
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		Category l = (Category) ssn.get(Category.class, id);
		ssn.delete(l);
		t.commit();
        
        ssn.close();
		
		
}


	public void updatecategory(Category c) {
		Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		 ssn.update(c);
		t.commit();
        ssn.close();
		
		
	}


	public void saveupdatecategory(Category c) {
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.save(c);
		t.commit();
		s.close();
		
		
	}


	
	
	

}	
	
	
	
		
		


	


