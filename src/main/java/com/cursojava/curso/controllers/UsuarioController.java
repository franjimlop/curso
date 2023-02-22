package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Controller que maneja las solicitudes relacionadas con la gestión de usuarios
@RestController
//Esta anotación indica que este controlador proporciona servicios RESTful y que las respuestas que devuelve se serializan automáticamente en JSON
public class UsuarioController {
    //El @Autowired realiza inyección de dependencias en el controlador
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

    //Método que recibe un token y verifica si el token es válido devolviendo true
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
    //Método que devuelve un objeto Usuario con datos inventados por mí
    @RequestMapping(value="api/usuarios/{id}",method= RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Fran");
        usuario.setApellido("Jiménez");
        usuario.setEmail("alumno.401733@ies-azarquiel.es");
        usuario.setTelefono("666900238");
        return usuario;
    }
    //Método que devuelve la lista de usuarios
    @RequestMapping(value="api/usuarios", method = RequestMethod.GET)
    //El token debe ser válido para que lo devuelva
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization")String token) {
        String usuarioId=jwtUtil.getKey(token);
        if (!validarToken(token)) {return null;}
        if (usuarioId == null) {
            //Devuelve el ArrayList vacío
            return new ArrayList<>();
        }
        //Devuelve los usuarios
        return usuarioDao.getUsuarios();
    }
    //Método que recibe un objeto Usuario, le hashea la contraseña y lo guarda en la base de datos
    @RequestMapping(value="api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrarUsuario(usuario);
    }
    //Método que recibe un id de un usuario y lo borra
    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization")String token, @PathVariable Long id) {
        if (!validarToken(token)) {return;}
        usuarioDao.eliminar(id);
    }
}
