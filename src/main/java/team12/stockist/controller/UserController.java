package team12.stockist.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import team12.stockist.model.User;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import team12.stockist.service.UserService;
import team12.stockist.validator.UserValidator;

@RequestMapping(value = "/admin/user")
@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	private UserValidator userValidator;

	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("user-list");
		ArrayList<User> userList = (ArrayList<User>) userService.findAllUser();
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("user-new","user", new User());
		Map< String, String > role = new HashMap<String, String>();
        role.put("mechanic", "mechanic");
        role.put("admin", "admin");
		mav.addObject("roleList", role);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createUserPage(@ModelAttribute @Valid User user, BindingResult result) {

		if (result.hasErrors())
			return new ModelAndView("user-new");
		ModelAndView mav = new ModelAndView();

		userService.createUser(user);
		mav.setViewName("redirect:/admin/user/list");

		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("user-edit");
		int iid = Integer.parseInt(id);
		User user = userService.findUserById(iid);
		Map< String, String > role = new HashMap<String, String>();
        role.put("mechanic", "mechanic");
        role.put("admin", "admin");
		mav.addObject("roleList", role);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUserPage(@ModelAttribute @Valid User user, BindingResult result, @PathVariable String id) {
		if (result.hasErrors())
			return new ModelAndView("user-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");

		userService.updateUser(user);

		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");
		int iid = Integer.parseInt(id);
		User user = userService.findUserById(iid);
		userService.deleteUser(user);
		return mav;
	}

}
