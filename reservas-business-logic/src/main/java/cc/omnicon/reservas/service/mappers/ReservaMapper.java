package cc.omnicon.reservas.service.mappers;

import cc.omnicon.reservas.api.dto.ReservaDto;
import cc.omnicon.reservas.model.Reserva;

import java.util.List;

/**
 * Mapper de entidad y dto Reserva
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-api
 * @class ReservaMapper
 * @date Sep 15, 2018
 *
 */
public interface ReservaMapper {
	public ReservaDto reservaToReservaDto(Reserva reserva) throws Exception;

	public Reserva reservaDtoToReserva(ReservaDto reservaDto) throws Exception;

	public List<ReservaDto> listReservaToListReservaDto(List<Reserva> reservas) throws Exception;

	public List<Reserva> listReservaDtoToListReserva(List<ReservaDto> reservaDto) throws Exception;
}
