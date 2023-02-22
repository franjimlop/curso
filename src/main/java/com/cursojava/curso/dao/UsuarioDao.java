package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

//Interfaz que define los métodos que debe implementar una clase DAO para realizar operaciones de persistencia en la base de datos
public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrarUsuario(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
