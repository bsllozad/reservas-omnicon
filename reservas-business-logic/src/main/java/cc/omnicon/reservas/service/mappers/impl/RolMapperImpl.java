package cc.omnicon.reservas.service.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cc.omnicon.reservas.api.dto.RolDto;
import cc.omnicon.reservas.model.Rol;
import cc.omnicon.reservas.service.mappers.RolMapper;

/**
 * Mapper dto entity de rol
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-business-logic
 * @class RolMapperImpl
 * @date Sep 16, 2018
 *
 */
@Scope("singleton")
@Component
public class RolMapperImpl implements RolMapper {

	@Transactional(readOnly = true)
	public RolDto rolToRolDto(Rol rol) throws Exception {
		try {
			RolDto rolDto = new RolDto();

			rolDto.setIdRol(rol.getIdRol());
			rolDto.setDescripcion((rol.getDescripcion() != null) ? rol.getDescripcion() : null);

			return rolDto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Rol rolDtoToRol(RolDto rolDto) throws Exception {
		try {
			Rol rol = new Rol();

			rol.setIdRol(rolDto.getIdRol());
			rol.setDescripcion((rolDto.getDescripcion() != null) ? rolDto.getDescripcion() : null);

			return rol;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<RolDto> listRolToListRolDto(List<Rol> listRol) throws Exception {
		try {
			List<RolDto> rolDtos = new ArrayList<RolDto>();

			for (Rol rol : listRol) {
				RolDto rolDto = rolToRolDto(rol);

				rolDtos.add(rolDto);
			}

			return rolDtos;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<Rol> listRolDtoToListRol(List<RolDto> listRolDto) throws Exception {
		try {
			List<Rol> listRol = new ArrayList<Rol>();

			for (RolDto rolDto : listRolDto) {
				Rol rol = rolDtoToRol(rolDto);

				listRol.add(rol);
			}

			return listRol;
		} catch (Exception e) {
			throw e;
		}
	}
}
