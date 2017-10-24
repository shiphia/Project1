
package com.niit.Ecombend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Ecombend.dao.cartDAO;
import com.niit.Ecombend.models.Cart;
import com.niit.Ecombend.models.Product;



@Repository
public class CartDaoimpl implements cartDAO {

	@Autowired
	private SessionFactory sessionF;

	@Autowired
    public CartDaoimpl(SessionFactory sessionF) {

		this.sessionF = sessionF;
	}
		

	
	public void saveCart(Cart c) {
		Session session=sessionF.openSession();
		Transaction t=session.getTransaction();
		t.begin();
		session.save(c);
		t.commit();
		session.close();
		
	}

	public List<Cart> getcartbyusernmae(String Username) {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Query q=s.createQuery("from Cart where username='"+Username+"'");
		List<Cart> cat=(List<Cart>)q.list();

        t.commit();
        s.close();
		return cat;
	}

	public Product getprbyid(int id) {
		
		Session s=sessionF.openSession();
	Transaction t=s.getTransaction();
	t.begin();
	Product l = (Product) s.get(Product.class,id);
	
    t.commit();
    s.close();
   
	
	return l;
}
	
	public Cart getcartbyid(int id) {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Cart l = (Cart) s.get(Cart.class, id);
		
				
		
	    t.commit();
	    
	    s.close();
	    return l;
		
	}
	
	public void updatequantity(int cartid, int i) {
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		 Query qry1 = s.createQuery("update Cart  set quantity="+i+"where id="+cartid);
		 qry1.executeUpdate();
		 
	     t.commit();
	    
	    s.close();
		
	}
	
	public void deletecart(int id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		Cart p = (Cart) s.get(Cart.class, id);
		s.delete(p);
        t.commit();
        s.close();
	}
	
	public void updatecart(Cart id){
		Session s=sessionF.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.update(id);
        t.commit();
        s.close();
	}
	
}
