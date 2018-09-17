package cc.omnicon.reservas.api.dto;

/**
 * DTO que representa a usuario
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class Usuario
 * @date Sep 15, 2018
 *
 */
public class UsuarioDto implements java.io.Serializable {

	private static final long serialVersionUID = 8848953859376382348L;

	private String numeroIdentificacion;
	private Integer idRol;
	private String rol;
	private String apellidos;
	private String contrasena;
	private String estado;
	private String nombres;
	private String telefono;
	private String usuario;
	private Integer usuarioSesion;

	public UsuarioDto() {
	}

	public UsuarioDto(String numeroIdentificacion, String apellidos, String contrasena, String estado, String nombres, String rol,
			Integer idRol, String telefono, String usuario, Integer usuarioSesion) {
		this.numeroIdentificacion = numeroIdentificacion;
		this.idRol = idRol;
		this.rol = rol;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.estado = estado;
		this.nombres = nombres;
		this.telefono = telefono;
		this.usuario = usuario;
		this.usuarioSesion = usuarioSesion;
	}

	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(Integer usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	
}
