package br.com.tec.DAO;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.com.tec.modal.CategoriaModal;
import br.com.tec.utils.EntityManagerUtils;

public class CategoriaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityTX = new EntityManagerUtils().getEntityManager();

	public void salvarCategoria(String categoria) {

		CategoriaModal cat = new CategoriaModal();

		cat.setTipo(categoria);

		try {
			entityTX.getTransaction().begin();
			entityTX.persist(cat);
			entityTX.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			entityTX.getEntityManagerFactory().close();
		}

	}

	public CategoriaModal BuscarPorId(Integer id) {
		return entityTX.find(CategoriaModal.class, id);
	}

}
