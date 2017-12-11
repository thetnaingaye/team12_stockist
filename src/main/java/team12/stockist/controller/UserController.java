package team12.stockist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import team12.stockist.model.Supplier;
import team12.stockist.model.User;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team12.stockist.service.UserService;

@RequestMapping(value ="/admin/user")
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("user-list");
		ArrayList<User> userList =(ArrayList<User>) userService.findAllUser();
		mav.addObject("userList", userList);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("user-new");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createUserPage(@ModelAttribute @Valid User user, BindingResult result) {

		ModelAndView mav = new ModelAndView();

		userService.createUser(user);
		mav.setViewName("redirect:/admin/user/list");

		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("user-edit");
		int iid=Integer.parseInt(id);
		User user = userService.findUserById(iid);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUserPage(@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");
		userService.updateUser(user);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");
		int iid=Integer.parseInt(id);
		User user = userService.findUserById(iid);
		userService.deleteUser(user);
		return mav;
	}

}
