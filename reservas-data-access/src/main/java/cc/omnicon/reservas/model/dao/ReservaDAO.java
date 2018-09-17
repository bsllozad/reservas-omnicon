package cc.omnicon.reservas.model.dao;

import java.util.List;

import cc.omnicon.reservas.model.Reserva;

/**
 * Interfaz de persistencia para la entidad Reserva
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class ReservaDAO
 * @date Sep 15, 2018
 *
 */
public interface ReservaDAO {
	
	void guardar(Reserva entity);
	
	void modificar(Reserva entity);
	
	void borrar(Reserva entity);
	
	Reserva consultarReservaPorId(String id);
	
	List<Reserva> consultarTodasReservas();
	
	List<Reserva> consultarReservasActivas();
	
	
}
