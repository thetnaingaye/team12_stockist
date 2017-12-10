package team12.stockist.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{
	@GetMapping("/login")
	public String showLoginPage(HttpSession session)
	{
		long cartID = new Date().getTime();
		session.setAttribute("cartID", cartID);
		return "login";
	}
	

}
