package com.zillion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zillion.pojo.User;
import com.zillion.service.IUserService;

/**
 * 标注成为一个Spring MVC的Controller
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
			return new ModelAndView("login", "error", "用户名/密码错误..!");
		} else {
			return new ModelAndView("index", "uname", user.getUserName());
		}
	}

	@RequestMapping(value = "/register.action")
	public ModelAndView register(User user) {
		boolean isExist = userService.findUserByUserName(user.getUserName());
		if (isExist) {
			return new ModelAndView("register", "error", "用户名已存在!");
		} else {
			userService.registerUser(user);
			return new ModelAndView("login");
		}
	}
}
