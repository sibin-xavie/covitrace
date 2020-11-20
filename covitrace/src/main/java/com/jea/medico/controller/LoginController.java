package com.jea.medico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {

	
	@RequestMapping(value={"/web/login"}, method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping(value={"/web/registration"}, method=RequestMethod.GET)
	public ModelAndView registration() {
		return new ModelAndView("registration");
	}
}
