package com.ceiba.evento.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEvento {

    private Long id;
    private String nombre;
    private String direccion;
    private Double valorEntrada;
    private Long numeroBoletas;
    private Boolean exigeCarnet;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
}
