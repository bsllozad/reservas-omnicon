package cc.omnicon.reservas.service;

import java.util.List;

import cc.omnicon.reservas.api.dto.SedeDto;
import cc.omnicon.reservas.model.Sede;

/**
 * Interfaz de logica de negocio de Sede
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-business-logic
 * @class SedeService
 * @date Sep 16, 2018
 *
 */
public interface SedeService {
	
	Sede consultarSedePorId(Integer id) throws Exception;

	List<SedeDto> consultarTodasSedes() throws Exception;
}
