package cc.omnicon.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.omnicon.reservas.api.dto.UsuarioDto;
import cc.omnicon.reservas.api.exception.BusinessException;
import cc.omnicon.reservas.api.exception.ValidateException;
import cc.omnicon.reservas.controller.parameters.ResponseRest;
import cc.omnicon.reservas.controller.utils.Constantes;
import cc.omnicon.reservas.model.Usuario;
import cc.omnicon.reservas.service.UsuarioService;
import cc.omnicon.reservas.service.mappers.UsuarioMapper;

/**
 * Controlador de servicios rest de Usuarios
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-rest
 * @class ReservaRestController
 * @date Sep 16, 2018
 *
 */
@RestController
@RequestMapping("/usuario")
@EnableAutoConfiguration
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioMapper usuarioMapper;

	@PostMapping(value = "/guardar")
	public ResponseRest<UsuarioDto> guardar(@RequestBody UsuarioDto usuario) {

		ResponseRest<UsuarioDto> response = new ResponseRest<UsuarioDto>();

		try {

			if (usuario.getUsuarioSesion() == null) {
				throw new ValidateException("Debe haber usuario en sesión");
			}
			
			if (!usuario.getUsuarioSesion().equals(Constantes.CODIGO_ROL_ADMIN)) {
				throw new BusinessException("Esta acción solo se puede realizar con usuario administrador");
			}
			
			Usuario entity = usuarioMapper.usuarioDtoToUsuario(usuario);
			usuarioService.guardar(entity);

			response.setCodigo(Constantes.CODIGO_EXITO_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_EXITO_RESPONSE);

		} catch (ValidateException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (BusinessException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (Exception e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_ERROR_RESPONSE);
		}

		return response;
	}

	@PutMapping(value = "/modificar")
	public ResponseRest<UsuarioDto> modificar(@RequestBody UsuarioDto usuario) {

		ResponseRest<UsuarioDto> response = new ResponseRest<UsuarioDto>();

		try {
			Usuario entity = usuarioMapper.usuarioDtoToUsuario(usuario);
			usuarioService.modificar(entity);

			response.setCodigo(Constantes.CODIGO_EXITO_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_EXITO_RESPONSE);

		} catch (ValidateException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (BusinessException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (Exception e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_ERROR_RESPONSE);
		}

		return response;
	}

	@DeleteMapping(value = "/borrar/{numeroIdentificacion}")
	public ResponseRest<UsuarioDto> borrar(@PathVariable("numeroIdentificacion") String numeroIdentificacion) {

		ResponseRest<UsuarioDto> response = new ResponseRest<UsuarioDto>();

		try {

			Usuario usuario = usuarioService.consultarUsuarioPorId(numeroIdentificacion);
			usuarioService.borrar(usuario);

			response.setCodigo(Constantes.CODIGO_EXITO_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_EXITO_RESPONSE);

		} catch (ValidateException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (BusinessException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (Exception e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_ERROR_RESPONSE);
		}

		return response;
	}

	@GetMapping(value = "/consultartodo")
	public ResponseRest<List<UsuarioDto>> getDataUsuario() {

		ResponseRest<List<UsuarioDto>> response = new ResponseRest<List<UsuarioDto>>();

		try {

			List<UsuarioDto> usuarios = usuarioService.consultarTodosUsuarios();

			response.setCodigo(Constantes.CODIGO_EXITO_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_EXITO_RESPONSE);
			response.setObjeto(usuarios);

		} catch (ValidateException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (BusinessException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (Exception e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_ERROR_RESPONSE);
		}

		return response;
	}

	@GetMapping(value = "/consultar/{numeroIdentificacion}")
	public ResponseRest<UsuarioDto> consultarPorId(@PathVariable("numeroIdentificacion") String numeroIdentificacion) throws Exception {

		ResponseRest<UsuarioDto> response = new ResponseRest<UsuarioDto>();

		try {

			UsuarioDto objeto = usuarioMapper.usuarioToUsuarioDto(usuarioService.consultarUsuarioPorId(numeroIdentificacion));

			response.setCodigo(Constantes.CODIGO_EXITO_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_EXITO_RESPONSE);
			response.setObjeto(objeto);

		} catch (ValidateException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (BusinessException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (Exception e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_ERROR_RESPONSE);
		}

		return response;
	}
	
	@GetMapping(value = "/validarusuario/{usuario}/{contrasena}")
	public ResponseRest<UsuarioDto> validarUsuario(@PathVariable("usuario")String usuario, @PathVariable("contrasena")String contrasena) {
		ResponseRest<UsuarioDto> response = new ResponseRest<UsuarioDto>();
		
		try {
			
			usuarioService.validarUsuario(usuario, contrasena);
			
			response.setCodigo(Constantes.CODIGO_EXITO_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_EXITO_RESPONSE);

		} catch (ValidateException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (BusinessException e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(e.getMessage());
		} catch (Exception e) {
			response.setCodigo(Constantes.CODIGO_ERROR_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_ERROR_RESPONSE);
		}

		return response;
	}
}
