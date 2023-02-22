package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller que se encarga de manejar las solicitudes de autenticación
@RestController
//Esta anotación indica que este controlador proporciona servicios RESTful y que las respuestas que devuelve se serializan automáticamente en JSON
public class AuthController {
    //El @Autowired realiza inyección de dependencias en el controlador
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;
    //Maneja las solicitudes POST a la ruta /api/login
    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        //Recibimos el objeto usuario como parámetro (representa las credenciales del usuario que se intenta autenticar)
        //utilizamos el objeto UsuarioDao para buscar en la base de datos un usuario que tenga las mismas credenciales que las proporcionadas
        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        //Si se encuentra un usuario, usa el objeto JWTUtil para crear un token se devuelve como respuesta
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()),usuarioLogueado.getEmail());
            return tokenJwt;
        }
        //Si no se encuentra un usuario se devuelve
        return "FAIL";
    }
}
