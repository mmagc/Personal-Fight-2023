package br.com.personalfight.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.personalfight.model.entity.Treino;


public interface ProdutoRepository {

/*extends JpaRepository<Treino, Long> {

	// Query Method: PERMITE FAZER A CONSULTA DE ACORDO COM AS DEFINIÇÕES DO SPRING DATA JPA
	// ref: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	// na seção 5.1.3
	List<Treino> findByStatusProduto(String statusProduto);

	// JPQL: A CONSULTA É FEITA NO OBJETO REFERENTE À TABELA
	@Query("SELECT p FROM Treino p WHERE p.statusProduto = 'ATIVO'")
	List<Treino> listarProdutosAtivos();

	@Query("SELECT p FROM Treino p WHERE p.nome like %?1%")
	List<Treino> listarProdutosFiltro(@Param("nome") String nome);

	// O MESMO QUE O DE CIMA MAS UTILIZANDO Query Method
	List<Treino> findByNomeContaining(String nome);

	// nativeQuery: PERMITE FAZER O COMANDO TAL QUAL NO SQL
	@Query(value = "SELECT TOP 3 * FROM Treino p WHERE p.categoria = 'Algo' ORDER BY p.id DESC", nativeQuery = true)
	List<Treino> listar3ProdutosPelaCategoria();

	// nativeQuery: PERMITE FAZER O COMANDO TAL QUAL NO SQL
	// COM PASSAGEM DE PARÂMETRO COM CARACTERE "?"
	@Query(value = "SELECT TOP (?1) * FROM Treino p WHERE p.categoria = 'Algo' ORDER BY p.id DESC", nativeQuery = true)
	List<Treino> listarMaisProdutosPelaCategoria(int qtdeProdutos);

	// nativeQuery: PERMITE FAZER O COMANDO TAL QUAL NO SQL
	// COM PASSAGEM DE PARÂMETRO NOMEADO
	// passar o parâmetro depois dos ":" e declarar com a anotação @Param na lista
	// de argumentos do método
	@Query(value = "SELECT TOP (:qtdeProdutos) * FROM Treino p WHERE p.categoria = 'Algo' ORDER BY p.id DESC", nativeQuery = true)
	List<Treino> listarMaisProdutosPelaCategoria2(@Param("qtdeProdutos") int qtdeProdutos);
	
	// OU
	@Query(value = "SELECT * FROM Treino p WHERE p.categoria = :categoria ORDER BY p.id DESC", nativeQuery = true)
	List<Treino> listarProdutosPelaCategoria(@Param("categoria") String categoria);
*/
}
