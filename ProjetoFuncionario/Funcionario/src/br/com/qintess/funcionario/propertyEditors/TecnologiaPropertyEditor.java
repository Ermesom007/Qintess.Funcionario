package br.com.qintess.funcionario.propertyEditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.qintess.funcionario.dao.DAO;
import br.com.qintess.funcionario.entidades.Tecnologia;


@Component
public class TecnologiaPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private DAO dao;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		int IdTecnologia = Integer.parseInt(text);
		Tecnologia tecnologia = dao.selecionaPorId(Tecnologia.class, IdTecnologia);
		setValue(tecnologia);
	}
}
