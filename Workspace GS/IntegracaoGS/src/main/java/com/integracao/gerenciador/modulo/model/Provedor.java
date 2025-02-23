package com.integracao.gerenciador.modulo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "provedor")
public class Provedor  implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private Integer id;
	
	@NotNull
	@Column(name = "nome", length = 50)
	private String nome;
	
	@NotNull
	@Column(name = "ip", length = 50)
	private String ip;
	
	
	public Provedor() {
		super();
	}
	
	
	public Provedor(String nome, String ip) {
		super();
		this.nome = nome;
		this.ip = ip;
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


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
}
