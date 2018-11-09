package com.hellokoding.auth.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.service.ProductService;


@Controller
public class ProductController {
	@Autowired
	private ProductService productservice;

	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", productservice.findAll());
		return "admin/product_list";
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String add(Model model, @Valid Product product) {
		
		model.addAttribute("product", new Product());
		return "admin/product_form";
	}

	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String  save(@Valid Product product,RedirectAttributes redicert) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		product.setNgaytao(ft.format(date));
		productservice.save(product);
		return "redirect:/product/list";
    }

	@RequestMapping(value = "/product/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model) {
	   model.addAttribute("product", productservice.findById(id));
	   return "admin/product_form";
    }

	@RequestMapping(value = "/product/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable Long id,RedirectAttributes redicert) {
	   productservice.delete(id);
	   return "redirect:/product/list";
     }
}
