package com.integracao.gerenciador.modulo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integracao.gerenciador.modulo.model.Integracao;
import com.integracao.gerenciador.modulo.model.Provedor;
import com.integracao.gerenciador.modulo.repository.IntegracaoRepository;
import com.integracao.gerenciador.modulo.repository.ProvedorRepository;

@RestController
@RequestMapping("/integracao")
public class IntegracaoController {
	
	@Autowired
	private IntegracaoRepository repository;
	
	@Autowired
	private ProvedorRepository provedorRepository;
	
	@GetMapping
	public ResponseEntity<List<Integracao>> get() {
	
		List<Integracao> todos = repository.findAll();	
		
		return ResponseEntity.status(HttpStatus.OK).body(todos);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Integracao> put(@PathVariable Integer id, @RequestBody Integracao novaIntegracao){
		
		Integracao existente = repository.findById(id).get();
		existente.setPorta(novaIntegracao.getPorta());
		Provedor provedor = provedorRepository.findById(novaIntegracao.getProvedor().getId()).get();
		existente.setProvedor(provedor);
		
		repository.save(existente);
		
		return ResponseEntity.status(HttpStatus.OK).body(existente);
	}

}
