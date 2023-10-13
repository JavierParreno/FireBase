package com.example.firebase.usuario;

public class Usuario {
    private String UsuarioNombre;

    private String UsuarioCorreo;

    public Usuario() {
    }

    public Usuario(String usuarioNombre, String usuarioCorreo) {
        UsuarioNombre = usuarioNombre;
        UsuarioCorreo = usuarioCorreo;
    }

    public String getUsuarioNombre() {
        return UsuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        UsuarioNombre = usuarioNombre;
    }

    public String getUsuarioCorreo() {
        return UsuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        UsuarioCorreo = usuarioCorreo;
    }
}
