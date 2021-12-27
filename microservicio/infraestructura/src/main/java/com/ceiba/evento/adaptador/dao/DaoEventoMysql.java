package com.ceiba.evento.adaptador.dao;

import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.puerto.dao.DaoEvento;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEventoMysql implements DaoEvento {

    private final CustomNamedParameterJdbcTemplate eventoParameterJdbcTemplate;

    public DaoEventoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.eventoParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "evento", value = "listar")
    private static String sqlListar;


    @Override
    public List<DtoEvento> listar() {
        return this.eventoParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEvento());
    }
}
