package com.integracao.gerenciador.modulo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "integracao")
public class Integracao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private Integer id;
	
	@NotNull
	@Column(name = "nome", length = 100)
	private String nome;
	
	@NotNull
	@Column(name = "porta", length = 5)
	private Integer porta;
	
	@OneToOne
	private Provedor provedor;	
	
	
	public Integracao() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getPorta() {
		return porta;
	}


	public void setPorta(Integer porta) {
		this.porta = porta;
	}


	public Provedor getProvedor() {
		return provedor;
	}


	public void setProvedor(Provedor provedor) {
		this.provedor = provedor;
	}
	
	

}
