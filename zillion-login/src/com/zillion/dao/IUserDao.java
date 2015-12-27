package com.zillion.dao;

import com.zillion.pojo.User;


public interface IUserDao {

	/**
	 * �û���¼
	 * 
	 * @param user
	 * @return
	 */
	public int getMatchCount(User user);

	/**
	 * �����û��������û�
	 * 
	 * @param userName
	 * @return
	 */
	public int findUserByUserName(String userName);

	/**
	 * ע���û���Ϣ
	 * @param user
	 */
	public void registerUser(User user);

}
