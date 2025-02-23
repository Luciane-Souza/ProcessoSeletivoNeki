package com.integracao.gerenciador.modulo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.integracao.gerenciador.modulo.model.Provedor;

public interface ProvedorRepository extends JpaRepository<Provedor, Integer> {
	
	@Override
	@Query(value = "select * from Provedor where id !=5", nativeQuery = true)
	List<Provedor> findAll();
}
