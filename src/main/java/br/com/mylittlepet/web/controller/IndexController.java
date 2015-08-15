package br.com.mylittlepet.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		System.out.println("PASSOU AQUI");
		return "/WEB-INF/pages/index.jsp";
	}

	@RequestMapping("/home")
	public String home() {
		System.out.println("PASSOU AQUI");
		return "/WEB-INF/pages/index.jsp";
	}

}