package com.ceiba.evento.servicio;

import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;

public class ServicioCrearEvento {

    private final RepositorioEvento repositorioEvento;

    public ServicioCrearEvento(RepositorioEvento repositorioEvento) {
        this.repositorioEvento = repositorioEvento;
    }

    public Long ejecutar(Evento evento){
        return this.repositorioEvento.crear(evento);
    }


}
