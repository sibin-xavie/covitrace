package com.jea.medico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ViewController {

	
	 @RequestMapping(value = "/")
	    public ModelAndView indexDirect() {
	        ModelAndView view = new ModelAndView("index");
	        return view;
	    }
}
