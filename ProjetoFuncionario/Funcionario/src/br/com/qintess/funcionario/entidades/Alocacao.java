package br.com.qintess.funcionario.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;


@Entity
public class Alocacao {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column
private String cliente;

@OneToMany(mappedBy = "alocacao", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<Funcionario> funcionarios;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCliente() {
	return cliente;
}

public void setCliente(String cliente) {
	this.cliente = cliente;
}

public List<Funcionario> getFuncionarios() {
	return funcionarios;
}

public void setFuncionarios(List<Funcionario> funcionarios) {
	this.funcionarios = funcionarios;
}



}
