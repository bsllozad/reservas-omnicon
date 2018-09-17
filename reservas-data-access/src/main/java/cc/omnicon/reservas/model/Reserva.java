package cc.omnicon.reservas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Entidad que representa a la reserva
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class Reserva
 * @date Sep 15, 2018
 *
 */
@Entity
@Table(name = "reserva", schema = "public")
public class Reserva implements java.io.Serializable {
	
	private static final long serialVersionUID = -4196183563836005470L;
	
	@NotNull
    private String codigoReserva;
	
    @NotNull
    private Sede sede;
    
    @NotNull
    private Usuario usuario;
    
    @NotNull
    private String estado;
    
    
    private Date fechaRegistro;
    
    @NotNull
    private Date fechaReserva;
    
    @NotNull
    private Long numeroPersonas;

    public Reserva() {
    }

    public Reserva(String codigoReserva, String estado, Date fechaRegistro,
        Date fechaReserva, Long numeroPersonas, Sede sede, Usuario usuario) {
        this.codigoReserva = codigoReserva;
        this.sede = sede;
        this.usuario = usuario;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.fechaReserva = fechaReserva;
        this.numeroPersonas = numeroPersonas;
    }

    @Id
    @Column(name = "codigo_reserva", unique = true, nullable = false)
    public String getCodigoReserva() {
        return this.codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sede")
    public Sede getSede() {
        return this.sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "numero_identificacion")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name = "estado")
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "fecha_registro")
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Column(name = "fecha_reserva")
    public Date getFechaReserva() {
        return this.fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    @Column(name = "numero_personas")
    public Long getNumeroPersonas() {
        return this.numeroPersonas;
    }

    public void setNumeroPersonas(Long numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }
}
