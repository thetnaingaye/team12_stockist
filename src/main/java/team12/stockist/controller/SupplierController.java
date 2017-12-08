package team12.stockist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import team12.stockist.service.SupplierService;

@RequestMapping (value ="/supplier/")
@Controller
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	//@RequestMapping (value = "/yourlinkhere", method = RequestMethod.GET (or POST)
	//Public blah blah methods here

}
