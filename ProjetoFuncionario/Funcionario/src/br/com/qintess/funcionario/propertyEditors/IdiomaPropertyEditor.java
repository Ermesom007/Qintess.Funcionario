package br.com.qintess.funcionario.propertyEditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.qintess.funcionario.dao.DAO;
import br.com.qintess.funcionario.entidades.Idioma;

@Component
public class IdiomaPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private DAO dao;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		int IdIdioma = Integer.parseInt(text);
		Idioma idioma = dao.selecionaPorId(Idioma.class, IdIdioma);
		setValue(idioma);
		
	}
}
