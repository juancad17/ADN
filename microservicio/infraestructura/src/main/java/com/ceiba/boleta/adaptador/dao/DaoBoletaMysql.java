package com.ceiba.boleta.adaptador.dao;

import com.ceiba.boleta.modelo.dto.DtoBoleta;
import com.ceiba.boleta.puerto.dao.DaoBoleta;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoBoletaMysql implements DaoBoleta {

    private final CustomNamedParameterJdbcTemplate boletaParameterJdbcTemplate;

    public DaoBoletaMysql(CustomNamedParameterJdbcTemplate boletaParameterJdbcTemplate) {
        this.boletaParameterJdbcTemplate = boletaParameterJdbcTemplate;
    }

    @SqlStatement(namespace="boleta", value="listar")
    private static String sqlListar;

    @Override
    public List<DtoBoleta> listar() {
        return this.boletaParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoBoleta());
    }
}
