package br.com.qintess.funcionario.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity
public class Funcionario {


	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	

	@Column
	private String email;
	
	@Column
	private String endereco;
	
	@Column private String cidade;
	
	@Column private String estado;
	
	
	@ManyToOne
	@JoinColumn(name="idAlocacao")
	private Alocacao alocacao;
	
	@ManyToOne
	@JoinColumn(name="idCargo")
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name="idTecnologia")
	private Tecnologia tecnologia;
	

	@ManyToOne
	@JoinColumn(name="idSegundaTecnologia")
	private Tecnologia outroConhecimento;
	
	@ManyToMany
	@JoinTable(name="aprendeTecnologia")
	private List<Tecnologia> tecnologiasAprender;
	

	@ManyToMany()
	@JoinTable(name = "ensinaTecnologia")
	private List<Tecnologia> tecnologiasEnsinar;
	
	
	@OneToMany(mappedBy = "funcionario")
	private List<Filho> filhos;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "fala")
	private List<Idioma> idiomas;
	

	@ManyToMany()
	@JoinTable(name = "ensina")
	private List<Idioma> idiomasEnsinar;
	

	@ManyToMany()
	@JoinTable(name = "aprende")
	private List<Idioma> idiomasAprender;
	
	
	@ManyToMany
	@JoinTable(name="beneficiosDesejados")
	private List<Beneficio> beneficios;
	
	
	
	@Column
	private int iddAlocacao;
	
	@Column
	private int iddCargo;


	
	@Column
	private String anoExperiencia;

	@Column
	private String formacaoAcademica; 
	
	@Column private String certificacoes;
	
	
	
	
	
	
	
	
	

	

	public List<Tecnologia> getTecnologiasAprender() {
		return tecnologiasAprender;
	}

	public void setTecnologiasAprender(List<Tecnologia> tecnologiasAprender) {
		this.tecnologiasAprender = tecnologiasAprender;
	}

	public List<Idioma> getIdiomasAprender() {
		return idiomasAprender;
	}

	public void setIdiomasAprender(List<Idioma> idiomasAprender) {
		this.idiomasAprender = idiomasAprender;
	}

	public List<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficio(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public Tecnologia getOutroConhecimento() {
		return outroConhecimento;
	}

	public void setOutroConhecimento(Tecnologia outroConhecimento) {
		this.outroConhecimento = outroConhecimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Tecnologia> getTecnologiasEnsinar() {
		return tecnologiasEnsinar;
	}

	public void setTecnologiasEnsinar(List<Tecnologia> tecnologiasEnsinar) {
		this.tecnologiasEnsinar = tecnologiasEnsinar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFilhos(List<Filho> filhos) {
		this.filhos = filhos;
	}


	
	public List<Filho> getFilhos() {
		return filhos;
	}
	
	
	

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public String getAnoExperiencia() {
		return anoExperiencia;
	}

	public void setAnoExperiencia(String anoExperiencia) {
		this.anoExperiencia = anoExperiencia;
	}
	
	
		
	
	


	public List<Idioma> getIdiomasEnsinar() {
		return idiomasEnsinar;
	}

	public void setIdiomasEnsinar(List<Idioma> idiomasEnsinar) {
		this.idiomasEnsinar = idiomasEnsinar;
	}



	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public String getCertificacoes() {
		return certificacoes;
	}

	public void setCertificacoes(String certificacoes) {
		this.certificacoes = certificacoes;
	}


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
	
	
	public Alocacao getAlocacao() {
		return alocacao;
	}
	
	public void setAlocacao(Alocacao alocacao) {
		this.alocacao = alocacao;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	

	
	
	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public int getIddCargo() {
		return iddCargo;
	}
	
	public void setIddCargo(int iddCargo) {
		this.iddCargo = iddCargo;
	}


	public int getIddAlocacao() {
		return iddAlocacao;
	}

	public void setIddAlocacao(int iddAlocacao) {
		this.iddAlocacao = iddAlocacao;
	}



}
