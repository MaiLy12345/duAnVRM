package com.hellokoding.auth.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.service.categoryProductService;

@Controller
public class ProjectController {
	@Autowired
	private categoryProductService categoryService;

	@RequestMapping(value = "/user/category/list", method = RequestMethod.GET)
	public String categoryList(Model model) {
		model.addAttribute("catagorys", categoryService.findAll());
		return "admin/category_list";
	}

	@RequestMapping(value = "/user/category/add", method = RequestMethod.GET)
	public String categoryAdd(Model model) {
		model.addAttribute("category", new Category());
		return "admin/category_form";
	}

	@RequestMapping(value = "/user/category/save", method = RequestMethod.POST)
	public String catagorySave(@Valid Category category) {
		categoryService.save(category);
		return "redirect:/user/category/list";
	}

	@RequestMapping(value = "/user/category/{id}/edit", method = RequestMethod.GET)
	public String catagoryEit(@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryService.findByID(id));
		return "admin/category_form";
	}

	@RequestMapping(value = "/user/category/{id}/delete", method = RequestMethod.GET)
	public String catagoryDelete(@PathVariable Long id, Model model) {
		categoryService.delete(id);
		return "redirect:/user/category/list";
	}
	
	//danh sach san pham theo du an
	@RequestMapping(value = "/user/category/product/{id}/list", method = RequestMethod.GET)
	public String catagoryProductlist(@PathVariable Long id, Model model) {
		
		return "category_product_list";
	}
	

}
