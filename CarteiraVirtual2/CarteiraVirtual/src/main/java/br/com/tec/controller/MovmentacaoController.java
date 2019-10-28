package br.com.tec.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tec.DAO.CategoriaDAO;
import br.com.tec.DAO.MovimentacaoDAO;
import modal.CategoriaModal;
import modal.MovimentaçãoModal;

@ManagedBean
@SessionScoped
public class MovmentacaoController implements Serializable {

	private static final long serialVersionUID = 1L;

	ArrayList<MovimentaçãoModal> movimentacao = new ArrayList<MovimentaçãoModal>();

	float dinheiroTotal;
	int idCategoriaAUx;
	
	MovimentaçãoModal mov = new MovimentaçãoModal();
	
	public void CadastroMovimentacao() {
		
		mov.setCategoria(new CategoriaDAO().BuscarPorId(idCategoriaAUx));
		
		new MovimentacaoDAO().salvarMovimentacao(mov);
		
		mov = new MovimentaçãoModal();
		
	}

	public ArrayList<MovimentaçãoModal> ListMovimentacoes() {
		
		ArrayList<MovimentaçãoModal> mov = new ArrayList<>();
		
		try {

			mov = new MovimentacaoDAO().buscarTodasMovimentacoes();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return mov;
	}
	

	public ArrayList<MovimentaçãoModal> List10Movimentacoes() {
		
		ArrayList<MovimentaçãoModal> mov = new ArrayList<>();
		
		try {

			mov = new MovimentacaoDAO().buscar10Movimentacoes();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return mov;
	} 

	
	
	public ArrayList<CategoriaModal> ListCategorias() {
		
		ArrayList<CategoriaModal> cat = new ArrayList<>();
		
		try {

			cat = new MovimentacaoDAO().buscarTodasCategorias();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return cat;
	} 


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ArrayList<MovimentaçãoModal> getMovimentacao() {
		return movimentacao;
	}

	public float getDinheiroTotal() {
		return dinheiroTotal;
	}

	public MovimentaçãoModal getMov() {
		return mov;
	}

	public void setMovimentacao(ArrayList<MovimentaçãoModal> movimentacao) {
		this.movimentacao = movimentacao;
	}

	public void setDinheiroTotal(float dinheiroTotal) {
		this.dinheiroTotal = dinheiroTotal;
	}

	public void setMov(MovimentaçãoModal mov) {
		this.mov = mov;
	}

	public int getIdCategoriaAUx() {
		return idCategoriaAUx;
	}

	public void setIdCategoriaAUx(int idCategoriaAUx) {
		this.idCategoriaAUx = idCategoriaAUx;
	}

}
