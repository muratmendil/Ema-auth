package com.formation.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.exeption.ErrorExeption;
import com.formation.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager userManager;

	@Override
	public User createUser(User user) {
		User newUser = userManager.merge(user);
		return newUser;
	}

	@Override
	public User findById(int id) {
		return userManager.find(User.class, id);
	}

	@Override
	public String logout() {
		String user = null;
		String identifier = user;
		return "index";
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		String sql = "SELECT user.* FROM user AS user WHERE email = ? && password = ?";
		Query query = userManager.createNativeQuery(sql, User.class);
		query.setParameter(1, email);
		query.setParameter(2, password);

		User user = new User();
		try {
		    user = (User) query.getSingleResult();
			System.out.println(user.toString());
		} catch (NoResultException e) {
		}
		System.out.println(user.toString());
		return user;
	}

	@Override
	public void deleteUser(int id) {
		String sql = "DELETE user.* FROM user AS user WHERE user_id = ?";
		Query query = userManager.createNativeQuery(sql, User.class);
		query.setParameter(1, id);
		int res = query.executeUpdate();
	}

	@Override
	public User findByEmail(String email) {
		String sql = "SELECT user.* FROM user AS user WHERE email = ?";
		Query query = userManager.createNativeQuery(sql, User.class);
		query.setParameter(1, email);

		User user = new User();
		try {
		    user = (User) query.getSingleResult();
			System.out.println(user.toString());
		} catch (NoResultException e) {
			
		}
		return user;
	}
}
