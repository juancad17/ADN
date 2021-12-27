package com.ceiba.boleta.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoBoleta {

    private Long id;
    private String idUsuario;
    private Long idEvento;
    private LocalDate fechaCompra;
    private Double valorTotalCompra;
    private Long cantidad;
}
