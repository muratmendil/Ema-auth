package com.formation.dao;


import com.formation.exeption.ErrorExeption;
import com.formation.model.User;

public interface UserDao{
	User createUser(User user);
	User findById(int id);
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
	String logout();
	void deleteUser(int id);
}