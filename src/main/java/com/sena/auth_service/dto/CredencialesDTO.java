package com.sena.auth_service.dto;

public class CredencialesDTO {

    private String usuario;
    private String contrasena;

    public CredencialesDTO() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}