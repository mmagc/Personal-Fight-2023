package br.com.personalfight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.personalfight.model.entity.Aluno;
import br.com.personalfight.model.entity.Instrutor;
import br.com.personalfight.service.AlunoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/aluno")
public class AlunoControlleer {

	
	private AlunoService alunoService;

	public AlunoControlleer(AlunoService alunoService) {
		super();
		this.alunoService = alunoService;
	}
	
	String serverMessage = "";
	
	@GetMapping("alunos")
	public String alunos(ModelMap map, HttpSession session) {
		map.addAttribute("aluno", new Aluno());
		
		Instrutor instrutor = (Instrutor) session.getAttribute("instrutor");

		map.addAttribute("listAlunos", alunoService.findByInstrutor(instrutor));
		map.addAttribute("serverMessage", serverMessage);
		serverMessage=null;
		return "/pages/alunos";
	}

	
	@PostMapping("/gravar")
	public String gravar(ModelMap model, HttpSession session,
			@ModelAttribute("aluno") Aluno aluno) {
		
		Aluno _aluno = alunoService.findByEmail(aluno.getEMAIL());
		
		Instrutor instrutor = (Instrutor) session.getAttribute("instrutor");
		
		model.addAttribute("serverMessage", serverMessage);
		if (_aluno == null) {
			aluno.setInstrutor(instrutor);
			alunoService.saveNew(aluno);
			model.addAttribute("aluno", new Aluno());
			serverMessage = "Usuário cadastrado com sucesso!!!";
			
		} else if (_aluno != null) {
			
			model.addAttribute("aluno", new Aluno());
			serverMessage = "Usuário já foi cadastrado no sitema!";	
			
		}

		return "redirect:/aluno/alunos";
	}
	
	@PostMapping("/gravartreino/{id}")
	public String gravartreino(ModelMap model, @PathVariable("id") long id) {
		
		Aluno aluno = alunoService.findById(id);
		
		model.addAttribute("serverMessage", serverMessage);
	

		return "redirect:/aluno/alunos";
	}
	
	@GetMapping("/ver/{id}")
   public String verUsuario(@PathVariable("id") long id, ModelMap model) {
		
		Aluno aluno = alunoService.findById(id);
		
		model.addAttribute("aluno", aluno);
		return "pages/avaliação";
	}
}

