package com.piyush.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.piyush.demo.model.User;
import com.piyush.demo.service.UserRepository;

@Controller
public class LoginController {
	
		@Autowired
		UserRepository userrepo;
	
		@RequestMapping("login")
		public ModelAndView root(@RequestParam("loginemail") String loginemail,@RequestParam("loginpassword") String loginpassword)
		{
			ModelAndView mv=new ModelAndView("index");
			mv.addObject("loginemail", loginemail);
			return mv;
			
		}
		@RequestMapping("NewUser")
		public String newUser(){
			System.out.println("NewUserCalled");
			return "NewUser";
		}
		
		@RequestMapping("createNewUser")
		public  ModelAndView create(@RequestParam("username") String username,@RequestParam("useremail") String useremail,
				@RequestParam("userpassword") String userpassword,@RequestParam("usercontact") String usercontact){
			User user = new User(username, useremail, userpassword, usercontact);
			
			System.out.println(user);
			userrepo.save(user);
		
			ModelAndView mv=new ModelAndView("welcome");
			mv.addObject("user",user);
			mv.addObject("isLoggedIn",new Boolean("TRUE"));
			
			System.out.println("new user creation");
			return mv;
		}
	}
