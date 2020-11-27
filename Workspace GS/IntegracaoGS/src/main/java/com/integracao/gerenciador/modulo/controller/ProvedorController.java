package com.integracao.gerenciador.modulo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integracao.gerenciador.modulo.model.Provedor;
import com.integracao.gerenciador.modulo.repository.ProvedorRepository;

@RestController
@RequestMapping("/provedor")
public class ProvedorController {
	
	@Autowired
	private ProvedorRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Provedor>> get() {
	
		List<Provedor> todos = repository.findAll();	
		
		return ResponseEntity.status(HttpStatus.OK).body(todos);
	}
	

}
