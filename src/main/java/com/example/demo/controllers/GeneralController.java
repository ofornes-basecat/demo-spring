package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeneralController {

    @GetMapping("/")
    public String main(Model model, HttpServletRequest request) {
    	List<NameValue> headerValues;
    	List<Cookie> cookies;
    	Enumeration<String> names;
    	String n, v;
    	
    	headerValues = Collections.synchronizedList(new ArrayList<>());
    	names = request.getHeaderNames();
    	while(names.hasMoreElements()) {
    		n = names.nextElement();
    		v = request.getHeader(n);
    		headerValues.add(new NameValue(n, v));
    	}
    	
    	cookies = Collections.synchronizedList(new ArrayList<>());
    	if(!ObjectUtils.isEmpty(request.getCookies())) {
    		cookies.addAll(Arrays.asList(request.getCookies()));
    	}
    	model.addAttribute("headers", headerValues);
    	model.addAttribute("cookies", cookies);
    	model.addAttribute("requestUrl", request.getRequestURL().toString());
    	
        return "index";
    }

    @GetMapping("/modals/modal1")
    public String modal1() {
        return "modal1";
    }

    @GetMapping("/modals/modal2")
    public String modal2(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "modal2";
    }

    @GetMapping("/modals/no-implementat")
    public String modalNoImplementat(@RequestParam("element") String name, Model model) {
        model.addAttribute("element", name);
        return "no_implementat";
    }
}
