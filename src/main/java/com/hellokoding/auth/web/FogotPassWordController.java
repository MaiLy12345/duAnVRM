package com.hellokoding.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FogotPassWordController {
	@RequestMapping(value = "/fogot-password", method = RequestMethod.GET)
	public String fogotPassword() {
		return "web/fogot-password";
	}
	
	@RequestMapping(value = "/newPassword", method = RequestMethod.GET)
	public String newPassword() {
		return "web/rest-password";
	}
}
