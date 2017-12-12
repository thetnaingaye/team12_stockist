package team12.stockist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.exception.EmptyCartException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView emptyCartHandler(HttpServletRequest req, HttpSession session, Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error-page");
		modelAndView.addObject("url", req.getRequestURI());
		modelAndView.addObject("user", session.getAttribute("cart"));
		modelAndView.addObject("message", "NullPointerException");
		//when attempt to checkout empty cart
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public ModelAndView illegalStateException(Exception ex) {
		ModelAndView modelAndView = new ModelAndView("default");
		//when try to edit none existing product id and supplier id
		//attempt to amend none existing record (check id)
		
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}
	
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ModelAndView invalidDateAccessApiUsageException(Exception ex) {
		ModelAndView modelAndView = new ModelAndView("default");
		//When try delete none existing product id
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}
	
	@ExceptionHandler(JpaSystemException.class)
	public ModelAndView JpaSystemException(Exception ex) {
		ModelAndView modelAndView = new ModelAndView("default");
		//When try to create new product with an existing primary key
		//Also include FK not existed conflict
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}
	
	//to also replace 403 forbidden error page

}
