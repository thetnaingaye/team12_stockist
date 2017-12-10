package team12.stockist.controller;

import static org.mockito.Matchers.intThat;

import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import team12.stockist.validator.CartItemValidator;
import team12.stockist.validator.CartValidator;

@RequestMapping(value = "/usagerecord/")
@Controller
public class UsageRecordController {

	@Autowired
	private UsageRecordService usageRecordService;

	@Autowired
	private UsageRecordDetailService usageRecordDetailService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartItemValidator ciValidator;

	@Autowired
	private CartValidator cValidator;

	// temporary
	@Autowired
	UserService userService;

	@InitBinder("cartItem")
	private void initCartItemValidator(WebDataBinder binder) {
		binder.addValidators(ciValidator);
	}

	@InitBinder("cart")
	private void initCartValidator(WebDataBinder binder) {
		binder.addValidators(cValidator);
	}

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
		} else {
			cart = (Cart) session.getAttribute("cart");
		}
		cart.setCartId(Long.toString((long) session.getAttribute("cartID")));
		cart.setUser(userDetails);
		cart.setDateUsed(new Date());

		session.setAttribute("cart", cart);
		modelAndView.addObject("cart", cart);
		return modelAndView;
	}

	@RequestMapping(value = "/viewcart", method = RequestMethod.POST)
	public ModelAndView Checkout(@ModelAttribute @Valid Cart model, BindingResult result, HttpSession session) {

		if (result.hasErrors())
			return new ModelAndView("redirect:/usagerecord/viewcart/");

		Cart cart = (Cart) session.getAttribute("cart");
		UsageRecord usageRecord = new UsageRecord();
		ArrayList<UsageRecordDetail> usageRecordDetails = new ArrayList<UsageRecordDetail>();
		ModelAndView modelAndView = new ModelAndView();
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
			// Check for re-ordering here...
			Product product = productService.findProductById(cartItem.product.getPartID());
			product.setUnitsInStock(product.getUnitsInStock() - cartItem.getQuantity());
			product.setUnitsOnOrder(product.getUnitsOnOrder() + checkForReOrder(product));
			productService.updateProduct(product);
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
	public ModelAndView updateCartItem(@PathVariable int index, @ModelAttribute @Valid CartItem cartItem,
			BindingResult result, HttpSession session) {

		if (result.hasErrors())
			return new ModelAndView("edit-cartitem");

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

	private int checkForReOrder(Product product) {
		int reOrderLevel;
		if (product.getUnitsInStock() < product.getReorderLevel()) {

			if ((product.getReorderLevel() - product.getUnitsInStock()) >= product.getMinReorderQty()) {
				reOrderLevel = (product.getReorderLevel() - product.getUnitsInStock());
			} else {
				reOrderLevel = product.getMinReorderQty();
			}
		} else {
			reOrderLevel = 0;
		}

		return reOrderLevel;
	}
}
