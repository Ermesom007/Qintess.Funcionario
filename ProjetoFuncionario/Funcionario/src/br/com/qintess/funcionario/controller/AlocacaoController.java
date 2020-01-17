package br.com.qintess.funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.funcionario.dao.DAO;
import br.com.qintess.funcionario.entidades.Alocacao;

@Controller
@RequestMapping("/alocacao")
public class AlocacaoController {
	
	@Autowired
	private DAO dao;
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("alocacoes",dao.selecionaTodos(Alocacao.class));
		model.addAttribute("alocacao",new Alocacao());
		
		return "alocacao";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Alocacao alocacao) {
		
		if (alocacao.getId() == 0) {
			dao.salva(alocacao);
		} else {
			dao.altera(alocacao);
		}
		
		return "redirect:/alocacao";
	}
	
	@RequestMapping("/altera/{id}")
	public String carregaAltera(@PathVariable int id, Model model) {
		model.addAttribute("alocacoes", dao.selecionaTodos(Alocacao.class));
		model.addAttribute("alocacao", dao.selecionaPorId(Alocacao.class, id));
		
		return "alocacao";
	}
	
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		Alocacao alocacao = dao.selecionaPorId(Alocacao.class, id);
		dao.deleta(alocacao);
		
		return "redirect:/alocacao";
		
	}

}
