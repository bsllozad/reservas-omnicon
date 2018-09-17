package cc.omnicon.reservas.service.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cc.omnicon.reservas.api.dto.UsuarioDto;
import cc.omnicon.reservas.model.Rol;
import cc.omnicon.reservas.model.Usuario;
import cc.omnicon.reservas.service.RolService;
import cc.omnicon.reservas.service.mappers.UsuarioMapper;

/**
 * Mapper dto entity de Usuario
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-api
 * @class UsuarioMapperImpl
 * @date Sep 16, 2018
 *
 */
@Scope("singleton")
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

	@Autowired
	RolService rolService;

	@Transactional(readOnly = true)
	public UsuarioDto usuarioToUsuarioDto(Usuario usuario) throws Exception {
		try {
			UsuarioDto usuarioDto = new UsuarioDto();

			usuarioDto.setNumeroIdentificacion(usuario.getNumeroIdentificacion());
			usuarioDto.setApellidos((usuario.getApellidos() != null) ? usuario.getApellidos() : null);
			usuarioDto.setContrasena((usuario.getContrasena() != null) ? usuario.getContrasena() : null);
			usuarioDto.setEstado((usuario.getEstado() != null) ? usuario.getEstado() : null);
			usuarioDto.setNombres((usuario.getNombres() != null) ? usuario.getNombres() : null);
			usuarioDto.setTelefono((usuario.getTelefono() != null) ? usuario.getTelefono() : null);
			usuarioDto.setUsuario((usuario.getUsuario() != null) ? usuario.getUsuario() : null);
			usuarioDto.setIdRol((usuario.getRol().getIdRol() != null) ? usuario.getRol().getIdRol() : null);
			usuarioDto.setRol((usuario.getRol().getDescripcion() != null) ? usuario.getRol().getDescripcion() : null);

			return usuarioDto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) throws Exception {
		try {
			Usuario usuario = new Usuario();

			usuario.setNumeroIdentificacion(usuarioDto.getNumeroIdentificacion());
			usuario.setApellidos((usuarioDto.getApellidos() != null) ? usuarioDto.getApellidos() : null);
			usuario.setContrasena((usuarioDto.getContrasena() != null) ? usuarioDto.getContrasena() : null);
			usuario.setEstado((usuarioDto.getEstado() != null) ? usuarioDto.getEstado() : null);
			usuario.setNombres((usuarioDto.getNombres() != null) ? usuarioDto.getNombres() : null);
			usuario.setTelefono((usuarioDto.getTelefono() != null) ? usuarioDto.getTelefono() : null);
			usuario.setUsuario((usuarioDto.getUsuario() != null) ? usuarioDto.getUsuario() : null);
			
			Rol rol = new Rol();

			if (usuarioDto.getIdRol() != null) {
				rol = rolService.consultarRolPorId(usuarioDto.getIdRol());
			}

			if (rol != null) {
				usuario.setRol(rol);
			}

			return usuario;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<UsuarioDto> listUsuarioToListUsuarioDto(List<Usuario> listUsuario) throws Exception {
		try {
			List<UsuarioDto> usuarioDtos = new ArrayList<UsuarioDto>();

			for (Usuario usuario : listUsuario) {
				UsuarioDto usuarioDto = usuarioToUsuarioDto(usuario);

				usuarioDtos.add(usuarioDto);
			}

			return usuarioDtos;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<Usuario> listUsuarioDtoToListUsuario(List<UsuarioDto> listUsuarioDto) throws Exception {
		try {
			List<Usuario> listUsuario = new ArrayList<Usuario>();

			for (UsuarioDto usuarioDto : listUsuarioDto) {
				Usuario usuario = usuarioDtoToUsuario(usuarioDto);

				listUsuario.add(usuario);
			}

			return listUsuario;
		} catch (Exception e) {
			throw e;
		}
	}
}
