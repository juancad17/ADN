package com.ceiba.configuracion;

import com.ceiba.boleta.puerto.repositorio.RepositorioBoleta;
import com.ceiba.boleta.servicio.ServicioCrearBoleta;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.ServicioCrearEvento;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearEvento servicioCrearEvento(RepositorioEvento repositorioEvento) {
        return new ServicioCrearEvento(repositorioEvento);
    }

    @Bean
    public ServicioCrearBoleta servicioCrearBoleta(RepositorioBoleta repositorioBoleta){
        return new ServicioCrearBoleta(repositorioBoleta);
    }

}
