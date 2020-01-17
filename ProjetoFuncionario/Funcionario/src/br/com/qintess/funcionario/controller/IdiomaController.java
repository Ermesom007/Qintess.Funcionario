package br.com.qintess.funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.funcionario.dao.DAO;

import br.com.qintess.funcionario.entidades.Idioma;



@Controller
@RequestMapping("/idioma")
public class IdiomaController{
	
	@Autowired
	private DAO dao;
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("idiomas", dao.selecionaTodos(Idioma.class));
		model.addAttribute("idioma", new Idioma());
		
		return "idioma";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Idioma idioma) {
		
		if (idioma.getId() == 0) {
			dao.salva(idioma);
		} else {
			dao.altera(idioma);
		}
		
		return "redirect:/idioma";
	}
	
	@RequestMapping("/altera/{id}")
	public String carregaAltera(@PathVariable int id, Model model) {
		model.addAttribute("idiomas", dao.selecionaTodos(Idioma.class));
		model.addAttribute("idioma", dao.selecionaPorId(Idioma.class, id));
		
		return "idioma";
	}
	
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		Idioma idioma = dao.selecionaPorId(Idioma.class, id);
		dao.deleta(idioma);
		
		return "redirect:/idioma";
		
	}

}
