package cc.omnicon.reservas.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cc.omnicon.reservas.model.Reserva;
import cc.omnicon.reservas.model.dao.ReservaDAO;

/**
 * @see(cc.omnicon.reservas.model.dao.ReservaDAO)
 */
@Repository
@Scope("singleton")
public class ReservaDAOImpl implements ReservaDAO {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void guardar(Reserva entity) {
		try {
		entityManager.persist(entity);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void modificar(Reserva entity) {
		entityManager.merge(entity);
	}
	
	@Override
	public void borrar(Reserva entity) {
		entityManager.remove(entity);
	}
	
	@Override
	public Reserva consultarReservaPorId(String id) {
		return entityManager.find(Reserva.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> consultarTodasReservas() {
		return entityManager.createQuery("FROM Reserva").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reserva> consultarReservasActivas() {
		return entityManager.createQuery("SELECT model FROM Reserva model WHERE model.estado = 'ACTIVA'").getResultList();
	}

}
