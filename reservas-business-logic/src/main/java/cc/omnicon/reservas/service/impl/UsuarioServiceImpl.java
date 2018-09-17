package cc.omnicon.reservas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cc.omnicon.reservas.api.dto.UsuarioDto;
import cc.omnicon.reservas.api.exception.BusinessException;
import cc.omnicon.reservas.api.exception.ValidateException;
import cc.omnicon.reservas.api.utils.Utils;
import cc.omnicon.reservas.model.Usuario;
import cc.omnicon.reservas.model.dao.UsuarioDAO;
import cc.omnicon.reservas.service.UsuarioService;
import cc.omnicon.reservas.service.mappers.UsuarioMapper;


/**
 * Clase que implementa la logica de negocio de usuario.
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project usuarios-business-logic
 * @class UsuarioServiceImpl
 * @date Sep 16, 2018
 *
 */
@Scope("singleton")
@Service
public class UsuarioServiceImpl implements UsuarioService {
	

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Autowired
    private Validator validator;

    @Autowired
    private Utils utils;
    
    /**
     * Logica de neogcio para Usuario
     * 
     * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
     * @project usuarios-business-logic
     * @class UsuarioServiceImpl
     * @date Sep 16, 2018
     *
     */
    public void validateUsuario(Usuario usuario) throws Exception {
        try {
            Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Usuario> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new ValidateException(strMessage.toString());
            }
        } catch (ValidateException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void guardar(Usuario entity) throws BusinessException, ValidateException, Exception {
		try {
			if (entity == null) {
				throw new ValidateException("No hay informacion en Usuario");
			}

			validateUsuario(entity);
			
			entity.setContrasena(utils.encriptarSha1(entity.getContrasena()));

			usuarioDAO.guardar(entity);

		}  catch (ValidateException e) {
            throw e;
        }  catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void modificar(Usuario entity) throws BusinessException, ValidateException, Exception {
		try {
			if (entity == null) {
				throw new ValidateException("No hay informacion en Usuario");
			}

			validateUsuario(entity);

			usuarioDAO.modificar(entity);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void borrar(Usuario entity) throws BusinessException, ValidateException, Exception {
		try {
			if (entity == null) {
				throw new ValidateException("No hay informacion de Usuario");
			}

			usuarioDAO.borrar(entity);

		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	@Transactional(readOnly = true)
	public Usuario consultarUsuarioPorId(String id) {
		Usuario entity = null;

		try {
			entity = usuarioDAO.consultarUsuarioPorId(id);
		} catch (Exception e) {
			throw e;
		} 
		return entity;
	}


	@Override
	@Transactional(readOnly = true)
	public List<UsuarioDto> consultarTodosUsuarios() throws Exception{
		List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>();
		try {
			List<Usuario> usuarios = usuarioDAO.consultarTodosUsuarios();

			for (Usuario objeto : usuarios) {
				UsuarioDto dto = usuarioMapper.usuarioToUsuarioDto(objeto);
				usuariosDto.add(dto);
			}

			return usuariosDto;
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public void validarUsuario(String usuario, String contrasena) throws ValidateException, BusinessException, Exception {
		
		if (usuario == null || usuario.isEmpty() || contrasena == null || contrasena.isEmpty()) {
			throw new ValidateException("Debe enviar el usuario y COntrasena");
		}
		
		try {
			Usuario entity = usuarioDAO.validarUsuario(usuario, utils.encriptarSha1(contrasena));
			if (entity == null || entity.getNumeroIdentificacion() == null || entity.getNumeroIdentificacion().isEmpty()) {
				throw new BusinessException("Usuario o Contrasena incorrectos");
			}
			
		}catch (Exception e) {
			throw e;
		}
		
	}

   
}
