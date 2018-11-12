package com.hellokoding.auth.web;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.service.EmailService;
import com.hellokoding.auth.service.UserService;

@Controller
public class PassWordController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/fogot-password", method = RequestMethod.GET)
	public String fogotPassword() {
		return "web/fogot-password";
	}

	@RequestMapping(value = "/newPassword/link", method = RequestMethod.POST)
	public String fogotPagelink(@RequestParam("username") String username, Model model) {
		User finduser = userService.findByUsername(username);
		if (finduser == null) {
			model.addAttribute("error", "email không tồn tại");
		} else {
			finduser.setToken(UUID.randomUUID().toString());
			userService.save(finduser);
			String url = "http://localhost:8080";

			// Email message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("anhdvpd01920@fpt.edu.vn");

			passwordResetEmail.setTo(finduser.getUsername());
			passwordResetEmail.setSubject("Lấy lại mật khẩu");
			passwordResetEmail
					.setText("Đây là đường link lấy mật khẩu: " + url + "/reset?token=" + finduser.getToken());

			// send mail
			emailService.SendMail(passwordResetEmail);

			model.addAttribute("measage", "Vui lòng kiểm tra email của bạn");

		}

		return "redirect:/login";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView newPassword(@RequestParam("token") String token) {
		Optional<User> fintoken = userService.findByToken(token);
		ModelAndView model = new ModelAndView();
		if (fintoken.isPresent()) {
			model.addObject("token", token);
			model.setViewName("web/rest-password");
		} else {
			model.addObject("error", "Đường link không tồn tại");
			model.setViewName("403");
		}

		return model;
	}

	@RequestMapping(value = "/newPassword/save", method = RequestMethod.POST)
	public ModelAndView newPassword(@RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
		Optional<User> finduser = userService.findByToken(requestParams.get("token"));
		ModelAndView model = new ModelAndView();
		if (finduser == null) {
			model.addObject("error", "Đường link không tồn tại");
			model.setViewName("redirect:/reset");
		} else {

			User restUser = finduser.get();
			restUser.setPassword(requestParams.get("password"));
			restUser.setToken(null);
			userService.save(restUser);
			redir.addFlashAttribute("thanhcong", "Bạn đã mật khẩu, có thể đăng nhập bây giờ");
			model.setViewName("redirect:/login");
			model.setViewName("web/rest-password");
		}

		return model;
	}
}
