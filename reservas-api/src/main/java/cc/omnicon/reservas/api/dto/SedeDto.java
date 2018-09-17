package cc.omnicon.reservas.api.dto;

/**
 * DTO que representa a la sede
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class Sede
 * @date Sep 15, 2018
 *
 */
public class SedeDto implements java.io.Serializable {

	private static final long serialVersionUID = -169110785412994469L;

	private Integer idSede;
	private String ciudad;
	private String direccion;
	private String estado;
	private String telefono;

	public SedeDto() {
	}

	public SedeDto(Integer idSede, String ciudad, String direccion, String estado, String telefono) {
		this.idSede = idSede;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.estado = estado;
		this.telefono = telefono;
	}

	public Integer getIdSede() {
		return this.idSede;
	}

	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
