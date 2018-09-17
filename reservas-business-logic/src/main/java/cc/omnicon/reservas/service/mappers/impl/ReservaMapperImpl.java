package cc.omnicon.reservas.service.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cc.omnicon.reservas.api.dto.ReservaDto;
import cc.omnicon.reservas.model.Reserva;
import cc.omnicon.reservas.model.Sede;
import cc.omnicon.reservas.model.Usuario;
import cc.omnicon.reservas.service.SedeService;
import cc.omnicon.reservas.service.UsuarioService;
import cc.omnicon.reservas.service.mappers.ReservaMapper;

/**
 * @see(cc.omnicon.reservas.api.mappers.ReservaMapper)
 */
@Component
@Scope("singleton")
public class ReservaMapperImpl implements ReservaMapper {

	@Autowired
	SedeService sedeService;

	@Autowired
	UsuarioService usuarioServcie;

	@Transactional(readOnly = true)
	public ReservaDto reservaToReservaDto(Reserva reserva) throws Exception {
		try {
			
			ReservaDto reservaDto = new ReservaDto();

			reservaDto.setCodigoReserva(reserva.getCodigoReserva());
			reservaDto.setEstado((reserva.getEstado() != null) ? reserva.getEstado() : null);
			reservaDto.setFechaRegistro(reserva.getFechaRegistro());
			reservaDto.setFechaReserva(reserva.getFechaReserva());
			reservaDto.setNumeroPersonas((reserva.getNumeroPersonas() != null) ? reserva.getNumeroPersonas() : null);
			reservaDto.setIdSede((reserva.getSede().getIdSede() != null) ? reserva.getSede().getIdSede() : null);
			reservaDto.setDireccionSede((reserva.getSede().getDireccion() != null) ? reserva.getSede().getDireccion() : null);
			reservaDto.setNumeroIdentificacionUsuario((reserva.getUsuario().getNumeroIdentificacion() != null) ? reserva.getUsuario().getNumeroIdentificacion() : null);
			reservaDto.setNombreCompletoUsuario((reserva.getUsuario().getNombres() != null || reserva.getUsuario().getApellidos() != null) ? 
					reserva.getUsuario().getNombres() + " " + reserva.getUsuario().getApellidos() : null);

			return reservaDto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Reserva reservaDtoToReserva(ReservaDto reservaDto) throws Exception {
		try {
			Reserva reserva = new Reserva();

			reserva.setCodigoReserva(reservaDto.getCodigoReserva());
			reserva.setEstado((reservaDto.getEstado() != null) ? reservaDto.getEstado() : null);
			reserva.setFechaRegistro(reservaDto.getFechaRegistro());
			reserva.setFechaReserva(reservaDto.getFechaReserva());
			reserva.setNumeroPersonas((reservaDto.getNumeroPersonas() != null) ? reservaDto.getNumeroPersonas() : null);

			Sede sede = new Sede();

			if (reservaDto.getIdSede() != null) {
				sede = sedeService.consultarSedePorId(reservaDto.getIdSede());
			}

			if (sede != null) {
				reserva.setSede(sede);
			}

			Usuario usuario = new Usuario();

			if (reservaDto.getNumeroIdentificacionUsuario() != null) {
				usuario = usuarioServcie.consultarUsuarioPorId(reservaDto.getNumeroIdentificacionUsuario());
			}

			if (usuario != null) {
				reserva.setUsuario(usuario);
			}

			return reserva;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<ReservaDto> listReservaToListReservaDto(List<Reserva> listReserva) throws Exception {
		try {
			List<ReservaDto> reservaDtos = new ArrayList<ReservaDto>();

			for (Reserva reserva : listReserva) {
				ReservaDto reservaDto = reservaToReservaDto(reserva);

				reservaDtos.add(reservaDto);
			}

			return reservaDtos;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<Reserva> listReservaDtoToListReserva(List<ReservaDto> listReservaDto) throws Exception {
		try {
			List<Reserva> listReserva = new ArrayList<Reserva>();

			for (ReservaDto reservaDto : listReservaDto) {
				Reserva reserva = reservaDtoToReserva(reservaDto);

				listReserva.add(reserva);
			}

			return listReserva;
		} catch (Exception e) {
			throw e;
		}
	}
}
