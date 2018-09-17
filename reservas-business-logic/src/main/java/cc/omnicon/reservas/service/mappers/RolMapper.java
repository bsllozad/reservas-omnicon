package cc.omnicon.reservas.service.mappers;

import java.util.List;

import cc.omnicon.reservas.api.dto.RolDto;
import cc.omnicon.reservas.model.Rol;

/**
 * Mapper deto y entity de Rol
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-api
 * @class RolMapper
 * @date Sep 15, 2018
 *
 */
public interface RolMapper {
	public RolDto rolToRolDto(Rol rol) throws Exception;

	public Rol rolDtoToRol(RolDto rolDto) throws Exception;

	public List<RolDto> listRolToListRolDto(List<Rol> rols) throws Exception;

	public List<Rol> listRolDtoToListRol(List<RolDto> rolDtos) throws Exception;
}
