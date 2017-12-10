package team12.stockist.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
	public ModelAndView ViewCart(Object object, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("view-cart");
		
		//Assume that there is a cart and CartItem class - may be subjected to change
		//On load, instantiate new Cart, retrieve CartItemList (or Product) from Session state and put it into Cart
		//CartItem suppose to instantiate on productlist page where AddToCart function is, subject to change to ArrayList
		//Here i assume that validation logic on product qty is performed in ProductController
		Cart cart = new Cart();
		ArrayList<CartItem> cartItemList = new ArrayList<CartItem>();
		CartItem cartItem1 = new CartItem();
		CartItem cartItem2 = new CartItem();
		
		//---- Start of fake items for code testing
		// Temporary random generator
		Random random = new Random();
		int cartIdNumber = random.nextInt(9999);
		// End of temporary generator
		// Create some fake hard coded products to add
		cartItem1.setProduct(productService.findProductById(123));
		cartItem1.setQuantity(1);
		cartItem2.setProduct(productService.findProductById(234));
		cartItem2.setQuantity(1);
		// End of fake object creation
		//Addition of cartItem to cartItemList - expect this to be done in ProductController
		//Final version should be retrieval of "cartItemList" from HttpSession state
		cartItemList.add(cartItem1);
		cartItemList.add(cartItem2);

		//cartId logic may replace with by latest TransID + 1
		//But this has to assume that there should be no delete of TransID record!!
		//Otherwise create cartIdNumber for UsageRecordTable, but this may have replication (as it is by pure random number)
		//In another method is completely remove cartIdNumber business logic
		cart.setCartId(cartIdNumber);
		//Here, user is hard coded. Need to use Pradeep's Session state for retrieval
		cart.setUser(userService.findUserById(2));
		cart.setDateUsed(new Date());
		//Here is hard coded. Will impletement function in JSP page for mechanic to enter customer name (TODO by ChangSiang)
		cart.setCustomerName("HelloWorld");
		cart.setCartItemList(cartItemList);
		// end of temporary list
		
		//TODO by Chang Siang: implement function allowing mechanic to edit cart
		//Pass the Cart object into session state as "cartlist" - all small case as agreed during discussion
		session.setAttribute("cartlist", cart);

		modelAndView.addObject("cartList", cart);
		return modelAndView;
	}

	@RequestMapping(value = "/viewcart", method = RequestMethod.POST)
	public ModelAndView Checkout(HttpSession session) {

		//Retrival of the cart from the session state
		Cart cart = (Cart) session.getAttribute("cartlist");

		ModelAndView modelAndView = new ModelAndView();

		//Create new usageRecord object and map Cart information into UsageRecord
		UsageRecord usageRecord = new UsageRecord();
		usageRecord.setCustomerName(cart.getCustomerName());
		usageRecord.setUserId(cart.getUser().getId());
		usageRecord.setDateUsed(cart.getDateUsed());
		//The UsageRecord need to file first to facilitate retrieval of TransID for UsageRecordDetail
		usageRecordService.createUsageRecord(usageRecord);
		
		//Retrieve the whole list of usage record
		ArrayList<UsageRecord> currentUsageRecordList = usageRecordService.findAllUsageRecord();
		//Retrieve the last record (index = total size - 1), assuming last record is always the newest record
		UsageRecord currentUsageRecord = currentUsageRecordList.get(currentUsageRecordList.size() - 1);
		ArrayList<UsageRecordDetail> usageRecordDetails = new ArrayList<UsageRecordDetail>();
		for (CartItem cartItem : cart.getCartItemList()) {
			UsageRecordDetail usageRecordDetail = new UsageRecordDetail();
			//at here get the TransId from the freshly filed UsageRecord
			usageRecordDetail.setTransId(currentUsageRecord.getTransID());
			usageRecordDetail.setProductPartId(cartItem.getProduct().getPartID());
			usageRecordDetail.setUsedQty(cartItem.getQuantity());
			usageRecordDetails.add(usageRecordDetail);
		}
		//If success, you will see the homepage. This will need to be refined further to make it more sexy....
		modelAndView.setViewName("redirect:/");
		

		//I have added a new method in usageRecordDetailService to accept list and create automatically
		//Might need to rename the method for better readability
		usageRecordDetailService.addUsageRecordDetailList(usageRecordDetails);
		return modelAndView;
	}
}
