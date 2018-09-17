package cc.omnicon.reservas.model.dao;

import java.util.List;

import cc.omnicon.reservas.model.Rol;

/**
 * Interfaz de persistencia para la entidad Rol
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class RolDAO
 * @date Sep 15, 2018
 *
 */
public interface RolDAO {
	
	Rol consultarRolPorId(Integer id);
	
	List<Rol> consultarTodosRoles();
	
}
