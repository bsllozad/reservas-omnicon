package cc.omnicon.reservas.api.dto;

/**
 * DTO que representa al rol
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class Rol
 * @date Sep 15, 2018
 *
 */
public class RolDto implements java.io.Serializable {

	private static final long serialVersionUID = 360944758931544989L;

	private Integer idRol;
	private String descripcion;

	public RolDto() {
	}

	public RolDto(Integer idRol, String descripcion) {
		this.idRol = idRol;
		this.descripcion = descripcion;
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
