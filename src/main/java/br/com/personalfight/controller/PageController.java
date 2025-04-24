package br.com.personalfight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.personalfight.model.entity.Aluno;
import br.com.personalfight.model.entity.Instrutor;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class PageController {
	
	String serverMessage = "";

	@GetMapping("/")
	public String rootRedirect() {
		return "redirect:/login";
	}


	@GetMapping("index")
	public String index(HttpSession session) {
		session.setAttribute("instrutor", session.getAttribute("instrutor"));
		return "/pages/dashboard";
	}
	
	

	
	@GetMapping("avaliacao")
	public String avaliacao(ModelMap map) {
		map.addAttribute("aluno", new Aluno());
		return "/pages/avaliação";
	}
	
	@GetMapping("login")
	public String login(ModelMap map) {
		map.addAttribute("instrutor", new Instrutor());
		return "/pages/login";
	}
	
	
	@GetMapping("perfil")
	public String perfil() {
		return "/pages/perfil";
	}
	
}
