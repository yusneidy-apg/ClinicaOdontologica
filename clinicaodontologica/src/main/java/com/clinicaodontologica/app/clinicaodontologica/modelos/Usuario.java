package com.clinicaodontologica.app.clinicaodontologica.modelos;

public class Usuario {

    private String usuario;
    private String contasenia;
    private String rol;
    private boolean activo;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContasenia() {
        return contasenia;
    }

    public void setContasenia(String contasenia) {
        this.contasenia = contasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}