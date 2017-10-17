

package com.niit.Ecombend.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Set;
import org.springframework.stereotype.Component;

import java.io.*;

@Entity
@Table(name="PRODUCTS")
@Component

public class Product  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "PRICE", nullable = false)
    private int price;
    
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Column(name = "STOCK", nullable = false)
    private int stock;
  
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@ManyToOne
    @JoinColumn(name="cid",insertable=true,updatable=true,nullable=false)
    private Category category;
	
    @ManyToOne
    @JoinColumn(name="sid",insertable=true,updatable=true,nullable=false)
    private Supplier supplier;
    
    
    
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	

}

