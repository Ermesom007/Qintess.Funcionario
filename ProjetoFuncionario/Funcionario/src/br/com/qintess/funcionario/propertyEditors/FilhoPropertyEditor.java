package br.com.qintess.funcionario.propertyEditors;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.qintess.funcionario.dao.DAO;
import br.com.qintess.funcionario.entidades.Filho;
import br.com.qintess.funcionario.entidades.Funcionario;

@Component
public class FilhoPropertyEditor extends PropertyEditorSupport{
	
	@Autowired private DAO dao;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		
		List<Funcionario> funcionarios = dao.selecionaTodos(Funcionario.class);
		int maior = 0;
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getId()>maior) {
				maior = funcionario.getId();
			}
		}
		
		System.out.println(maior);
		int idadeFilho = Integer.parseInt(text);
		
		Filho filho = new Filho();
		filho.setIdadefilho(idadeFilho);		
		dao.salva(filho);
		
		System.out.println("filho id = "+filho.getId());
		Filho filhoSalvo = dao.selecionaPorId(Filho.class, filho.getId());
		setValue(filhoSalvo);
		
	}
}
