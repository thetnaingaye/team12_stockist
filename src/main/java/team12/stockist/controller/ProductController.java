package team12.stockist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import team12.stockist.model.Product;
import team12.stockist.service.ProductService;

@RequestMapping(value="/product/")
@Controller
public class ProductController 
{
	@Autowired
	private ProductService pservice;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage() 
	{
		ModelAndView mav = new ModelAndView("product-list");
		ArrayList<Product> pList = (ArrayList<Product>) pservice.findAllProduct();
		mav.addObject("productList", pList);
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView viewLogin()
	{
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String viewLogin1()
	{
	
		return "login";
	}
	
}
