package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @RequestMapping(value="usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Fran");
        usuario.setApellido("Jiménez");
        usuario.setEmail("alumno.401733@ies-azarquiel.es");
        usuario.setTelefono("666900238");
        return usuario;
    }

    @RequestMapping(value="usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setNombre("Fran");
        usuario.setApellido("Jiménez");
        usuario.setEmail("alumno.401733@ies-azarquiel.es");
        usuario.setTelefono("666900238");

        Usuario usuario2 = new Usuario();
        usuario2.setId(445L);
        usuario2.setNombre("Raúl");
        usuario2.setApellido("Jiménez");
        usuario2.setEmail("raul@ies-azarquiel.es");
        usuario2.setTelefono("123456789");

        Usuario usuario3 = new Usuario();
        usuario3.setId(6789L);
        usuario3.setNombre("Francisco");
        usuario3.setApellido("Franco");
        usuario3.setEmail("aguila@ies-azarquiel.es");
        usuario3.setTelefono("987654321");

        Usuario usuario4 = new Usuario();
        usuario4.setId(007L);
        usuario4.setNombre("Pepu");
        usuario4.setApellido("Gómez");
        usuario4.setEmail("coca@ies-azarquiel.es");
        usuario4.setTelefono("111222333");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        return usuarios;
    }

    @RequestMapping(value="usuario2")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Fran");
        usuario.setApellido("Jiménez");
        usuario.setEmail("alumno.401733@ies-azarquiel.es");
        usuario.setTelefono("666900238");
        return usuario;
    }

    @RequestMapping(value="usuario3")
    public Usuario eliminar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Fran");
        usuario.setApellido("Jiménez");
        usuario.setEmail("alumno.401733@ies-azarquiel.es");
        usuario.setTelefono("666900238");
        return usuario;
    }

    @RequestMapping(value="usuario4")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Fran");
        usuario.setApellido("Jiménez");
        usuario.setEmail("alumno.401733@ies-azarquiel.es");
        usuario.setTelefono("666900238");
        return usuario;
    }
}
