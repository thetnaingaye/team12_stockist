package team12.stockist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team12.stockist.model.Product;
import team12.stockist.service.ProductService;
import team12.stockist.validator.newProductValidator;



@RequestMapping(value="/admin/product/")
@Controller
public class ProductAdminController {
	

	@Autowired
	private ProductService pservice;
	@Autowired
	private newProductValidator npValidator;
	@InitBinder("product")
	private void initProductBinder(WebDataBinder binder)
	{
		binder.addValidators(npValidator);
	}
	
	
	//-------------------- CREATE --------------------------//
	@RequestMapping(value = "/create", method = RequestMethod.GET)    // Directing to createProduct page
	public ModelAndView createProduct()
	{
		ModelAndView mav = new ModelAndView("product-new", "product", new Product());
		return mav;
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public ModelAndView newStudentPage(@ModelAttribute @Valid Product pdt, BindingResult result, final RedirectAttributes redirectAttributes)
	{
		if(result.hasErrors())
			return new ModelAndView("product-new");
		else
		{
			ModelAndView mav = new ModelAndView();
			
			pservice.createProduct(pdt);
		
			mav.setViewName("redirect:/mechanic/product/browse");
			

			String message = "New product " + pdt.getDescription() + " was successfully created.";
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
	}
}
