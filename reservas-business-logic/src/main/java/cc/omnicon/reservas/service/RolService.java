package cc.omnicon.reservas.service;

import java.util.List;

import cc.omnicon.reservas.api.dto.RolDto;
import cc.omnicon.reservas.model.Rol;

/**
 * Interfaz de logica de negocio de Rol
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-business-logic
 * @class RolService
 * @date Sep 15, 2018
 *
 */
public interface RolService {
    
	Rol consultarRolPorId(Integer id) throws Exception;
	
	List<RolDto> consultarTodosRoles() throws Exception;
	
}
