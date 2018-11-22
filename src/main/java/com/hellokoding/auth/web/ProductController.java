package com.hellokoding.auth.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.repository.ProductRepository;
import com.hellokoding.auth.service.ProductService;
import com.hellokoding.auth.service.categoryProductService;



@Controller
public class ProductController {
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private categoryProductService categoryService;
	
	@Autowired
	private ProductRepository productRepository;
	
	// danh sah san pham nha cho thue


	@RequestMapping(value = "/product/cho-thue/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", productservice.findAll());	
		return "admin/product_list";
	}
	
	// chuyen toi trang them san pham nha cho thue
	@RequestMapping(value = "/product/cho-thue/add", method = RequestMethod.GET)
	public String add(Model model, @Valid Product product) {
		model.addAttribute("catagorys", categoryService.findAll());
		model.addAttribute("product", new Product());
		return "admin/product_form";
	}

	@RequestMapping(value = "/product/cho-thue/save", method = RequestMethod.POST)
    public String  save(@Valid Product product,RedirectAttributes redicert,@PathParam("id") Long id) {
		
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		product.setNgaytao(ft.format(date));
		product.setLoai("Nhachothue");	
		productservice.save(product);
		return "redirect:/product/cho-thue/list";
    
	}

	
	// sua san pham nha cho thue
	@RequestMapping(value = "/product/cho-thue/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model) {		
	   model.addAttribute("product", productservice.findById(id));
	   return "admin/product_update";
    }
	
	@RequestMapping(value = "/product/cho-thue/update", method = RequestMethod.POST)
    public String  update(@Valid Product product) {		
		productservice.save(product);
		return "redirect:/product/cho-thue/list";    
	}
	
	// xoa san pham nha cho thue
	@RequestMapping(value = "/product/cho-thue/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable Long id,RedirectAttributes redicert) {
	   productservice.delete(id);
	   return "redirect:/product/cho-thue/list";
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
		return "admin/product_homebuy_update";
	}
	
	@RequestMapping(value="/product/nha-mua/update", method = RequestMethod.POST)
	public String updateHomeBuy(@Valid Product product,Model model) {							
		productservice.save(product);		
		return "redirect:/product/nha-mua/list";
	}

	// xoa san pham nha cho mua
	@RequestMapping(value="/product/nha-mua/{id}/delete")
	public String deleteHomBuy(@PathVariable Long id) {
		productservice.delete(id);
		return "redirect:/product/nha-mua/list";
	}
	
	@RequestMapping(value="/fitter", method= RequestMethod.GET)
	public String fitter() {
		return "admin/fitter";
	}
	
//	 tim kiem san pham theo gia va dien tich
	@RequestMapping(value="/search", method= RequestMethod.GET)
		public String Search(Model model, @RequestParam(name="giatri",required=false) Long giatri, @RequestParam(name="dientich",required=false) Long dientich,
		@RequestParam(name="huong",required=false) String huong, @RequestParam(name="thanhpho",required=false) String thanhpho, 
			@RequestParam(name="quanhuyen", required=false) String quanhuyen,@RequestParam Map<String, String> requestParams ) {		
		String th = requestParams.get("thanhpho");
		String qh = requestParams.get("quanhuyen");
		String hg = requestParams.get("huong");
		
		if(th.equals("th") && hg.equals("hg") && qh.equals("qh")) {
			// dien tich, gia
			model.addAttribute("products", productRepository.finByGiaAndDienTich(giatri, dientich));	
			
		}else if(th.equals("th") && qh.equals("qh") ) {
			// dien tich, gia, huong
			model.addAttribute("products", productRepository.finByGiaAndDienTichAndHuong(giatri, dientich, huong));	
			
		}else if(hg.equals("hg") && qh.equals("qh") ) {
			// dien tich, gia, thanhpho
			model.addAttribute("products", productRepository.finByGiaAndDienTichAndThanhPho(giatri, dientich, thanhpho));	
			
		}else if(qh.equals("qh")) {
			//gia tri, huong, dien tich, thanh pho
			model.addAttribute("products",productRepository.finByGiaAndDienTichAndThanhPhoAndHuong(giatri, dientich, thanhpho, huong) );
			
		}else if(hg.equals("hg")) {
			// dien tich, gia, thanhpho, quanhuyen
			model.addAttribute("products", productRepository.finByGiaAndDienTichAndThanhPhoAndHuyen(giatri, dientich, thanhpho, quanhuyen));	
			
		}else{
		model.addAttribute("products", productRepository.finByGiaAndDienTichAndThanhPhoAndHuyenAndHuong(giatri, dientich, 
			thanhpho, quanhuyen, huong));	
		}
		return "admin/fitter";
	}
	
	
}
