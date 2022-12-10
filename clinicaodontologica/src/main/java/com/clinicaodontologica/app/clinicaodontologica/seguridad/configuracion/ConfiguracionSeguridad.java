package com.clinicaodontologica.app.clinicaodontologica.seguridad.configuracion;

import com.clinicaodontologica.app.clinicaodontologica.seguridad.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    private final UsuarioServicioImpl usuarioServicio;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ConfiguracionSeguridad(UsuarioServicioImpl usuarioServicio, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioServicio = usuarioServicio;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/usuario/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .and().headers().frameOptions().sameOrigin()
                .and().authorizeRequests()
                .anyRequest().authenticated();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioServicio);
        return provider;
    }
}
