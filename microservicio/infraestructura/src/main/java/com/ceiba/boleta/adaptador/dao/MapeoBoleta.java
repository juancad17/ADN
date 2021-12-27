package com.ceiba.boleta.adaptador.dao;

import com.ceiba.boleta.modelo.dto.DtoBoleta;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoBoleta implements RowMapper<DtoBoleta>, MapperResult {

    @Override
    public DtoBoleta mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String idUsuario = rs.getString("id_usuario");
        Long idEvento = rs.getLong("id_evento");;
        LocalDate fechaCompra = extraerLocalDate(rs, "fecha_compra");
        Double valorTotalCompra = rs.getDouble("valor_total_compra");
        Long cantidad = rs.getLong("cantidad");

        return new DtoBoleta(id,idUsuario,idEvento,fechaCompra,valorTotalCompra,cantidad);
    }
}
