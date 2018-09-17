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
 * Entidad que representa al rol
 * 
 * @author <a href="mailto:bsllozad@gmail.com">Bernardo Lopez</a>
 * @project reservas-data-access
 * @class Rol
 * @date Sep 15, 2018
 *
 */
@Entity
@Table(name = "rol", schema = "public")
public class Rol implements java.io.Serializable {
	
	private static final long serialVersionUID = 5204444997877949240L;
	
	@NotNull
    private Integer idRol;
	
    private String descripcion;
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Rol() {
    }

    public Rol(Integer idRol, String descripcion, Set<Usuario> usuarios) {
        this.idRol = idRol;
        this.descripcion = descripcion;
        this.usuarios = usuarios;
    }

    @Id
    @Column(name = "id_rol", unique = true, nullable = false)
    public Integer getIdRol() {
        return this.idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
