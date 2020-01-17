package br.com.qintess.funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.funcionario.dao.DAO;
import br.com.qintess.funcionario.entidades.Alocacao;
import br.com.qintess.funcionario.entidades.Beneficio;
import br.com.qintess.funcionario.entidades.Cargo;
import br.com.qintess.funcionario.entidades.Funcionario;
import br.com.qintess.funcionario.entidades.Idioma;
import br.com.qintess.funcionario.entidades.Tecnologia;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
	
	@Autowired
	private DAO dao;
	

	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("funcionarios", dao.selecionaTodos(Funcionario.class));
		model.addAttribute("cargos", dao.selecionaTodos(Cargo.class));
		model.addAttribute("alocacoes", dao.selecionaTodos(Alocacao.class));
		model.addAttribute("funcionario", new Funcionario());
		
		model.addAttribute("beneficios", dao.selecionaTodos(Beneficio.class));
		model.addAttribute("beneficio", new Beneficio());
		
		model.addAttribute("idiomas", dao.selecionaTodos(Idioma.class));
		model.addAttribute("idioma", new Idioma());
		
		model.addAttribute("tecnologias", dao.selecionaTodos(Tecnologia.class));
		model.addAttribute("tecnologia", new Tecnologia());
	 	
		return "relatorio";
	}

}
