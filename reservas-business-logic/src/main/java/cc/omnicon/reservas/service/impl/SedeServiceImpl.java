package cc.omnicon.reservas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cc.omnicon.reservas.api.dto.SedeDto;
import cc.omnicon.reservas.api.exception.ValidateException;
import cc.omnicon.reservas.model.Sede;
import cc.omnicon.reservas.model.dao.SedeDAO;
import cc.omnicon.reservas.service.SedeService;
import cc.omnicon.reservas.service.mappers.SedeMapper;

/**
 * Clase que implementa la logica de Sede
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-business-logic
 * @class SedeServiceImpl
 * @date Sep 16, 2018
 *
 */
@Scope("singleton")
@Service("SedeLogic")
public class SedeServiceImpl implements SedeService {

	@Autowired
	private SedeDAO sedeDAO;

	@Autowired
	private SedeMapper sedeMapper;

	@Autowired
	private Validator validator;

	/**
	 * Implementacion del metodo validate
	 * 
	 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
	 * @date Sep 16, 2018
	 * @param reserva
	 * @throws ValidateException
	 */
	public void validateSede(Sede sede) throws Exception {
		try {
			Set<ConstraintViolation<Sede>> constraintViolations = validator.validate(sede);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<Sede> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath().toString());
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
	public Sede consultarSedePorId(Integer id) throws Exception {
		Sede entity = null;

		try {
			entity = sedeDAO.consultarSedePorId(id);
		} catch (Exception e) {
			throw e;
		} finally {
		}

		return entity;
	}

	@Override
	public List<SedeDto> consultarTodasSedes() throws Exception {
		List<SedeDto> sedeesDto = new ArrayList<SedeDto>();
		try {
			List<Sede> sedees = sedeDAO.consultarTodasSedes();

			for (Sede objeto : sedees) {
				SedeDto dto = sedeMapper.sedeToSedeDto(objeto);
				sedeesDto.add(dto);
			}

			return sedeesDto;
		} catch (Exception e) {
			throw e;
		}
	}

}
