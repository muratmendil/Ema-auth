package com.formation.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.UserDao;
import com.formation.exeption.ErrorExeption;
import com.formation.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) throws ErrorExeption {
		if(user.newAccountfieldNotEmpty()){
			User newUser = userDao.createUser(user);
			if(newUser != null){
				return newUser;
			}else{
				throw new ErrorExeption("Email existant", "Vous avez deja un compte");
			}
		}else{
			throw new ErrorExeption("Champs vide", "Un ou plusieurs champs sont vide");
		}
	}

	@Override
	public User findById(int id) throws ErrorExeption{
		User user = userDao.findById(id);
		if(user != null){
			return user;
		}else{
			throw new ErrorExeption("User inexistant", "ce user n'existe pas");
		}
	}

	@Override
	public List<User> findById() {
		return null;
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Override
	public User findByEmail(String email) throws ErrorExeption {
		if(email != null){
			User user=  userDao.findByEmail(email);
			if(user != null){
				return user;

			}else{
				throw new ErrorExeption("Champs vides", "Les champs sont vides");
			}
		}else{
			throw new ErrorExeption("Champs vides", "Les champs sont vides");
		}
	}

	@Override
	public User findByEmailAndPassword(String email, String password) throws ErrorExeption {
		if(email != null  && password != null){
			User user=  userDao.findByEmailAndPassword(email, password);
			if(user != null){
				return user;
			}else{
				throw new ErrorExeption("User inexistant", "ce user n'existe pas");
			}
		}else{
			throw new ErrorExeption("Champs vides", "Les champs sont vides");
		}
	}
}
