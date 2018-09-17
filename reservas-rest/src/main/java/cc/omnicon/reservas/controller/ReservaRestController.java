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

import cc.omnicon.reservas.api.dto.ReservaDto;
import cc.omnicon.reservas.api.exception.BusinessException;
import cc.omnicon.reservas.api.exception.ValidateException;
import cc.omnicon.reservas.controller.parameters.ResponseRest;
import cc.omnicon.reservas.controller.utils.Constantes;
import cc.omnicon.reservas.model.Reserva;
import cc.omnicon.reservas.service.ReservaService;
import cc.omnicon.reservas.service.mappers.ReservaMapper;

/**
 * Controlador de servicios rest de Reservas
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-rest
 * @class ReservaRestController
 * @date Sep 16, 2018
 *
 */
@RestController
@RequestMapping("/reserva")
@EnableAutoConfiguration
public class ReservaRestController {


	@Autowired
	private ReservaService reservaService;

	@Autowired
	private ReservaMapper reservaMapper;

	@PostMapping(value = "/guardar")
	public ResponseRest<Reserva> guardar(@RequestBody ReservaDto reserva) {
		ResponseRest<Reserva> response = new ResponseRest<Reserva>();
		try {

			Reserva entity = reservaMapper.reservaDtoToReserva(reserva);
			reservaService.guardar(entity);

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
	public ResponseRest<Reserva> modificar(@RequestBody ReservaDto reserva) {
		ResponseRest<Reserva> response = new ResponseRest<Reserva>();
		try {

			Reserva entity = reservaMapper.reservaDtoToReserva(reserva);
			reservaService.modificar(entity);

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

	@DeleteMapping(value = "/borrar/{codigoReserva}")
	public ResponseRest<Reserva> borrar(@PathVariable("codigoReserva") String codigoReserva) {
		ResponseRest<Reserva> response = new ResponseRest<Reserva>();
		try {

			Reserva entity = reservaService.consultarReservaPorId(codigoReserva);
			reservaService.borrar(entity);

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
	public ResponseRest<List<ReservaDto>> consultarTodasReservas() {
		ResponseRest<List<ReservaDto>> response = new ResponseRest<List<ReservaDto>>();
		try {

			List<ReservaDto> reservas = reservaService.consultarTodasReservas();

			response.setCodigo(Constantes.CODIGO_EXITO_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_EXITO_RESPONSE);
			response.setObjeto(reservas);

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

	@GetMapping(value = "/consultar/{codigoReserva}")
	public ResponseRest<ReservaDto> consultarPorId(@PathVariable("codigoReserva") String codigoReserva) {
		ResponseRest<ReservaDto> response = new ResponseRest<ReservaDto>();
		try {

			ReservaDto objeto = reservaMapper.reservaToReservaDto(reservaService.consultarReservaPorId(codigoReserva));

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
	
	@GetMapping(value = "/consultaractivas")
	public ResponseRest<List<ReservaDto>>  consultarReservasActivas() {
		ResponseRest<List<ReservaDto>> response = new ResponseRest<List<ReservaDto>>();
		try {

			List<ReservaDto> reservas = reservaService.consultarReservasActivas();

			response.setCodigo(Constantes.CODIGO_EXITO_RESPONSE);
			response.setMensaje(Constantes.MENSAJE_EXITO_RESPONSE);
			response.setObjeto(reservas);

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
