package com.parking.service;

import com.parking.dao.UserDao;
import com.parking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

	private final UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public User insert(User user) {
		return userDao.saveAndFlush(user);
	}

	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

	public User findUserByUsernameAndPassword(String username, String password) {
		return userDao.findUserByUsernameAndPassword(username, password);
	}

	public int modifyInfo(String username, Long phone) {
		return userDao.modifyInfo(username, phone);
	}

}
