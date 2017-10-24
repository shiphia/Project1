
package com.niit.Ecombend.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.niit.Ecombend.dao.orderdao;
import com.niit.Ecombend.models.Cart;
import com.niit.Ecombend.models.order;

@Repository
public class orderdaoimpl implements orderdao {

	@Autowired
	private SessionFactory sessionF;

	@Autowired
    public orderdaoimpl(SessionFactory sessionF) {

		this.sessionF = sessionF;
	}
	
	public void saveOrder(order o){
		Session session=sessionF.openSession();
		Transaction t=session.getTransaction();
		t.begin();
		session.save(o);
		t.commit();
		session.close();
	
	}
	
	public order getorbyusername(String username){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from order where USERNAME='"+username+"'");
		order or=(order)q.list().get(0);
        t.commit();
        s.close();
		return or;
	}
	
	public ArrayList<Cart> getcartbyusernmae(String Username) {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Cart where USERNAME='"+Username+"'");
		ArrayList<Cart> cat=(ArrayList<Cart>)q.list();

        t.commit();
        s.close();
		return cat;
	}
	
	
	public void updateOrder(order o){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.update(o);
        t.commit();
        s.close();
	}

	
}
