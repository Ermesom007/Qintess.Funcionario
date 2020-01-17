package br.com.qintess.funcionario.propertyEditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.qintess.funcionario.dao.DAO;
import br.com.qintess.funcionario.entidades.Beneficio;


@Component
public class BeneficioPropertyEditor extends PropertyEditorSupport {
	
	@Autowired private DAO dao;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		int IdBeneficio = Integer.parseInt(text);
		Beneficio beneficio = dao.selecionaPorId(Beneficio.class, IdBeneficio);
		setValue(beneficio);
	}
}
