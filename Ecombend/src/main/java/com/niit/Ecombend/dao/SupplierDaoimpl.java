package com.niit.Ecombend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.Ecombend.models.Supplier;

@Repository("SupplierDaoimpl")
public class SupplierDaoimpl implements SupplierDAO{


	@Autowired
			SessionFactory sessionFactory;
			@Autowired
			public void SupplierDaoimpl(SessionFactory sessionfactory)
			{
				this.sessionFactory=sessionfactory;
			}

		
			public void saveSupplier(Supplier supplier) 
			{
				Session s=sessionFactory.openSession();
				Transaction t=s.beginTransaction();
				s.save(supplier);
				t.commit();
				s.close();
				
			}


			public List<Supplier> getAllSupplier() {
				Session ssn=sessionFactory.openSession();
				Transaction t=ssn.getTransaction();
				t.begin();
				Query q= ssn.createQuery("from Supplier");
				List<Supplier> l1=(List<Supplier>) q.list();
				
		        t.commit();
		        ssn.close();
				
				return l1;
			}
			public Supplier  getSupplierById(int id)  {
				Session ssn=sessionFactory.openSession();
				Transaction t=ssn.getTransaction();
				t.begin();
				Supplier l = (Supplier) ssn.get(Supplier.class, id);
		        System.out.println(l.getName()+l.getId());
				
		        t.commit();
		        
		        ssn.close();
				
				return l;
			}


				public void deletesupplier(int id) {
					Session ssn=sessionFactory.openSession();
					Transaction t=ssn.getTransaction();
					t.begin();
					Supplier l = (Supplier) ssn.get(Supplier.class, id);
					ssn.delete(l);
							
					
			        t.commit();
			        
			        ssn.close();
				
			}


			public void updatesupplier(Supplier s) {
				Session ssn=sessionFactory.openSession();
				Transaction t=ssn.getTransaction();
				t.begin();
				
				ssn.update(s);
						
				
		        t.commit();
		        
		        ssn.close();
						
				
			}


			public void saveupdatesupplier(Supplier s) {
				Session ss=sessionFactory.openSession();
				Transaction t=ss.beginTransaction();
				ss.save(s);
				t.commit();
				ss.close();
				
				
			}


			

			


	
}