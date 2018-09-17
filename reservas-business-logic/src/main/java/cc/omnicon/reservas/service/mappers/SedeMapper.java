package cc.omnicon.reservas.service.mappers;

import java.util.List;

import cc.omnicon.reservas.api.dto.SedeDto;
import cc.omnicon.reservas.model.Sede;

/**
 * Mapper de dto y entity de Sede
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-api
 * @class SedeMapper
 * @date Sep 15, 2018
 *
 */
public interface SedeMapper {
	
	public SedeDto sedeToSedeDto(Sede sede) throws Exception;

	public Sede sedeDtoToSede(SedeDto sedeDto) throws Exception;

	public List<SedeDto> listSedeToListSedeDto(List<Sede> sedes) throws Exception;

	public List<Sede> listSedeDtoToListSede(List<SedeDto> sedeDtos) throws Exception;
}
