package cc.omnicon.reservas.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Entidad que representa a la sede
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class Sede
 * @date Sep 15, 2018
 *
 */
@Entity
@Table(name = "sede", schema = "public")
public class Sede implements java.io.Serializable {
    
	private static final long serialVersionUID = 8084457097218913455L;
	
	@NotNull
    private Integer idSede;
    private String ciudad;
    private String direccion;
    private String estado;
    private String telefono;
    private Set<Reserva> reservas = new HashSet<Reserva>(0);

    public Sede() {
    }

    public Sede(Integer idSede, String ciudad, String direccion, String estado,
        Set<Reserva> reservas, String telefono) {
        this.idSede = idSede;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.estado = estado;
        this.telefono = telefono;
        this.reservas = reservas;
    }

    @Id
    @Column(name = "id_sede", unique = true, nullable = false)
    public Integer getIdSede() {
        return this.idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    @Column(name = "ciudad")
    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Column(name = "direccion")
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "estado")
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "telefono")
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sede")
    public Set<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }
}
