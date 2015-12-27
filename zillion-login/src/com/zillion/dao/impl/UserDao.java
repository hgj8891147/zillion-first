package com.zillion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zillion.dao.IUserDao;
import com.zillion.pojo.User;

/**
 * 通过spring注解定义一个DAO
 */
@Repository
public class UserDao implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int getMatchCount(User user) {
		String sql = "select count(1) from user where username=? and password=?";
		int count = jdbcTemplate.queryForObject(sql,
				new Object[] { user.getUserName(), user.getPassword() },
				Integer.class);
		return count;
	}

	@Override
	public int findUserByUserName(String userName) {
		String sql = "select count(1) from user where username=?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { userName },
				Integer.class);
		return count;
	}

	@Override
	public void registerUser(User user) {
		String sql = "insert into user(username,password) values(?,?)";
		jdbcTemplate.update(sql,
				new Object[] { user.getUserName(), user.getPassword() });
	}
}
