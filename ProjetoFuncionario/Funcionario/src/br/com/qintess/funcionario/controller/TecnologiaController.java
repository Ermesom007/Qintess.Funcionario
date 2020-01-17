package br.com.qintess.funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.funcionario.dao.DAO;

import br.com.qintess.funcionario.entidades.Tecnologia;

@Controller
@RequestMapping("/tecnologia")
public class TecnologiaController {


	@Autowired
	private DAO dao;
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("tecnologias", dao.selecionaTodos(Tecnologia.class));
		model.addAttribute("tecnologia", new Tecnologia());
		
		return "tecnologia";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Tecnologia tecnologia) {
		
		if (tecnologia.getId() == 0) {
			dao.salva(tecnologia);
		} else {
			dao.altera(tecnologia);
		}
		
		return "redirect:/tecnologia";
	}
	
	@RequestMapping("/altera/{id}")
	public String carregaAltera(@PathVariable int id, Model model) {
		model.addAttribute("tecnologias", dao.selecionaTodos(Tecnologia.class));
		model.addAttribute("tecnologia", dao.selecionaPorId(Tecnologia.class, id));
		
		return "cargo";
	}
	
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		Tecnologia tecnologia = dao.selecionaPorId(Tecnologia.class, id);
		dao.deleta(tecnologia);
		
		return "redirect:/tecnologia";
		
	}
}
