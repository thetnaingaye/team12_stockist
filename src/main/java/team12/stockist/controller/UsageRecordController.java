package team12.stockist.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team12.stockist.model.Product;
import team12.stockist.model.UsageRecord;
import team12.stockist.model.UsageRecordDetail;
import team12.stockist.service.ProductService;
import team12.stockist.service.UsageRecordDetailService;
import team12.stockist.service.UsageRecordService;
import team12.stockist.service.UserService;

@RequestMapping(value = "/usagerecord/")
@Controller
public class UsageRecordController {

	@Autowired
	UsageRecordService usageRecordService;

	@Autowired
	UsageRecordDetailService usageRecordDetailService;

	@Autowired
	ProductService productService;

	// temporary
	@Autowired
	UserService userService;

	// @RequestMapping (value = "/yourlinkhere", method = RequestMethod.GET (or
	// POST)
	// Public blah blah methods here

	@RequestMapping(value = "/viewcart", method = RequestMethod.GET)
	public ModelAndView ViewCart(Object object) {
		ModelAndView modelAndView = new ModelAndView("view-cart");
		//Temporary random generator
		Random random = new Random();
		int cartIdNumber = random.nextInt(9999);
		//End of temporary generator
		// temporary list here
		Cart cart = new Cart();
		ArrayList<CartItem> cartItemList = new ArrayList<CartItem>();
		CartItem cartItem1 = new CartItem();
		CartItem cartItem2 = new CartItem();
		cartItem1.setProduct(productService.findProductById(123));
		cartItem1.setQuantity(1);
		cartItem2.setProduct(productService.findProductById(234));
		cartItem2.setQuantity(1);
		cartItemList.add(cartItem1);
		cartItemList.add(cartItem2);
		cart.setCartId(cartIdNumber);
		cart.setUser(userService.findUserById(1));
		cart.setDateUsed(new Date());
		cart.setCustomerName("HelloWorld");
		cart.setCartItemList(cartItemList);
		//end of temporary list
		modelAndView.addObject("cartList", cart);
		return modelAndView;
	}

	@RequestMapping(value="/viewcart", method = RequestMethod.POST)
	public ModelAndView Checkout(@ModelAttribute Cart cart, final RedirectAttributes redirectAttributes){
		ModelAndView modelAndView = new ModelAndView();
		
		ArrayList<UsageRecordDetail> usageRecordDetails = new ArrayList<UsageRecordDetail>();
		UsageRecord usageRecord = new UsageRecord();
		usageRecord.setCustomerName(cart.getCustomerName());
		usageRecord.setUserId(cart.user.getId());
		usageRecord.setDateUsed(cart.getDateUsed());
		
		for(CartItem cartItem : cart.getCartItemList()) {
			UsageRecordDetail usageRecordDetail = new UsageRecordDetail();
			usageRecordDetail.setTransId(usageRecord.getTransID());
			usageRecordDetail.setProductPartId(cartItem.getProduct().getPartID());
			usageRecordDetail.setUsedQty(cartItem.getQuantity());
			usageRecordDetails.add(usageRecordDetail);
		}
		modelAndView.setViewName("redirect:/");
		usageRecordDetailService.addUsageRecordDetailList(usageRecordDetails);
		return modelAndView;
	}
}
