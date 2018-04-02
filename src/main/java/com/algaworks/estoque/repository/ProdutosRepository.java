package com.algaworks.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.estoque.model.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
	
	Produto findProdutoByNome(String nome);
	
	@Query("select p from Produto p") // :)
	List<Produto> estatisticasProduto();

}
