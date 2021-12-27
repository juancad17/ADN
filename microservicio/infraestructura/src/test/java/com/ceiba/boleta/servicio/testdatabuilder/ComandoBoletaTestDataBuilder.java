package com.ceiba.boleta.servicio.testdatabuilder;

import com.ceiba.boleta.comando.ComandoBoleta;

import java.time.LocalDate;

public class ComandoBoletaTestDataBuilder {

    private Long id;
    private String idUsuario;
    private Long idEvento;
    private LocalDate fechaCompra;
    private Double valorTotalCompra;
    private Long cantidad;

    public ComandoBoletaTestDataBuilder() {
        idUsuario = "123";
        idEvento = 1L;
        fechaCompra = LocalDate.now().minusDays(1);
        valorTotalCompra = 0D;
        cantidad = 3L;
    }

    public ComandoBoleta build(){
        return new ComandoBoleta(id,idUsuario,idEvento,fechaCompra,valorTotalCompra,cantidad);
    }
}
