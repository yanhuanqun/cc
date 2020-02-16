package com.parking.controller;

import com.parking.common.Response;
import com.parking.entity.User;
import com.parking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * register
	 * @param user user
	 * @return res
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map<String, Boolean> register(@RequestBody User user) {
		if (userService.insert(user) != null) {
			return Response.SUCCESS;
		}
		return Response.FAILED;
	}

	/**
	 * is the username repeat
	 * @param username username
	 * @return res
	 */
	@RequestMapping(value = "/nameRepeat", method = RequestMethod.POST)
	public Map<String, Boolean> nameRepeat(@Param("username") String username) {
		if (userService.findUserByUsername(username) != null) {
			return Response.SUCCESS;
		}
		return Response.FAILED;
	}

	/**
	 * login
	 * @param user user
	 * @return user
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		User res = userService.findUserByUsernameAndPassword(username, password);
		if (res != null) {
			res.setPassword("*********");
		}
		return res;
	}

	/**
	 * modify user info
	 * @param username username
	 * @param phone phone number
	 * @return res
	 */
	@RequestMapping(value = "/modifyInfo", method = RequestMethod.POST)
	public Map<String, Boolean> modifyInfo(@Param("username") String username,
										   @Param("phone") Long phone) {
		if (userService.modifyInfo(username, phone) != 1) {
			return Response.FAILED;
		}
		return Response.SUCCESS;
	}

}
