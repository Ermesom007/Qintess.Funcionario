package br.com.qintess.funcionario.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Idioma {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column
private String idioma;

@ManyToMany(mappedBy = "idiomas",fetch = FetchType.EAGER)
private List<Funcionario> funcionarios;


@ManyToMany(mappedBy = "idiomasEnsinar",fetch = FetchType.EAGER)
@Fetch(FetchMode.SUBSELECT)
private List<Funcionario> professores;

@ManyToMany(mappedBy = "idiomasAprender",fetch = FetchType.EAGER)
@Fetch(FetchMode.SUBSELECT)
private List<Funcionario> alunos;


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getIdioma() {
	return idioma;
}

public void setIdioma(String idioma) {
	this.idioma = idioma;
}

public List<Funcionario> getFuncionarios() {
	return funcionarios;
}

public void setFuncionarios(List<Funcionario> funcionarios) {
	this.funcionarios = funcionarios;
}

public List<Funcionario> getProfessores() {
	return professores;
}

public void setProfessor(List<Funcionario> professores) {
	this.professores = professores;
}

public List<Funcionario> getAlunos() {
	return alunos;
}

public void setAlunos(List<Funcionario> alunos) {
	this.alunos = alunos;
}

public void setProfessores(List<Funcionario> professores) {
	this.professores = professores;
} 





}
