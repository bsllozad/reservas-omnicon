package cc.omnicon.reservas.api.dto;

import java.util.Date;

/**
 * DTO que representa a la reserva
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class Reserva
 * @date Sep 15, 2018
 *
 */
public class ReservaDto implements java.io.Serializable {

	private static final long serialVersionUID = 7927082321051448412L;

	private String codigoReserva;
	private Integer idSede;
	private String direccionSede;
	private String numeroIdentificacionUsuario;
	private String nombreCompletoUsuario;
	private String estado;
	private Date fechaRegistro;
	private Date fechaReserva;
	private Long numeroPersonas;

	public ReservaDto() {
	}

	public ReservaDto(String codigoReserva, Integer idSede, String direccionSede, String numeroIdentificacionUsuario, String nombreCompletoUsuario,
			String estado, Date fechaRegistro, Date fechaReserva, Long numeroPersonas) {
		this.codigoReserva = codigoReserva;
		this.idSede = idSede;
		this.direccionSede = direccionSede;
		this.numeroIdentificacionUsuario = numeroIdentificacionUsuario;
		this.nombreCompletoUsuario = nombreCompletoUsuario;
		this.estado = estado;
		this.fechaRegistro = fechaRegistro;
		this.fechaReserva = fechaReserva;
		this.numeroPersonas = numeroPersonas;
	}

	public String getCodigoReserva() {
		return this.codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public Integer getIdSede() {
		return idSede;
	}

	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	public String getDireccionSede() {
		return direccionSede;
	}

	public void setDireccionSede(String direccionSede) {
		this.direccionSede = direccionSede;
	}

	public String getNumeroIdentificacionUsuario() {
		return numeroIdentificacionUsuario;
	}

	public void setNumeroIdentificacionUsuario(String numeroIdentificacionUsuario) {
		this.numeroIdentificacionUsuario = numeroIdentificacionUsuario;
	}

	public String getNombreCompletoUsuario() {
		return nombreCompletoUsuario;
	}

	public void setNombreCompletoUsuario(String nombreCompletoUsuario) {
		this.nombreCompletoUsuario = nombreCompletoUsuario;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Long getNumeroPersonas() {
		return this.numeroPersonas;
	}

	public void setNumeroPersonas(Long numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
}
