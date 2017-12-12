package team12.stockist.controller;

import java.util.ArrayList;
import java.util.Date;

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
		ArrayList<String> troubleshoot = new ArrayList<String>();

		String error1 = "Check that if you are trying to checkout an empty cart?";
		troubleshoot.add(error1);

		modelAndView.addObject("url", req.getRequestURI());
		modelAndView.addObject("time", new Date());
		modelAndView.addObject("user", session.getAttribute("cart"));
		modelAndView.addObject("message", "NullPointerException");
		modelAndView.addObject("troubleshoot", troubleshoot);
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}

	@ExceptionHandler(IllegalStateException.class)
	public ModelAndView illegalStateException(HttpServletRequest req, HttpSession session, Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error-page");
		ArrayList<String> troubleshoot = new ArrayList<String>();

		String error1 = "Please check you have selected a valid Product or Supplier.";
		troubleshoot.add(error1);
		// when try to edit none existing product id and supplier id
		// attempt to amend none existing record (check id)

		modelAndView.addObject("url", req.getRequestURI());
		modelAndView.addObject("time", new Date());
		modelAndView.addObject("user", session.getAttribute("cart"));
		modelAndView.addObject("message", "IllegalStateException");
		modelAndView.addObject("troubleshoot", troubleshoot);
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}

	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ModelAndView invalidDateAccessApiUsageException(HttpServletRequest req, HttpSession session, Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error-page");
		ArrayList<String> troubleshoot = new ArrayList<String>();

		String error1 = "Please check you are deleting a valid Supplier.";
		troubleshoot.add(error1);
		// When try delete none existing product id
		modelAndView.addObject("url", req.getRequestURI());
		modelAndView.addObject("time", new Date());
		modelAndView.addObject("user", session.getAttribute("cart"));
		modelAndView.addObject("message", "IllegalStateException");
		modelAndView.addObject("troubleshoot", troubleshoot);
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}

	@ExceptionHandler(JpaSystemException.class)
	public ModelAndView JpaSystemException(HttpServletRequest req, HttpSession session, Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error-page");
		ArrayList<String> troubleshoot = new ArrayList<String>();

		String error1 = "Check that you are creating a valid database entry.";
		troubleshoot.add(error1);

		// When try to create new product with an existing primary key
		// Also include FK not existed conflict

		modelAndView.addObject("url", req.getRequestURI());
		modelAndView.addObject("time", new Date());
		modelAndView.addObject("user", session.getAttribute("cart"));
		modelAndView.addObject("message", "IllegalStateException");
		modelAndView.addObject("troubleshoot", troubleshoot);
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView GeneralError(HttpServletRequest req, HttpSession session, Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error-page");
		ArrayList<String> troubleshoot = new ArrayList<String>();

		String error1 = "General Error! Please contact IT Support for assistance.";
		troubleshoot.add(error1);

		// When try to create new product with an existing primary key
		// Also include FK not existed conflict

		modelAndView.addObject("url", req.getRequestURI());
		modelAndView.addObject("time", new Date());
		modelAndView.addObject("user", session.getAttribute("cart"));
		modelAndView.addObject("message", "IllegalStateException");
		modelAndView.addObject("troubleshoot", troubleshoot);
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}

	// to also replace 403 forbidden error page

}
