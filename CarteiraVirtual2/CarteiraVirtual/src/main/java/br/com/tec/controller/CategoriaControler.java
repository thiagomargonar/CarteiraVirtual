package br.com.tec.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.tec.DAO.CategoriaDAO;
import modal.CategoriaModal;


@ManagedBean
@ViewScoped
public class CategoriaControler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	String tipo;
	
	public void CadastroCategoria(){
		
		CategoriaDAO dao = new CategoriaDAO();
		dao.salvarCategoria(tipo);
		
	}
	
	
	
	
	
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
