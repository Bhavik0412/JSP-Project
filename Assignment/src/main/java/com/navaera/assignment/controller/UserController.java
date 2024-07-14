package com.navaera.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navaera.assignment.entity.User;
import com.navaera.assignment.service.CustomerService;
import com.navaera.assignment.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	CustomerService customerService;

	@GetMapping("/reg")
	public String UserREG() {
		System.out.println("USER REG-----");
		return "UserREG";
	}

	@PostMapping("/signup")
	public String userSignup(@ModelAttribute("user") User user, Model m) {
		String userName = userService.saveUser(user);
		m.addAttribute("allCustomers", customerService.getAllCustomer());
		return "ViewCustomerList";
	}

}
