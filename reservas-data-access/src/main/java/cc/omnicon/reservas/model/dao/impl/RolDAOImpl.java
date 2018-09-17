package cc.omnicon.reservas.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cc.omnicon.reservas.model.Rol;
import cc.omnicon.reservas.model.dao.RolDAO;

/**
 * @see (cc.omnicon.reservas.model.dao.RolDAO)
 */
@Repository
@Scope("singleton")
public class RolDAOImpl implements RolDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Rol consultarRolPorId(Integer id) {
		return entityManager.find(Rol.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> consultarTodosRoles() {
		return entityManager.createQuery("FROM Rol").getResultList();
	}

	
}
