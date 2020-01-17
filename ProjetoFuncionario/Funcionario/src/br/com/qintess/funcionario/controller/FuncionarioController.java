package br.com.qintess.funcionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.funcionario.dao.DAO;
import br.com.qintess.funcionario.entidades.Alocacao;
import br.com.qintess.funcionario.entidades.Beneficio;
import br.com.qintess.funcionario.entidades.Cargo;
import br.com.qintess.funcionario.entidades.Filho;
import br.com.qintess.funcionario.entidades.Funcionario;
import br.com.qintess.funcionario.entidades.Idioma;
import br.com.qintess.funcionario.entidades.Tecnologia;
import br.com.qintess.funcionario.propertyEditors.BeneficioPropertyEditor;
import br.com.qintess.funcionario.propertyEditors.FilhoPropertyEditor;
import br.com.qintess.funcionario.propertyEditors.IdiomaPropertyEditor;
import br.com.qintess.funcionario.propertyEditors.TecnologiaPropertyEditor;



@Controller
@RequestMapping("/funcionario")
public class FuncionarioController{

	@Autowired
	private DAO dao;
	
	@Autowired
	private TecnologiaPropertyEditor tecnologiaPropertyEditor;
	
	@Autowired
	private IdiomaPropertyEditor idiomaPropertyEditor;
	
	@Autowired
	private FilhoPropertyEditor filhoPropertyEditor;
	
	@Autowired 
	private BeneficioPropertyEditor beneficioPropertyEditor;  

	
	
	@RequestMapping("")
	public String carrega(Model model) {
		model.addAttribute("funcionarios", dao.selecionaTodos(Funcionario.class));
		model.addAttribute("cargos", dao.selecionaTodos(Cargo.class));
		model.addAttribute("alocacoes", dao.selecionaTodos(Alocacao.class));
		model.addAttribute("tecnologias", dao.selecionaTodos(Tecnologia.class));
		model.addAttribute("idiomas", dao.selecionaTodos(Idioma.class));
		model.addAttribute("beneficios", dao.selecionaTodos(Beneficio.class));
		
		model.addAttribute("funcionario", new Funcionario());
		
	 	
		return "funcionario";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Funcionario funcionario) {
		
		
		funcionario.setAlocacao(dao.selecionaPorId(Alocacao.class, funcionario.getIddAlocacao()));
		funcionario.setCargo(dao.selecionaPorId(Cargo.class, funcionario.getIddCargo()));
		
		
		
	
		if (funcionario.getId() == 0) {

		dao.salva(funcionario);
		} else {
			dao.altera(funcionario);
		}
		
		return "redirect:/funcionario";
	}
	
	@RequestMapping("/altera/{id}")
	public String carregaAltera(@PathVariable int id, Model model) {
		model.addAttribute("funcionarios", dao.selecionaTodos(Funcionario.class));
		model.addAttribute("funcionario", dao.selecionaPorId(Funcionario.class, id));
		
		return "funcionario";
	}
	
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable int id) {
		Funcionario funcionario = dao.selecionaPorId(Funcionario.class, id);
		dao.deleta(funcionario);
		
		return "redirect:/funcionario";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Tecnologia.class, tecnologiaPropertyEditor);
		webDataBinder.registerCustomEditor(Idioma.class, idiomaPropertyEditor);
		webDataBinder.registerCustomEditor(Filho.class, filhoPropertyEditor);
		webDataBinder.registerCustomEditor(Beneficio.class, beneficioPropertyEditor);
	
	}
}
