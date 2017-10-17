package com.niit.Ecombend.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="SUPPLIER")
@Component
public class Supplier  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Column(name = "ADDRESS", nullable = false)
    private String address;
    
    @OneToMany(targetEntity=Product.class,mappedBy="supplier",cascade=CascadeType.ALL)
       private Set<Product> product;
       
    	public Set<Product> getProduct() {
    		return product;
    	}
    	public void setProduct(Set<Product> product) {
    		this.product = product;
    	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}

	

}

