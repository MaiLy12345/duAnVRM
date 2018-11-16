package com.hellokoding.auth.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.service.ProductService;
import com.hellokoding.auth.service.categoryProductService;

@Controller
public class ProjectController {
	@Autowired
	private categoryProductService categoryService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/category/list", method = RequestMethod.GET)
	public String categoryList(Model model) {
		model.addAttribute("catagorys", categoryService.findAll());
		return "admin/category_list";
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public String categoryAdd(Model model) {
		model.addAttribute("category", new Category());
		return "admin/category_form";
	}

	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	public String catagorySave(@Valid Category category) {
		categoryService.save(category);
		return "redirect:/category/list";
	}

	@RequestMapping(value = "/category/{id}/edit", method = RequestMethod.GET)
	public String catagoryEit(@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryService.findByID(id));
		return "admin/category_form";
	}

	@RequestMapping(value = "/ucategory/{id}/delete", method = RequestMethod.GET)
	public String catagoryDelete(@PathVariable Long id, Model model) {
		categoryService.delete(id);
		return "redirect:/category/list";
	}

	// danh sach san pham theo du an
	@RequestMapping(value = "/category/product/{id}/list", method = RequestMethod.GET)
	public String catagoryProductlist(@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryService.findByID(id));
		model.addAttribute("products", productService.findAll());

		return "admin/category_product_list";
	}

	// duong link toi trang them san pha,
	@RequestMapping(value = "/category/product/add", method = RequestMethod.GET)
	public String add(Model model) {
		
		model.addAttribute("product", new Product());
		model.addAttribute("catagorys", categoryService.findAll());
		model.addAttribute("products", productService.findAll());
		return "admin/category_product_form";
	}

	// luu san pham vao csdl
	@RequestMapping(value = "/category/product/save", method = RequestMethod.POST)
	public String save(@Valid Product product) {
		product.setLoai("Duan");
		productService.save(product);
		return "redirect:/category/product/"+product.getCategory().getId()+"/list";

	}

	// sua san pham
	@RequestMapping(value = "/category/product/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("catagorys", categoryService.findAll());
		model.addAttribute("product", productService.findById(id));
		return "admin/category_product_form";
	}

	// xoa san pham
	@RequestMapping(value = "/category/product/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView model = new ModelAndView();
		Product product = productService.findById(id);
		model.setViewName("redirect:/category/product/"+product.getCategory().getId()+"/list");		
		productService.delete(id);
		return model;
		
	}
}
