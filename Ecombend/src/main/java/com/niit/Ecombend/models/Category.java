package com.niit.Ecombend.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Set;

@Entity
@Table(name="CATEGORY")
@Component
public class Category  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
		
    @OneToMany(targetEntity=Product.class,mappedBy="category",cascade=CascadeType.ALL)
    
       private Set<Product> product ;
    	public Set<Product> getProduct() {
    		return product;
    	}
    	public void setProduct(Set<Product> product) {
    		this.product = product;
    	}
    	
    	 @Column(name = "NAME", nullable = false)
    	 private String name;
   
    
   
    
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
	

	
	
}

