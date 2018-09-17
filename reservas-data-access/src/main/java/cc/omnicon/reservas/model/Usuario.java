package cc.omnicon.reservas.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Entidad que representa a usuario
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class Usuario
 * @date Sep 15, 2018
 *
 */
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
    
	private static final long serialVersionUID = 8620705880543266225L;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=15,message="Debe ingresar al menos 4 caracteres y máximo 15")
    private String numeroIdentificacion;
	
    @NotNull
    private Rol rol;
    
    @NotNull
    @NotEmpty
    @Size(min=1, max=100,message="Debe ingresar al menos 1 caracteres y máximo 100")
    private String apellidos;
    
    @NotNull
    @NotEmpty
    @Size(min=8, max=150,message="Debe ingresar al menos 8 caracteres y máximo 20")
    private String contrasena;
    private String estado;
    
    @NotNull
    @NotEmpty
    @Size(min=1, max=100,message="Debe ingresar al menos 1 caracteres y máximo 100")
    private String nombres;
    
    @NotNull
    @NotEmpty
    @Size(min=1, max=20,message="Debe ingresar al menos 1 caracteres y máximo 20")
    private String telefono;
    
    @NotNull
    @NotEmpty
    @Size(min=6, max=15,message="Debe ingresar al menos 6 caracteres y máximo 15")
    private String usuario;
    
    private Set<Reserva> reservas = new HashSet<Reserva>(0);

    public Usuario() {
    }

    public Usuario(String numeroIdentificacion, String apellidos,
        String contrasena, String estado, String nombres,
        Set<Reserva> reservas, Rol rol, String telefono, String usuario) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.rol = rol;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.estado = estado;
        this.nombres = nombres;
        this.telefono = telefono;
        this.usuario = usuario;
        this.reservas = reservas;
    }

    @Id
    @Column(name = "numero_identificacion", unique = true, nullable = false)
    public String getNumeroIdentificacion() {
        return this.numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol")
    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Column(name = "apellidos")
    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Column(name = "contrasena")
    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Column(name = "estado")
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "nombres")
    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Column(name = "telefono")
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name = "usuario")
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }
}
