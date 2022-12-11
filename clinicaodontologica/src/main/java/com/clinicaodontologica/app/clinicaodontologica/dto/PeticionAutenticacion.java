package com.clinicaodontologica.app.clinicaodontologica.dto;

public class PeticionAutenticacion {

    private String username;
    private String password;

    public PeticionAutenticacion() {
    }

    public PeticionAutenticacion(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
