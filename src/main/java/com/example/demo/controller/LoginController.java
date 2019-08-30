package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Login;

@Controller
@RequestMapping("/control")
@SessionAttributes("login")
public class LoginController {

	// This Method is called from the http://localhost:8082/control.
	// After this method gets executed it is forwarded to the RestController where
	// rest calls are made.
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logincontroller() {
		ModelAndView mv = new ModelAndView("login.jsp");
		Login login = new Login();
		mv.addObject(login);
		return mv;
	}

	// This Method is called from the login.jsp page and to check whether
	// credentials are of administrator or employee.
	// After this method gets executed it is forwarded to the RestController where
	// rest calls are made.
	@RequestMapping(method = RequestMethod.POST)
	public String logincontrol(Login login, HttpServletRequest request, HttpServletResponse response) {
		login.setRole("admin");
		String url = "http://localhost:8082/valid/insert";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, login, String.class);
		HttpSession session = request.getSession();
		session.setAttribute("username", login.getName());
		if (status.equals("admin"))
			return "redirect:AdminOperations.jsp";
		else if (status.equals("user"))
			return "/checkuser";
		else
			return "redirect:WrongCredentials.jsp";
	}
}
