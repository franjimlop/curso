package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//Anotación que se utiliza para marcar una clase que realiza operaciones de acceso a datos
@Repository
//Anotación que se utiliza para indicar que un método debe ser ejecutado en una transacción de base de datos
@Transactional
//Implementación de la interfaz UsuarioDao
public class UsuarioDaoImp implements UsuarioDao {
    //Inyecta un EntityManager que se utiliza para realizar operaciones de base de datos en la entidad Usuario
    @PersistenceContext
    private EntityManager entityManager;
    //Devuelve una lista de todos los usuarios almacenados
    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }
    //Elimina un usuario de la BB.DD. con el ID especificado
    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }
    //Guarda un nuevo usuario o actualiza uno existente
    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }
    //Verifica las credenciales de inicio de sesión
    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query="FROM Usuario where email=:email";
        List<Usuario> lista=entityManager.createQuery(query,Usuario.class)
                .setParameter("email",usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            return lista.get(0);
        }
        return null;
    }

}
