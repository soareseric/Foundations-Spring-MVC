package br.com.ericsoares.springmvc.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

	// <servidor>/hello/message
	
	@RequestMapping("/message")
	public String message() {
		return "hello";
	}
	
	@RequestMapping("/mensagemDoServidor")
	public String mensagemDoServidor(Model model) {
		model.addAttribute("mensagem", "Olá, Eric Soares");
		return "mensagemDoServidor";
	}
	
	@RequestMapping("/mensagemDoServidorV2")
	public ModelAndView mensagemDoServidorV2() {
		return new ModelAndView("mensagemDoServidor", "mensagem", new Date().toString());
	}
}
