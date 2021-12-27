package com.ceiba.evento.adaptador.dao;

import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoEvento implements RowMapper<DtoEvento>, MapperResult {

    @Override
    public DtoEvento mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String direccion = rs.getString("direccion");
        //Int to double validate
        Double valorEntrada = rs.getDouble("valor_entrada");
        Long numeroBoletas = rs.getLong("numero_boletas");
        Boolean exigeCarnet = rs.getBoolean("exige_carnet");
        LocalDate fechaInicio = this.extraerLocalDate(rs, "fecha_inicio");
        LocalDate fechaCierre = this.extraerLocalDate(rs, "fecha_cierre");

        return new DtoEvento(id,nombre,direccion,valorEntrada,numeroBoletas,exigeCarnet,fechaInicio,fechaCierre);
    }

}
