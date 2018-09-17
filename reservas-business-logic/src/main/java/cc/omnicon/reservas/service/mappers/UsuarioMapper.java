package cc.omnicon.reservas.service.mappers;

import java.util.List;

import cc.omnicon.reservas.api.dto.UsuarioDto;
import cc.omnicon.reservas.model.Usuario;

/**
 * Mapper de dto y entity de Usuario
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-api
 * @class UsuarioMapper
 * @date Sep 16, 2018
 *
 */
public interface UsuarioMapper {
	
	public UsuarioDto usuarioToUsuarioDto(Usuario usuario) throws Exception;

	public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) throws Exception;

	public List<UsuarioDto> listUsuarioToListUsuarioDto(List<Usuario> usuarios) throws Exception;

	public List<Usuario> listUsuarioDtoToListUsuario(List<UsuarioDto> usuarioDtos) throws Exception;
}
