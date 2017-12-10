package team12.stockist.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.model.Product;
import team12.stockist.model.Supplier;
import team12.stockist.service.ProductService;
import team12.stockist.service.SupplierService;

@RequestMapping(value = "/print/")
@Controller
public class ReportController {

	@Autowired
	ProductService productService;

	@Autowired
	SupplierService supplierService;

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView printReport() {
		ModelAndView modelAndView = new ModelAndView("display-report");
		HashMap<Supplier, ArrayList<Product>> orderListMap = new HashMap<Supplier, ArrayList<Product>>();
		ArrayList<Supplier> supplierList = supplierService.findAll();
		for (Supplier supplier : supplierList) {
			ArrayList<Product> supplierProductList = productService.findProductBySupplier(supplier.getSupplierID());
			if (supplierProductList.size() > 0)
				orderListMap.put(supplier, supplierProductList);
			
		}
		modelAndView.addObject("orderListMap", orderListMap);
		modelAndView.addObject("supplierList", supplierList);

		return modelAndView;
	}

}
