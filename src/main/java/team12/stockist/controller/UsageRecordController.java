package team12.stockist.controller;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.hibernate.type.descriptor.java.CalendarTimeTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.header.writers.frameoptions.StaticAllowFromStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.model.Product;
import team12.stockist.model.UsageRecord;
import team12.stockist.model.UsageRecordDetail;
import team12.stockist.service.CustomUserDetails;
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
	public ModelAndView ViewCart(Object object, HttpSession session, Authentication authentication) {
		ModelAndView modelAndView = new ModelAndView("view-cart");
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		Cart cart;
		if (session.getAttribute("cart") == null)

		{
			cart = new Cart();

			// ProductController
			// Khair most likely will use arraylist, use session state to catch his
			// arraylist to here.
			ArrayList<CartItem> cartItemList = new ArrayList<CartItem>();
			CartItem cartItem1 = new CartItem();
			CartItem cartItem2 = new CartItem();

			// ---- Start of fake items for code testing
			// Temporary random generator
			String cartIdNumber = Long.toString((long) session.getAttribute("cartID"));
			// End of temporary generator
			// Create some fake hard coded products to add
			cartItem1.setProduct(productService.findProductById(123));
			cartItem1.setQuantity(1);
			cartItem2.setProduct(productService.findProductById(234));
			cartItem2.setQuantity(1);
			// End of fake object creation
			// Addition of cartItem to cartItemList - expect this to be done in
			// ProductController
			// Final version should be retrieval of "cartItemList" from HttpSession state
			cartItemList.add(cartItem1); // ArrayList
			cartItemList.add(cartItem2); // ArrayList

			cart.setCartId(cartIdNumber);
			cart.setUser(userDetails);
			cart.setDateUsed(new Date());
			cart.setCartItemList(cartItemList);
			// end of temporary list
		}
		else 
		{
			cart = (Cart) session.getAttribute("cart");
		}


		session.setAttribute("cart", cart);
		modelAndView.addObject("cart", cart);
		return modelAndView;
	}

	@RequestMapping(value = "/viewcart", method = RequestMethod.POST)
	public ModelAndView Checkout(@ModelAttribute Cart model, HttpSession session) {

		Cart cart = (Cart) session.getAttribute("cart");
		ModelAndView modelAndView = new ModelAndView();
		UsageRecord usageRecord = new UsageRecord();
		ArrayList<UsageRecordDetail> usageRecordDetails = new ArrayList<UsageRecordDetail>();

		usageRecord.setTransID(cart.getCartId());
		usageRecord.setCustomerName(model.getCustomerName());
		usageRecord.setUserId(cart.getUser().getId());
		usageRecord.setDateUsed(cart.getDateUsed());
		usageRecordService.createUsageRecord(usageRecord);

		for (CartItem cartItem : cart.getCartItemList()) {
			UsageRecordDetail usageRecordDetail = new UsageRecordDetail();
			usageRecordDetail.setTransId(cart.getCartId());
			usageRecordDetail.setProductPartId(cartItem.getProduct().getPartID());
			usageRecordDetail.setUsedQty(cartItem.getQuantity());
			usageRecordDetails.add(usageRecordDetail);
		}
		usageRecordDetailService.addUsageRecordDetailList(usageRecordDetails);

		long cartID = new Date().getTime();
		Cart cartNew = new Cart();
		session.setAttribute("cartID", cartID);
		session.setAttribute("cart", cartNew);

		modelAndView.setViewName("redirect:/");
		return modelAndView;
	}

	@RequestMapping(value = "viewcart/edit/{index}", method = RequestMethod.GET)
	public ModelAndView editCartItem(@PathVariable int index, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("edit-cartitem");
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<CartItem> cartItemList = cart.getCartItemList();
		CartItem cartItem = cartItemList.get(index);

		modelAndView.addObject("cartItem", cartItem);

		return modelAndView;
	}

	@RequestMapping(value = "viewcart/edit/{index}", method = RequestMethod.POST)
	public ModelAndView updateCartItem(@PathVariable int index, CartItem cartItem, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<CartItem> cartItemList = cart.getCartItemList();

		cartItemList.set(index, cartItem);
		cart.setCartItemList(cartItemList);

		session.setAttribute("cart", cart);
		modelAndView.setViewName("redirect:/usagerecord/viewcart/");

		return modelAndView;
	}

	@RequestMapping(value = "viewcart/delete/{index}", method = RequestMethod.GET)
	public ModelAndView deleteCartItem(@PathVariable int index, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<CartItem> cartItemList = cart.getCartItemList();
		cartItemList.remove(index);
		cart.setCartItemList(cartItemList);

		session.setAttribute("cart", cart);
		modelAndView.setViewName("forward:/usagerecord/viewcart/");

		return modelAndView;
	}
}
