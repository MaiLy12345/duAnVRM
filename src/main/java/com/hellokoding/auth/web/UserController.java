package com.hellokoding.auth.web;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.service.ProductService;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.validator.UserValidator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private ProductService productService;
   
  

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String registration() {
       
        return "403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "web/login";
    }

    @RequestMapping(value = { "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("user1", userService.count());
        model.addAttribute("product1", productService.count());
        return "admin/dashboard";
    }
    
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String userlist(Model model) {
    	model.addAttribute("users", userService.findAll());
    	return "admin/userlist";
    }
    
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String useradd(Model model) {
    	model.addAttribute("user", new User());
    	return"admin/userform";
    }
    @RequestMapping(value = "/user/{id}/edit", method = RequestMethod.GET)
    public String useredit(Model model,@PathVariable Long id) {
    	model.addAttribute("user", userService.findById(id));
    	return "admin/userform";
    }
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String usersave(@Valid User user, RedirectAttributes redirect) {
    	userService.save(user);
    	return "redirect:/user/list";
    }
    @RequestMapping(value = "/user/{id}/delete", method = RequestMethod.GET)
    public String userdetete(@PathVariable Long id) {
    	userService.delete(id);
    	return "redirect:/user/list";
    }
}
