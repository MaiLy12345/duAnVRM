package com.hellokoding.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FogotPassWordController {
	
	
	@RequestMapping(value = "/fogot-password", method = RequestMethod.GET)
	public String fogotPassword() {
		return "web/fogot-password";
	}
	
	@RequestMapping(value = "/newPassword", method = RequestMethod.POST)
	public String fogotPagelink(@RequestParam("email") String email, Model model) {
		
		return "";
	}
	@RequestMapping(value = "/newPassword", method = RequestMethod.GET)
	public String newPassword() {
		return "web/rest-password";
	}
}
