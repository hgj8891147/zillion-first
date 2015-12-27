package com.zillion.service;

import com.zillion.pojo.User;


public interface IUserService {
	
	/**
	 * 检查用户名/密码的正确性
	 * @param user
	 * @return
	 */
	public boolean hasMatchUser(User user);
	
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public boolean findUserByUserName(String userName);
	

	/**
	 * 注册用户信息
	 * @param user
	 */
	public void registerUser(User user);
}
