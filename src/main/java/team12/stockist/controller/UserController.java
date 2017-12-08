package team12.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import team12.stockist.service.UserService;

@RequestMapping(value ="/user/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//@RequestMapping (value = "/yourlinkhere", method = RequestMethod.GET (or POST)
	//Public blah blah methods here

}
