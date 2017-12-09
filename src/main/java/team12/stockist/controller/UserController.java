package team12.stockist.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.controller.UserSession;
import team12.stockist.model.User;
import team12.stockist.service.UserService;

@RequestMapping(value ="/user/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//@RequestMapping (value = "/yourlinkhere", method = RequestMethod.GET (or POST)
		//Public blah blah methods here
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (user.getUsername() != null && user.getPassword() != null) {
			User u = userService.authenticate(user.getUsername(), user.getPassword());
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			mav = new ModelAndView("redirect:/product/list");
			}
			
		else {
			return mav;
		}
		session.setAttribute("usersession", us);
		return mav;
	}
	

}
