package com.sena.auth_service.service;

import com.sena.auth_service.dto.CredencialesDTO;
import com.sena.auth_service.entity.Usuario;
import com.sena.auth_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String registrar(CredencialesDTO datos) {

        Usuario usuario = new Usuario();

        usuario.setUsuario(datos.getUsuario());
        usuario.setContrasena(datos.getContrasena());

        usuarioRepository.save(usuario);

        return "Usuario registrado correctamente";
    }

    public String login(CredencialesDTO datos) {

        Usuario usuario =
                usuarioRepository.findByUsuario(
                        datos.getUsuario()
                );

        if (usuario != null &&
                usuario.getContrasena().equals(
                        datos.getContrasena())) {

            return "Autenticación satisfactoria";
        }

        return "Error en la autenticación";
    }
}