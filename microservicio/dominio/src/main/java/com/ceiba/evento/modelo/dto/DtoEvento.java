package com.ceiba.evento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoEvento {

    private Long id;
    private String nombre;
    private String direccion;
    private Double valorEntrada;
    private Long numeroBoletas;
    private Boolean exigeCarnet;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
}
