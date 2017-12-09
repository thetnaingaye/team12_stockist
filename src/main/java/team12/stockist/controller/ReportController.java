package team12.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.service.ProductService;

@RequestMapping(value="/print/")
@Controller
public class ReportController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value ="/report", method = RequestMethod.GET)
	public ModelAndView printReport() {
		ModelAndView modelAndView = new ModelAndView("print-report");
		//write logic here
		return modelAndView;
	}
	

}
