package com.niit.Ecombend.dao;

import java.util.List;

import com.niit.Ecombend.models.User;

public interface UserDAO {
	void saveUser(User u);
	List<User> getAllUser();
	User getUserById();

}


