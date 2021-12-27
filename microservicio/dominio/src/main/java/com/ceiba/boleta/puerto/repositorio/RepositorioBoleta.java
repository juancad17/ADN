package com.ceiba.boleta.puerto.repositorio;

import com.ceiba.boleta.modelo.entidad.Boleta;
import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.util.List;

public interface RepositorioBoleta {

    Long crear(Boleta boleta);

    boolean existe(Long id);

    List<DtoEvento> cargarEventoPorId(Long idEvento);

    void actualizarEventoPorId(Evento evento);
}
