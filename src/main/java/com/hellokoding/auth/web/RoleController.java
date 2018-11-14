package com.hellokoding.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {

	@RequestMapping(value="/role",method=RequestMethod.GET)
	public String role() {
		return "admin/role";
	}
	
	@RequestMapping(value="/role/save/manager", method = RequestMethod.POST)
	public String roleSaveManager() {
		return "";
	}
	
	@RequestMapping(value="role/save/du-an",method = RequestMethod.POST)
	public String roleSaveDuan() {
		return "";
	}
	
	@RequestMapping(value="role/save/nha-mua",method =RequestMethod.POST)
	public String roleSaveNhaMua() {
		return "";
	}
		
	@RequestMapping(value="role/save/nha-ban",method = RequestMethod.POST)
	public String roleSaveNhaBan() {
		return "";
	}
}
