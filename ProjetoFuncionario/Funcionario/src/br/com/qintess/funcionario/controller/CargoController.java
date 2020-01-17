	package br.com.qintess.funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.funcionario.dao.DAO;
import br.com.qintess.funcionario.entidades.Cargo;

@Controller
@RequestMapping("/cargo")
public class CargoController{
	
	@Autowired
	private DAO dao;
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("cargos", dao.selecionaTodos(Cargo.class));
		model.addAttribute("cargo", new Cargo());
		
		return "cargo";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Cargo cargo) {
		System.out.println("cargo");
		System.out.println(cargo.getId());
		
		if (cargo.getId() == 0) {
			dao.salva(cargo);
		} else {
			dao.altera(cargo);
		}
		
		return "redirect:/cargo";
	}
	
	@RequestMapping("/altera/{id}")
	public String carregaAltera(@PathVariable int id, Model model) {
		model.addAttribute("cargos", dao.selecionaTodos(Cargo.class));
		model.addAttribute("cargo", dao.selecionaPorId(Cargo.class, id));
		
		return "cargo";
	}
	
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		Cargo cargo = dao.selecionaPorId(Cargo.class, id);
		dao.deleta(cargo);
		
		return "redirect:/alocacao";
		
	}

}

	
	


