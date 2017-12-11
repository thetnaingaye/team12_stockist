package team12.stockist.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import team12.stockist.model.Supplier;
import team12.stockist.service.SupplierService;
import team12.stockist.validator.SupplierValidator;

@RequestMapping(value = "admin/supplier")
@Controller
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	@Autowired
	private SupplierValidator supplierValidator;

	@InitBinder("supplier")
	private void initSupplierBinder(WebDataBinder binder) {
		binder.addValidators(supplierValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("supplier-list");
		ArrayList<Supplier> supplierList = (ArrayList<Supplier>) supplierService.findAllSupplier();
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

		if (result.hasErrors())
			return new ModelAndView("supplier-new");
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
	public ModelAndView editSupplierPage(@ModelAttribute @Valid Supplier suppliers, BindingResult result,
			@PathVariable String supplierID) {
		if (result.hasErrors())
			return new ModelAndView("supplier-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/supplier/list");

		supplierService.updateSupplierRecord(suppliers);

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