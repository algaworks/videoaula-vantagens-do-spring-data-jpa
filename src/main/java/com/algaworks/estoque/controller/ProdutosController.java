package com.algaworks.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.algaworks.estoque.model.Produto;
import com.algaworks.estoque.repository.ProdutosRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository repository;
	
	@GetMapping
	public Page<Produto> pesquisar(
	        @RequestParam(defaultValue = "0") int pagina, 
	        @RequestParam(defaultValue = "10") int porPagina,
	        @RequestParam(defaultValue = "nome") String ordenacao,
	        @RequestParam(defaultValue = "ASC") Sort.Direction direcao
    ) {
	  return repository.findAll(PageRequest.of(pagina, porPagina, new Sort(direcao, ordenacao)));
	}

}
