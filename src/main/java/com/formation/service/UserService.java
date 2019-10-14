package com.formation.service;


import java.util.List;

import com.formation.exeption.ErrorExeption;
import com.formation.model.User;

public interface UserService {
	User createUser(User user) throws ErrorExeption;
	User findById(int id) throws ErrorExeption;;
	User findByEmailAndPassword(String email, String password) throws ErrorExeption;;
	User findByEmail(String email) throws ErrorExeption;
	List<User> findById();
	void deleteUser(int id);
}


