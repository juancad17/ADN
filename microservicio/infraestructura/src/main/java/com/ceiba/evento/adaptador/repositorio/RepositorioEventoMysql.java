package com.ceiba.evento.adaptador.repositorio;

import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEventoMysql implements RepositorioEvento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioEventoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="evento", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="evento", value="existe")
    private static String sqlExiste;


    @Override
    public Long crear(Evento evento) {
        return this.customNamedParameterJdbcTemplate.crear(evento,sqlCrear);
    }

    @Override
    public boolean existe(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);

    }
}
