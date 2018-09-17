package cc.omnicon.reservas.service;

import java.util.List;

import cc.omnicon.reservas.api.dto.UsuarioDto;
import cc.omnicon.reservas.api.exception.BusinessException;
import cc.omnicon.reservas.api.exception.ValidateException;
import cc.omnicon.reservas.model.Usuario;

/**
 * Interfaz de logica de negocio de Usuario
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-business-logic
 * @class UsuarioService
 * @date Sep 15, 2018
 *
 */
public interface UsuarioService {

	void guardar(Usuario entity) throws BusinessException, ValidateException, Exception;

	void modificar(Usuario entity) throws BusinessException, ValidateException, Exception;

	void borrar(Usuario entity) throws BusinessException, ValidateException, Exception;

	Usuario consultarUsuarioPorId(String id);

	List<UsuarioDto> consultarTodosUsuarios() throws Exception;
	
	void validarUsuario(String usuario, String contrasena) throws ValidateException, BusinessException, Exception;

}
