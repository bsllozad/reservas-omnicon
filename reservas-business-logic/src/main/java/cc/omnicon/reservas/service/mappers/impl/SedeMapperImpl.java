package cc.omnicon.reservas.service.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cc.omnicon.reservas.api.dto.SedeDto;
import cc.omnicon.reservas.model.Sede;
import cc.omnicon.reservas.service.mappers.SedeMapper;

/**
 * Mapper dto y entity de Sede
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-api
 * @class SedeMapperImpl
 * @date Sep 16, 2018
 *
 */
@Component
@Scope("singleton")
public class SedeMapperImpl implements SedeMapper {

	@Transactional(readOnly = true)
	public SedeDto sedeToSedeDto(Sede sede) throws Exception {
		try {
			SedeDto sedeDto = new SedeDto();

			sedeDto.setIdSede(sede.getIdSede());
			sedeDto.setCiudad((sede.getCiudad() != null) ? sede.getCiudad() : null);
			sedeDto.setDireccion((sede.getDireccion() != null) ? sede.getDireccion() : null);
			sedeDto.setEstado((sede.getEstado() != null) ? sede.getEstado() : null);
			sedeDto.setTelefono((sede.getTelefono() != null) ? sede.getTelefono() : null);

			return sedeDto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Sede sedeDtoToSede(SedeDto sedeDto) throws Exception {
		try {
			Sede sede = new Sede();

			sede.setIdSede(sedeDto.getIdSede());
			sede.setCiudad((sedeDto.getCiudad() != null) ? sedeDto.getCiudad() : null);
			sede.setDireccion((sedeDto.getDireccion() != null) ? sedeDto.getDireccion() : null);
			sede.setEstado((sedeDto.getEstado() != null) ? sedeDto.getEstado() : null);
			sede.setTelefono((sedeDto.getTelefono() != null) ? sedeDto.getTelefono() : null);

			return sede;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<SedeDto> listSedeToListSedeDto(List<Sede> listSede) throws Exception {
		try {
			List<SedeDto> sedeDtos = new ArrayList<SedeDto>();

			for (Sede sede : listSede) {
				SedeDto sedeDto = sedeToSedeDto(sede);

				sedeDtos.add(sedeDto);
			}

			return sedeDtos;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<Sede> listSedeDtoToListSede(List<SedeDto> listSedeDto) throws Exception {
		try {
			List<Sede> listSede = new ArrayList<Sede>();

			for (SedeDto sedeDto : listSedeDto) {
				Sede sede = sedeDtoToSede(sedeDto);

				listSede.add(sede);
			}

			return listSede;
		} catch (Exception e) {
			throw e;
		}
	}
}
