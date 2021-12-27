package com.ceiba.evento.consulta;

import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.puerto.dao.DaoEvento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEventos {

    private final DaoEvento daoEvento;

    public ManejadorListarEventos(DaoEvento daoEvento) {
        this.daoEvento = daoEvento;
    }

    public List<DtoEvento> ejecutar(){ return this.daoEvento.listar();}
}
