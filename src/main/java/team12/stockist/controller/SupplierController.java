package team12.stockist.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.service.CustomUserDetails;
import team12.stockist.service.SupplierService;

@RequestMapping (value ="admin/supplier/")
@Controller
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	//@RequestMapping (value = "/yourlinkhere", method = RequestMethod.GET (or POST)
	//Public blah blah methods here
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView supplierListPage(Principal principal,Authentication authentication) 
	{

		ModelAndView mav = new ModelAndView("admin");
		
		//getting username from principal object
		String username = principal.getName();
		
		//getting user object from Spring Security Authentication object , required methods are wired to user model
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		int userId = userDetails.getId();
		String userRole = userDetails.getUserRole();
		
		mav.addObject("userid",userId);
		mav.addObject("username",username);
		mav.addObject("userRole", userRole);
		
		return mav;
	}

}
