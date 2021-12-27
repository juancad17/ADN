package com.ceiba.evento.puerto.repositorio;

import com.ceiba.evento.modelo.entidad.Evento;

public interface RepositorioEvento {

    Long crear(Evento evento);

    boolean existe(Integer id);
}
