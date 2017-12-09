package team12.stockist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.model.Product;
import team12.stockist.service.SupplierService;

@RequestMapping (value ="admin/supplier/")
@Controller
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	//@RequestMapping (value = "/yourlinkhere", method = RequestMethod.GET (or POST)
	//Public blah blah methods here
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView supplierListPage() 
	{
		ModelAndView mav = new ModelAndView("admin");

		return mav;
	}

}
