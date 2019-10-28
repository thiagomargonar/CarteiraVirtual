package br.com.tec.DAO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.tec.utils.EntityManagerUtils;
import modal.CategoriaModal;
import modal.Movimenta��oModal;

public class MovimentacaoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityTX = new EntityManagerUtils().getEntityManager();
	
	
	public void salvarMovimentacao(Movimenta��oModal movimentacao) {

		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		
		movimentacao.setDate(data);

		try {
			entityTX.getTransaction().begin();
			entityTX.persist(movimentacao);
			entityTX.getTransaction().commit();
		} catch (Exception e) {

		}finally {
			entityTX.close();
			entityTX.getEntityManagerFactory().close();
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage("Salvo com sucesso", null));
		}
		
		
	}
	
	public ArrayList<Movimenta��oModal> buscarTodasMovimentacoes() {
		ArrayList<Movimenta��oModal> resultList = new ArrayList<>();

		try {
			resultList = (ArrayList<Movimenta��oModal>) entityTX.createQuery("from Movimenta��oModal")
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.close();
			entityTX.getEntityManagerFactory().close();
		}

		return resultList;
	}
	
	public ArrayList<Movimenta��oModal> buscar10Movimentacoes() {
		ArrayList<Movimenta��oModal> resultList = new ArrayList<>();

		try {
			resultList = (ArrayList<Movimenta��oModal>) entityTX.createQuery("from Movimenta��oModal")
					.setMaxResults(10).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.close();
			entityTX.getEntityManagerFactory().close();
		}

		return resultList;
	}
	
	public ArrayList<CategoriaModal> buscarTodasCategorias() {
		ArrayList<CategoriaModal> resultList = new ArrayList<>();

		try {
			resultList = (ArrayList<CategoriaModal>) entityTX.createQuery("from CategoriaModal")
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.close();
			entityTX.getEntityManagerFactory().close();
		}

		return resultList;
	}

}
