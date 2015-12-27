package com.zillion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zillion.pojo.User;
import com.zillion.service.IUserService;

/**
 * ��ע��Ϊһ��Spring MVC��Controller
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login.action")
	public ModelAndView login(User user) {
		boolean isValidUser = userService.hasMatchUser(user);
		if (!isValidUser) {
			return new ModelAndView("login", "error", "�û���/�������..!");
		} else {
			return new ModelAndView("index", "uname", user.getUserName());
		}
	}

	@RequestMapping(value = "/register.action")
	public ModelAndView register(User user) {
		boolean isExist = userService.findUserByUserName(user.getUserName());
		if (isExist) {
			return new ModelAndView("register", "error", "�û����Ѵ���!");
		} else {
			userService.registerUser(user);
			return new ModelAndView("login");
		}
	}
}
