package com.niit.Ecombend.dao;



import java.util.ArrayList;


import com.niit.Ecombend.models.Cart;
import com.niit.Ecombend.models.order;

public interface orderdao {
	public void saveOrder(order o);
	public order getorbyusername(String username);
	public ArrayList<Cart> getcartbyusernmae(String Username);
	public void updateOrder(order o);

}
