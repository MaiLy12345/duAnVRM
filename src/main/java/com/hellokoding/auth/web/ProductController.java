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
import com.hellokoding.auth.service.categoryProductService;




@Controller
public class ProductController {
	@Autowired
	private ProductService productservice;
	@Autowired

	private categoryProductService categoryService;
	
	// danh sah san pham nha cho thue


	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", productservice.findAll());	
		return "admin/product_list";
	}
	
	// chuyen toi trang them san pham nha cho thue
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String add(Model model, @Valid Product product) {
		model.addAttribute("catagorys", categoryService.findAll());
		model.addAttribute("product", new Product());
		return "admin/product_form";
	}

	
	// luu san pham nha cho thue

	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String listCategory(Model model) {
		model.addAttribute("category_product", productservice.findAll());
		return "admin/product_form";
	}


	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String  save(@Valid Product product,RedirectAttributes redicert) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		product.setNgaytao(ft.format(date));
		product.setLoai("Nhachothue");
		productservice.save(product);
		return "redirect:/product/list";
    }
	
	// sua san pham nha cho thue
	@RequestMapping(value = "/product/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model) {		
	   model.addAttribute("product", productservice.findById(id));
	   return "admin/product_form";
    }
	
	// xoa san pham nha cho thue
	@RequestMapping(value = "/product/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable Long id,RedirectAttributes redicert) {
	   productservice.delete(id);
	   return "redirect:/product/list";
     }
	
	//danh sach san pham nha cho mua 
	@RequestMapping(value="/product/nha-mua/list")
	public String listHomeBuy(Model model) {
		model.addAttribute("products", productservice.findAll());
		return "admin/product_list_hombuy";
	}
	//chuyen toi form them san pham
	@RequestMapping(value="/product/nha-mua/add")
	public String addHomeBuy(Model model) {
		model.addAttribute("product", new Product());
		return "admin/product_form_homebuy";
	}
	// them nha cho mua 
	@RequestMapping(value="/product/nha-mua/save", method = RequestMethod.POST)
	public String saveHomeBuy(@Valid Product product,Model model) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		product.setNgaytao(ft.format(date));
		
		product.setLoai("Nhaban");
		productservice.save(product);
		return "redirect:/product/nha-mua/list";
	}
	// sua san pham nha cho mua
	@RequestMapping(value="/product/nha-mua/{id}/edit")
	public String editHomeBuy(@PathVariable Long id, Model model) {
		model.addAttribute("product", productservice.findById(id));
		return "admin/product_form_homebuy";
	}
	
	// xoa san pham nha cho mua
	@RequestMapping(value="/product/nha-mua/{id}/delete")
	public String deleteHomBuy(@PathVariable Long id) {
		productservice.delete(id);
		return "redirect:/product/nha-mua/list";
	}

	
}
