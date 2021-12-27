package com.ceiba.boleta.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Boleta {

    private Long id;
    private String idUsuario;
    private Long idEvento;
    private LocalDate fechaCompra;
    private Double valorTotalCompra;
    private Long cantidad;

    public Boleta(Long id, String idUsuario, Long idEvento, LocalDate fechaCompra, Double valorTotalCompra, Long cantidad) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.fechaCompra = fechaCompra;
        this.valorTotalCompra = valorTotalCompra;
        this.cantidad = cantidad;
    }
}
