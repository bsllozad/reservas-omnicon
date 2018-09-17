package cc.omnicon.reservas.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cc.omnicon.reservas.api.dto.ReservaDto;
import cc.omnicon.reservas.api.enums.EstadoEnum;
import cc.omnicon.reservas.api.exception.BusinessException;
import cc.omnicon.reservas.api.exception.ValidateException;
import cc.omnicon.reservas.model.Reserva;
import cc.omnicon.reservas.model.dao.ReservaDAO;
import cc.omnicon.reservas.service.ReservaService;
import cc.omnicon.reservas.service.mappers.ReservaMapper;

/**
 * Logica de neogcio para Reserva
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-business-logic
 * @class ReservaServiceImpl
 * @date Sep 16, 2018
 *
 */
@Service
@Scope("singleton")
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaDAO reservaDAO;

	@Autowired
	private Validator validator;

	@Autowired
	private ReservaMapper reservaMapper;


	/**
	 * Implementacion del metodo validate
	 * 
	 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
	 * @date Sep 16, 2018
	 * @param reserva
	 * @throws ValidateException
	 */
	public void validateReserva(Reserva reserva) throws ValidateException {
		try {
			Set<ConstraintViolation<Reserva>> constraintViolations = validator.validate(reserva);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<Reserva> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath().toString());
					strMessage.append(" - ");
					strMessage.append(constraintViolation.getMessage());
					strMessage.append(". \n");
				}

				throw new ValidateException(strMessage.toString());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void guardar(Reserva entity) throws BusinessException, ValidateException, Exception {
		try {
			if (entity == null) {
				throw new ValidateException("No hay informacion en la reserva");
			}

			if (entity.getCodigoReserva() == null || entity.getCodigoReserva().isEmpty()) {
				entity.setCodigoReserva(String.valueOf(Calendar.getInstance().getTimeInMillis()));
			}
			validateReserva(entity);

			reservaDAO.guardar(entity);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void modificar(Reserva entity) throws BusinessException, ValidateException, Exception {
		try {
			if (entity == null) {
				throw new ValidateException("No hay informacion en la reserva");
			}

			validateReserva(entity);

			reservaDAO.modificar(entity);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void borrar(Reserva entity) throws BusinessException, ValidateException, Exception {
		try {
			if (entity == null) {
				throw new ValidateException("No hay informacion en la reserva");
			}
			entity.setEstado(EstadoEnum.INACTIVO.toString());
			reservaDAO.modificar(entity);

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva consultarReservaPorId(String id) {
		Reserva entity = null;

		try {
			entity = reservaDAO.consultarReservaPorId(id);
		} catch (Exception e) {
			throw e;
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReservaDto> consultarTodasReservas() throws Exception{
		List<ReservaDto> reservasDto = new ArrayList<ReservaDto>();
		try {
			List<Reserva> reservas = reservaDAO.consultarTodasReservas();

			for (Reserva objeto : reservas) {
				ReservaDto dto = reservaMapper.reservaToReservaDto(objeto);
				reservasDto.add(dto);
			}

			return reservasDto;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<ReservaDto> consultarReservasActivas() throws Exception{
		List<ReservaDto> reservasDto = new ArrayList<ReservaDto>();
		try {
			List<Reserva> reservas = reservaDAO.consultarReservasActivas();

			for (Reserva objeto : reservas) {
				ReservaDto dto = reservaMapper.reservaToReservaDto(objeto);
				reservasDto.add(dto);
			}

			return reservasDto;
		} catch (Exception e) {
			throw e;
		}
	}

}
