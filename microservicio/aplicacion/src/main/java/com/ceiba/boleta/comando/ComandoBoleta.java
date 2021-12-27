package com.ceiba.boleta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoBoleta {

    private Long id;
    private String idUsuario;
    private Long idEvento;
    private LocalDate fechaCompra;
    private Double valorTotalCompra;
    private Long cantidad;
}
