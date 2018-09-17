package cc.omnicon.reservas.model.dao;

import java.util.List;

import cc.omnicon.reservas.model.Usuario;

/**
 * Interfaz de persistencia para la entidad Usuario
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class UsuarioDAO
 * @date Sep 15, 2018
 *
 */
public interface UsuarioDAO  {
	
	void guardar(Usuario entity);
	
	void modificar(Usuario entity);
	
	void borrar(Usuario entity);
	
	Usuario consultarUsuarioPorId(String id);
	
	List<Usuario> consultarTodosUsuarios();
	
	Usuario validarUsuario(String usuario, String contrasena);
	
	Usuario consultarUsuarioPorUsuario(String usuario);
	
}
