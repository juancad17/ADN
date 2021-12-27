package com.ceiba.boleta.adaptador.repositorio;

import com.ceiba.boleta.modelo.entidad.Boleta;
import com.ceiba.boleta.puerto.repositorio.RepositorioBoleta;
import com.ceiba.evento.adaptador.dao.MapeoEvento;
import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioBoletaMysql implements RepositorioBoleta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioBoletaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "boleta", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "boleta", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "evento", value = "cargarEventoPorId")
    private static String sqlCargarEventoPorId;

    @SqlStatement(namespace = "evento", value = "actualizarEventoPorId")
    private static String sqlactualizarEventoPorId;

    @Override
    public Long crear(Boleta boleta) {
        return this.customNamedParameterJdbcTemplate.crear(boleta, sqlCrear);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public List<DtoEvento> cargarEventoPorId(Long idEvento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idEvento);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlCargarEventoPorId, paramSource, new MapeoEvento());
    }

    @Override
    public void actualizarEventoPorId(Evento evento) {
        this.customNamedParameterJdbcTemplate.actualizar(evento, sqlactualizarEventoPorId);
    }




}
