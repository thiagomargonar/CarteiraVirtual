package br.com.tec.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tec.DAO.CategoriaDAO;
import br.com.tec.DAO.MovimentacaoDAO;
import br.com.tec.modal.CategoriaModal;
import br.com.tec.modal.Movimenta��oModal;

@ManagedBean
@SessionScoped
public class MovmentacaoController implements Serializable {

	private static final long serialVersionUID = 1L;

	ArrayList<Movimenta��oModal> movimentacao = new ArrayList<Movimenta��oModal>();

	float dinheiroTotal;
	int idCategoriaAUx;
	
	Movimenta��oModal mov = new Movimenta��oModal();
	
	public void CadastroMovimentacao() {
		
		mov.setCategoria(new CategoriaDAO().BuscarPorId(idCategoriaAUx));
		
		new MovimentacaoDAO().salvarMovimentacao(mov);
		
		mov = new Movimenta��oModal();
		
	}

	public ArrayList<Movimenta��oModal> ListMovimentacoes() {
		
		ArrayList<Movimenta��oModal> mov = new ArrayList<>();
		
		try {

			mov = new MovimentacaoDAO().buscarTodasMovimentacoes();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return mov;
	}
	

	public ArrayList<Movimenta��oModal> List10Movimentacoes() {
		
		ArrayList<Movimenta��oModal> mov = new ArrayList<>();
		
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


	public ArrayList<Movimenta��oModal> getMovimentacao() {
		return movimentacao;
	}

	public float getDinheiroTotal() {
		return dinheiroTotal;
	}

	public Movimenta��oModal getMov() {
		return mov;
	}

	public void setMovimentacao(ArrayList<Movimenta��oModal> movimentacao) {
		this.movimentacao = movimentacao;
	}

	public void setDinheiroTotal(float dinheiroTotal) {
		this.dinheiroTotal = dinheiroTotal;
	}

	public void setMov(Movimenta��oModal mov) {
		this.mov = mov;
	}

	public int getIdCategoriaAUx() {
		return idCategoriaAUx;
	}

	public void setIdCategoriaAUx(int idCategoriaAUx) {
		this.idCategoriaAUx = idCategoriaAUx;
	}

}
