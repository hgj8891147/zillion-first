package com.zillion.dao;

import com.zillion.pojo.User;


public interface IUserDao {

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public int getMatchCount(User user);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param userName
	 * @return
	 */
	public int findUserByUserName(String userName);

	/**
	 * 注册用户信息
	 * @param user
	 */
	public void registerUser(User user);

}
