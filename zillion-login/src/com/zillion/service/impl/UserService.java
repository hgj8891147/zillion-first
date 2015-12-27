package com.zillion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zillion.dao.IUserDao;
import com.zillion.pojo.User;
import com.zillion.service.IUserService;

/**
 * 将UserService标注为一个服务层的Bean
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public boolean hasMatchUser(User user) {
		boolean result = false;
		int count = userDao.getMatchCount(user);
		if (count > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean findUserByUserName(String userName) {
		boolean result = false;
		int count = userDao.findUserByUserName(userName);
		if (count > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public void registerUser(User user) {
		userDao.registerUser(user);
		
	}

}
