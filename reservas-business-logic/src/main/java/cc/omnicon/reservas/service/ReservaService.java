package cc.omnicon.reservas.service;

import java.util.List;

import cc.omnicon.reservas.api.dto.ReservaDto;
import cc.omnicon.reservas.api.exception.BusinessException;
import cc.omnicon.reservas.api.exception.ValidateException;
import cc.omnicon.reservas.model.Reserva;



/**
 * Interfaz logica de negocio de Reserva
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-business-logic
 * @class ReservaService
 * @date Sep 15, 2018
 *
 */
public interface ReservaService {
	
	void guardar(Reserva entity) throws BusinessException, ValidateException, Exception;
	
	void modificar(Reserva entity) throws BusinessException, ValidateException, Exception;
	
	void borrar(Reserva entity) throws BusinessException, ValidateException, Exception;
	
	Reserva consultarReservaPorId(String id);
	
	List<ReservaDto> consultarTodasReservas() throws Exception;
	
	List<ReservaDto> consultarReservasActivas() throws Exception;
	
}
