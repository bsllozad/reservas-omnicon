package cc.omnicon.reservas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.omnicon.reservas.api.dto.RolDto;
import cc.omnicon.reservas.model.Rol;
import cc.omnicon.reservas.model.dao.RolDAO;
import cc.omnicon.reservas.service.RolService;
import cc.omnicon.reservas.service.mappers.RolMapper;


/**
 * Clase que implementa la logica de negocio de Rol.
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-business-logic
 * @class RolServiceImpl
 * @date Sep 16, 2018
 *
 */
@Service
@Scope("singleton")
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDAO rolDAO;
    
    @Autowired
    private RolMapper rolMapper;
    
    @Autowired
    private Validator validator;

    /**
     * Implementacion del metodo validate
     * 
     * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
     * @date Sep 16, 2018
     * @param rol
     * @throws Exception
     */
    public void validateRol(Rol rol) throws Exception {
        try {
            Set<ConstraintViolation<Rol>> constraintViolations = validator.validate(rol);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Rol> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

	@Override
	@Transactional(readOnly = true)
	public Rol consultarRolPorId(Integer id) throws Exception {
		Rol entity = null;

		try {
			entity = rolDAO.consultarRolPorId(id);
		} catch (Exception e) {
			throw e;
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RolDto> consultarTodosRoles() throws Exception {
		List<RolDto> rolesDto = new ArrayList<RolDto>();
		try {
			List<Rol> roles = rolDAO.consultarTodosRoles();

			for (Rol objeto : roles) {
				RolDto dto = rolMapper.rolToRolDto(objeto);
				rolesDto.add(dto);
			}

			return rolesDto;
		} catch (Exception e) {
			throw e;
		}
	}

 
}
