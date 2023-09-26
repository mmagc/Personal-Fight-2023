package br.com.personalfight.service;

public class ProdutoService {
	/*
	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Treino> findAll() {
		List<Treino> produtos = produtoRepository.findAll();
		return produtos;
	}
	
	public List<Treino> findAllByNome(String nome) {
		List<Treino> produtos = produtoRepository.findByNomeContaining(nome);
		return produtos;
	}

	public Treino findById(long id) {
		return produtoRepository.findById(id).get();
	}
	
	@Transactional
	public Treino saveNew(Treino produto) {

		produto.setStatusProduto("ATIVO");
		
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Treino update(Treino produto) {

		produto.setStatusProduto("ATIVO");
		
		return produtoRepository.save(produto);
	}
	

	@Transactional
	public Treino saveNew(MultipartFile file, Treino produto) {

		if (file != null && file.getSize() > 0) {
			try {
				produto.setFoto(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			produto.setFoto(null);
		}

		produto.setStatusProduto("ATIVO");
		
		return produtoRepository.save(produto);
	}

	@Transactional
	public void update(MultipartFile file, Treino produto, byte[] foto) {
		
		if (file.getSize() == 0 && foto.length == 0) {
			produto.setFoto(null);
		} 
		
		if (file.getSize() == 0 && foto.length > 0) {
			produto.setFoto(foto);
		} 

		if (file != null && file.getSize() > 0 ) {
			try {
				produto.setFoto(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		produto.setStatusProduto("ATIVO");
		produtoRepository.save(produto);
	} 

*/
}
