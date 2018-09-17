package cc.omnicon.reservas.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cc.omnicon.reservas.model.Sede;
import cc.omnicon.reservas.model.dao.SedeDAO;

/**
 * @see(cc.omnicon.reservas.model.dao.SedeDAO)
 */
@Repository
@Scope("singleton")
public class SedeDAOImpl implements SedeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Sede consultarSedePorId(Integer id) {
		return entityManager.find(Sede.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sede> consultarTodasSedes() {
		return entityManager.createQuery("FROM Sede").getResultList();
	}
	
	

}
