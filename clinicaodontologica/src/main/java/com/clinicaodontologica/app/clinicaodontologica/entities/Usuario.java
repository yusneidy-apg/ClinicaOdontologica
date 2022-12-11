package com.clinicaodontologica.app.clinicaodontologica.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String usuario;
    private String contrasenia;
    private boolean activo;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="USUARIOSROLES",
            joinColumns = @JoinColumn(name ="idUsuario"),
            inverseJoinColumns = @JoinColumn(name="idRol")
    )
    private Set<Roles> roles;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contasenia) {
        this.contrasenia = contasenia;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Set<Roles> getRoles() {
        return roles;
    }
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        GrantedAuthority autorizacion;
        if(roles != null && !roles.isEmpty()){
            for (Roles rol : roles) {
                autorizacion = new SimpleGrantedAuthority(rol.getNombre());
                autorizaciones.add(autorizacion);
            }
        }
        return autorizaciones;
    }

    @Override
    public String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return activo;
    }
}