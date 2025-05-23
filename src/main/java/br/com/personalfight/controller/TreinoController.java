package br.com.personalfight.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.personalfight.model.entity.Aluno;
import br.com.personalfight.model.entity.Treino;
import br.com.personalfight.service.AlunoService;
import br.com.personalfight.service.CategoriaService;
import br.com.personalfight.service.InstrutorService;
import br.com.personalfight.service.TreinoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

	// DEFINE O ENDEREÇO NA URL PARA ACESSAR OS "END_POINTS" DA CLASSE
@Controller
@RequestMapping("/treino")
public class TreinoController {

	private TreinoService treinoService;
	private CategoriaService categoriaService;
	private InstrutorService instrutorService;
	private AlunoService alunoService;
		
	
	
	public TreinoController(TreinoService treinoService, CategoriaService categoriaService,
			InstrutorService instrutorService, AlunoService alunoService) {
		super();
		this.treinoService = treinoService;
		this.categoriaService = categoriaService;
		this.instrutorService = instrutorService;
		this.alunoService = alunoService;
	}

	private String serverMessage = null;
	
	@GetMapping("/treinos")
	public String novoTreino(ModelMap model) {

		model.addAttribute("treino", new Treino());
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("instrutors", instrutorService.findAll());
		model.addAttribute("serverMessage", serverMessage);
		serverMessage = null;
		return "/pages/treinos";
	}
	
	@PostMapping("/salvar")
	public String salvar(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@ModelAttribute("treino") Treino treino) {

		//byte[] _arquivo = Base64.getDecoder().decode(arquivo);
		
		Aluno aluno = alunoService.findByEmail(treino.getAluno().getEMAIL());
		
		treinoService.saveNew(file, treino, aluno);
		
		serverMessage = "Dados gravados com sucesso!!!";

		return "redirect:/index";
	}
	
	@GetMapping("/showPdf/{id}")
	@ResponseBody
	public void showImage(
			@PathVariable("id") long id, HttpServletResponse response, Treino treino)
			throws ServletException, IOException {

		treino = treinoService.findById(id);

		response.setContentType("application/pdf");
		if (treino.getARQUIVO() != null) {
			response.getOutputStream().write(treino.getARQUIVO());
		} else {
			response.getOutputStream().write(null);
		}

		response.getOutputStream().close();
	}
	
/*
	private String serverMessage = null;
	private String foto = "";
	// CASO O PRODUTO NÃO TENHA UMA IMAGEM CADASTRADA NO BANCO DE DADOS
	private String noImage = "/images/no-pizza-image.png";
	
	// LISTA TODOS OS PRODUTOS PARA O ADMIN
	// @GetMapping("/todos" --> END_POINT)
	// END_POINT -> EXECUTA UMA AÇÃO QUANDO É INFORMADO NA URL
	/*
	@GetMapping("/todos")
	public String verTodosProdutos(ModelMap model) {

		List<Treino> produtos = produtoService.findAll();

		// DEFINE UM ATRIBUTO NA PÁGINA QUE IRÁ REPRESENTAR OS DADOS VINDOS DA APLICAÇÃO 
		model.addAttribute("produtos", produtos);
		serverMessage = null;

		// INDICA A PÁGINA QUE SERÁ CARREGADA NA EXECUÇÃO DO MÉTODO
		return "produtos";
	}
	
	@GetMapping("/todos-filtro")
	public String verProdutosPorNome(ModelMap model,
			@RequestParam(value = "nome", required = false) String nome) {
		
		List<Treino> produtos = null;
		
		if (nome == null) {
			produtos = produtoService.findAll();
			model.addAttribute("produtos", produtos);
		} else {
			produtos = produtoService.findAllByNome(nome);
			model.addAttribute("produtos", produtos);
		}

		serverMessage = null;

		// INDICA A PÁGINA QUE SERÁ CARREGADA NA EXECUÇÃO DO MÉTODO
		return "produtos-filtro";
	}
	
	// LISTA TODOS OS PRODUTOS QUE SERÃO EXIBIDOS NA PÁGINA INICIAL
	@GetMapping("/lista")
	public String verListaProdutos(ModelMap model) {

		List<Treino> produtos = produtoService.findAll();
		model.addAttribute("produtos", produtos);
		model.addAttribute("noImage", noImage);
		serverMessage = null;

		return "produtos-lista";
	}
	
	// NAVEGA PARA PÁGINA PARA CADASTRO DE UM NOVO PRODUTO

	
	// GRAVA AS INFORMAÇÕES DO PRODUTO
	// MultipartFile file, NECESSÁRIO PARA GRAVAR A IMAGEM DO PRODUTO
	@PostMapping("/salvar")
	public String salvar(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@ModelAttribute("produto") Treino produto) {

//		if (file.getSize() > 1048576) {
//			serverMessage = "Imagem muito grande!!!";
//			return "redirect:/api/produto/novo";
//		}
		
		Treino p = produtoService.saveNew(file, produto);
		
		serverMessage = "Treino cadastrado com sucesso!!!";

		// REDIRECIONA PARA O END_POINT INDICADO
		return "redirect:/api/produto/ver/" + p.getId();
	}
	
	// GRAVA AS ALTERAÇÕES DO PRODUTO
	@PostMapping("/editar/{id}")
	public String editar(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@PathVariable("id") long id, @ModelAttribute("produto") Treino produto) {

		byte[] _foto = Base64.getDecoder().decode(foto);
		
		produtoService.update(file, produto, _foto);
		
		serverMessage = "Dados alterados com sucesso!!!";
		foto = "";
		return "redirect:/api/produto/ver/" + id;
	}
	
	// CARREGA AS INFORMAÇÕES DO PRODUTO
	@GetMapping("/ver/{id}")
	public String verProduto(@PathVariable("id") long id, ModelMap model) {

		Treino produto = produtoService.findById(id);
		
		if (produto.getFoto() != null) {
			if (produto.getFoto().length > 0) {
				foto = Base64.getEncoder().encodeToString(produto.getFoto());
			}
		}

		model.addAttribute("produto", produto);
		model.addAttribute("noImage", noImage);
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("serverMessage", serverMessage);

		return "produto-editar";
	}
	
	//EXIBE A IMAGEM DO PRODUTO
	@GetMapping("/showImage/{id}")
	@ResponseBody
	public void showImage(
			@PathVariable("id") long id, HttpServletResponse response, Treino produto)
			throws ServletException, IOException {

		produto = produtoService.findById(id);

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		if (produto.getFoto() != null) {
			response.getOutputStream().write(produto.getFoto());
		} else {
			response.getOutputStream().write(null);
		}

		response.getOutputStream().close();
	}

	*/
	
}
