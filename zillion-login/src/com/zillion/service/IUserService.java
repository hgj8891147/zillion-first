package com.zillion.service;

import com.zillion.pojo.User;


public interface IUserService {
	
	/**
	 * ����û���/�������ȷ��
	 * @param user
	 * @return
	 */
	public boolean hasMatchUser(User user);
	
	/**
	 * �����û��������û�
	 * @param userName
	 * @return
	 */
	public boolean findUserByUserName(String userName);
	

	/**
	 * ע���û���Ϣ
	 * @param user
	 */
	public void registerUser(User user);
}
