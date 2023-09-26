package br.com.personalfight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.personalfight.model.entity.Instrutor;
import br.com.personalfight.service.InstrutorService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/instrutor")
public class InstrutorController {

	
	private InstrutorService instrutorService;

	public InstrutorController(InstrutorService instrutorService) {
		super();
		this.instrutorService = instrutorService;
	}
	
	String serverMessage = "";
	
	
	@GetMapping("/cadastro")
	public String cadastro(ModelMap map) {
		map.addAttribute("instrutor", new Instrutor());
		
		map.addAttribute("serverMessage", serverMessage);
		serverMessage=null;
		return "/pages/cadastro";
	}

	@PostMapping("/gravar")
	public String gravar(ModelMap model,
			@ModelAttribute("instrutor") Instrutor instrutor) {
		
		Instrutor _instrutor = instrutorService.findByEmail(instrutor.getEMAIL());
		
		model.addAttribute("serverMessage", serverMessage);
		if (_instrutor == null) {
			
			instrutorService.saveNew(instrutor);
			model.addAttribute("instrutor", new Instrutor());
			serverMessage = "Usuário cadastrado com sucesso!!!";
			
		} else if (_instrutor != null) {
			
			model.addAttribute("instrutor", new Instrutor());
			serverMessage = "Usuário já foi cadastrado no sitema!";	
			
		}

		return "redirect:/login";
	}
	
	@PostMapping("/acessar")
	public String acessar(ModelMap model,
			@RequestParam("EMAIL") String email, 
			@RequestParam("SENHA") String senha, HttpSession session) {
		
		Instrutor instrutorLogado = instrutorService.acessar(email, senha);

		if (instrutorLogado != null) {
			
			session.setAttribute("instrutor", instrutorLogado);
			model.addAttribute("instrutorLogado", instrutorLogado);
			return "redirect:/index";
	
		}
		
		serverMessage = "Dados Incorretos!";
		model.addAttribute("serverMessage", serverMessage);
		
		return "redirect:/login";
	}

}
