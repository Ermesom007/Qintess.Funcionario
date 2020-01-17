package br.com.qintess.funcionario.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Tecnologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy = "tecnologia", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Funcionario> funcionarios;
	

	@OneToMany(mappedBy = "outroConhecimento", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Funcionario> funcionariosDeInteresse;
	
	
	@ManyToMany(mappedBy = "tecnologiasEnsinar", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Funcionario> professores;
	
	@ManyToMany(mappedBy = "tecnologiasAprender", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Funcionario> alunos;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public void setProfessores(List<Funcionario> professores) {
		this.professores = professores;
	}

	public List<Funcionario> getFuncionariosDeInteresse() {
		return funcionariosDeInteresse;
	}

	public void setFuncionariosDeInteresse(List<Funcionario> funcionariosDeInteresse) {
		this.funcionariosDeInteresse = funcionariosDeInteresse;
	}

	public List<Funcionario> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Funcionario> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
	
	
}
