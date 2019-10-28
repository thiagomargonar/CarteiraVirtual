package br.com.tec.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.tec.modal.CategoriaModal;
import br.com.tec.modal.MovimentaçãoModal;
import br.com.tec.utils.EntityManagerUtils;

public class MovimentacaoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityTX = new EntityManagerUtils().getEntityManager();
	
	
	public void salvarMovimentacao(MovimentaçãoModal movimentacao) {

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
	
	public ArrayList<MovimentaçãoModal> buscarTodasMovimentacoes() {
		ArrayList<MovimentaçãoModal> resultList = new ArrayList<>();

		try {
			resultList = (ArrayList<MovimentaçãoModal>) entityTX.createQuery("from MovimentaçãoModal")
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			entityTX.close();
			entityTX.getEntityManagerFactory().close();
		}

		return resultList;
	}
	
	public ArrayList<MovimentaçãoModal> buscar10Movimentacoes() {
		ArrayList<MovimentaçãoModal> resultList = new ArrayList<>();

		try {
			resultList = (ArrayList<MovimentaçãoModal>) entityTX.createQuery("from MovimentaçãoModal")
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
