package com.hellokoding.auth.web;


import java.util.Arrays;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hellokoding.auth.model.Role;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.service.RoleService;
import com.hellokoding.auth.service.UserService;



@Controller
public class RoleController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private RoleService roleService;

	@RequestMapping(value="/role/{id}",method=RequestMethod.GET)
	public String role(@PathVariable Long id,Model model) {
		model.addAttribute("role", roleService.findAll());
		model.addAttribute("user", userService.findById(id));
		return "admin/role";
	}
	
	@RequestMapping(value="/role/save", method = RequestMethod.POST)
	public String roleSaveManager(@Valid User user, Model model) {		
		userService.save(user);
		return "redirect:/role/"+user.getId()+"";
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
