package cc.omnicon.reservas.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cc.omnicon.reservas.model.Usuario;
import cc.omnicon.reservas.model.dao.UsuarioDAO;

/**
 * @see(cc.omnicon.reservas.model.dao.UsuarioDAO)
 */
@Repository
@Scope("singleton")
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void guardar(Usuario entity) {
		entityManager.persist(entity);
	}

	@Override
	public void modificar(Usuario entity) {
		entityManager.merge(entity);
	}

	@Override
	public void borrar(Usuario entity) {
		entityManager.remove(entity);
	}

	@Override
	public Usuario consultarUsuarioPorId(String id) {
		return entityManager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> consultarTodosUsuarios() {
		return entityManager.createQuery("FROM Usuario").getResultList();
	}

	@Override
	public Usuario validarUsuario(String usuario, String contrasena) {
		try {
			String query = "SELECT model FROM Usuario model WHERE model.usuario = '" + usuario + "' AND model.contrasena = '" + contrasena + "'";
			System.out.println(query);
			return (Usuario) entityManager.createQuery(query).getSingleResult();
		} catch (Exception e) {
			if (e instanceof NoResultException) {
				return null;
			}
			throw e;
		}
		
	}

	@Override
	public Usuario consultarUsuarioPorUsuario(String usuario) {
		return (Usuario) entityManager.createQuery("FROM Usuario u WHERE u.usuario = " + usuario).getSingleResult();
	}

}
