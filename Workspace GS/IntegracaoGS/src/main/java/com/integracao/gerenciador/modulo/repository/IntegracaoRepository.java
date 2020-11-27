package com.integracao.gerenciador.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integracao.gerenciador.modulo.model.Integracao;

public interface IntegracaoRepository extends JpaRepository<Integracao, Integer> {

}
