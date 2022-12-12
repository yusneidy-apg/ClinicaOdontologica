package com.clinicaodontologica.app.clinicaodontologica.seguridad.configuracion;

import com.clinicaodontologica.app.clinicaodontologica.seguridad.UsuarioServicioImpl;
import com.clinicaodontologica.app.clinicaodontologica.seguridad.jwt.FiltroJwtPeticion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    private final UsuarioServicioImpl usuarioServicio;

    private final FiltroJwtPeticion filtroJwtPeticion;

    private final PasswordEncoder codificar;


    @Autowired
    public ConfiguracionSeguridad(UsuarioServicioImpl usuarioServicio, FiltroJwtPeticion filtroJwtPeticion, PasswordEncoder codificar) {
        this.usuarioServicio = usuarioServicio;
        this.filtroJwtPeticion = filtroJwtPeticion;
        this.codificar = codificar;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioServicio);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/usuario/login").permitAll()
                .antMatchers(HttpMethod.POST, "/usuario").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/odontologo").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/paciente").hasAuthority("ROLE_ADMIN")
                .antMatchers("/odontologo/**").hasAuthority("ROLE_USER")
                .antMatchers("/paciente/**").hasAuthority("ROLE_USER")
                .antMatchers("/turno").hasAuthority("ROLE_USER")
                .antMatchers("/h2-console/**").permitAll()
                .and().headers().frameOptions().sameOrigin()
                .and().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filtroJwtPeticion, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(codificar);
        provider.setUserDetailsService(usuarioServicio);
        return provider;
    }
}
