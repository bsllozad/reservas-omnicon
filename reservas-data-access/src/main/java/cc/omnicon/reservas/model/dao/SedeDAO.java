package cc.omnicon.reservas.model.dao;

import java.util.List;

import cc.omnicon.reservas.model.Sede;

/**
 * Interfaz de persistencia para la entidad Sede
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class SedeDAO
 * @date Sep 15, 2018
 *
 */
public interface SedeDAO{
	
	Sede consultarSedePorId(Integer id);
	
	List<Sede> consultarTodasSedes();
}
