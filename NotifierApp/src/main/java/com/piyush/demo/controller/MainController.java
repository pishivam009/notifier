package com.piyush.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.piyush.demo.model.Notebook;
import com.piyush.demo.model.User;
import com.piyush.demo.service.NotebookRepository;
import com.piyush.demo.service.UserRepository;

@Controller
@SessionAttributes({"user","isLoggedIn"})
public class MainController {
	
		@Autowired
		UserRepository userrepo;
		
		@Autowired
		NotebookRepository nbrepo;
		

		@PostMapping("login")
		public ModelAndView home(@RequestParam("loginemail") String loginemail, @RequestParam("loginpassword") String loginpassword)
		{
			ModelAndView mv=new ModelAndView();
			
			User user=userrepo.findByEmail(loginemail);
			System.out.println(user);
			if((user!=null) && (user.getPassword().equals(loginpassword))) {
				System.out.println("Login Success");
				mv.setViewName("welcome");
				System.out.println("Login Success 1");
				mv.addObject("user",user);
				System.out.println("Login Success2");
				mv.addObject("isLoggedIn",true);
				System.out.println("Login Success3");
			}
			else {
				mv.setViewName("index");
				mv.addObject("message","Email ID not found");
			}
			System.out.println("Login Success4");
			System.out.println(mv);
			return mv;
			
		}
		@RequestMapping("NewUser")
		public String newUser(){
			System.out.println("NewUserCalled");
			return "NewUser";
		}
		@RequestMapping("logout")
		public String logout(HttpSession session, HttpServletResponse response){
			session.invalidate();
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setHeader("Expires", "0"); // Proxies.
			System.out.println("Logged Out");
			return "index";
		}
		
		@RequestMapping("createNewUser")
		public  ModelAndView create(@RequestParam("username") String username,@RequestParam("useremail") String useremail,
				@RequestParam("userpassword") String userpassword,@RequestParam("usercontact") String usercontact){
			User user = new User();
			user.setEmail(useremail);
			user.setName(username);
			user.setNumber(usercontact);
			user.setPassword(userpassword);
			
			System.out.println(user);
			

			ModelAndView mv=new ModelAndView("index");
			if(userrepo.findByEmail(useremail)!=null) {
				mv.addObject("message","Email Already Exist");	
			}else {
				userrepo.save(user);
				mv.addObject("message","User Added Successfully");
			}
			
			return mv;
		}
		
		@RequestMapping("editUser")
		public ModelAndView editUser(HttpSession session){
			
			System.out.println("editUserCalled");
			System.out.println(session.getAttribute("user"));
			ModelAndView mv=new ModelAndView("EditUser");
			mv.addObject("user",session.getAttribute("user"));
			mv.addObject("isLoggedIn",session.getAttribute("isLoggedIn"));
			return mv;
		}
		
		@PostMapping("createNotebook")
		public ModelAndView createNotebook(@RequestParam("nbname") String nbname, HttpSession session){
			Notebook nb=nbrepo.findByNbname(nbname);
			ModelAndView mv=new ModelAndView();
			User u=(User) session.getAttribute("user");
			if(nb!=null && nb.getNbname().equals(nbname) && u.getEmail().equals(nb.getUseremail())) {
				mv.addObject("message","Notebook exists");
				mv.setViewName("NewNotebook");
				System.out.println("Notebook exists");
			}
			else {
				Notebook newnb=new Notebook();
				newnb.setNbname(nbname);
				newnb.setUseremail(u.getEmail());
				nbrepo.save(newnb);
				mv.addObject("message","Notebook added");
				mv.setViewName("welcome");
				System.out.println("Notebook added");
				
			}
			return mv;
		}
		
		@RequestMapping("newNotebook")
		public ModelAndView newNotebook() {
			ModelAndView mv=new ModelAndView("NewNotebook");
			return mv;
		}
		@RequestMapping("showNotebooks")
		public ModelAndView showNotebooks(HttpSession session){
			String useremail= ((User)session.getAttribute("user")).getEmail();
		List<Notebook> l = nbrepo.findByUseremail(useremail);
		System.out.println(l);
		ModelAndView mv=new ModelAndView("welcome");
			mv.addObject("list",l);
			return mv;
		}
		
		@GetMapping("openNotebook/{nbid}")
		public ModelAndView openNotebook(@PathVariable("nbid") int nbid){
			System.out.println(nbid);
			return null;
		}
	}
