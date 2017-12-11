package team12.stockist.controller;


import java.util.ArrayList;

import javax.validation.Valid;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.model.Supplier;
import team12.stockist.service.SupplierService;

@RequestMapping(value = "admin/supplier")
@Controller
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("supplier-list");
		ArrayList<Supplier> supplierList = (ArrayList<Supplier>) supplierService.findAll();
		mav.addObject("supplierList", supplierList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newSupplierPage() {
		ModelAndView mav = new ModelAndView("supplier-new");
		mav.addObject("supplier", new Supplier());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createSupplierPage(@ModelAttribute @Valid Supplier supplier, BindingResult result) {

		ModelAndView mav = new ModelAndView();

		supplierService.createSupplierRecord(supplier);
		mav.setViewName("redirect:/admin/supplier/list");

		return mav;
	}

	@RequestMapping(value = "/edit/{supplierID}", method = RequestMethod.GET)
	public ModelAndView editSupplierPage(@PathVariable String supplierID) {
		ModelAndView mav = new ModelAndView("supplier-edit");
		Supplier supplier = supplierService.findSupplierById(supplierID);
		mav.addObject("supplier", supplier);
		return mav;
	}

	@RequestMapping(value = "/edit/{supplierID}", method = RequestMethod.POST)
	public ModelAndView editStudentPage(@ModelAttribute Supplier supplier) {
		ModelAndView mav = new ModelAndView("redirect:/admin/supplier/list");
		supplierService.updateSupplierRecord(supplier);
		return mav;
	}

	@RequestMapping(value = "/delete/{supplierID}", method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable String supplierID) {
		ModelAndView mav = new ModelAndView("redirect:/admin/supplier/list");
		Supplier supplier = supplierService.findSupplierById(supplierID);
		supplierService.deleteSupplierRecord(supplier);
		return mav;
	}
}