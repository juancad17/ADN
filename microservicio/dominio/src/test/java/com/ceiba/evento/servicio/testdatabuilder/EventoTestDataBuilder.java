package com.ceiba.evento.servicio.testdatabuilder;

import com.ceiba.evento.modelo.entidad.Evento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventoTestDataBuilder {

    private Long id;
    private String nombre;
    private String direccion;
    private Double valorEntrada;
    private Long numeroBoletas;
    private Boolean exigeCarnet;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;

    public EventoTestDataBuilder() {
       id = 100L;
       nombre = "Evento" + id;
       direccion = "Calle " + id;
       valorEntrada = 5000D;
       numeroBoletas = 50L;
       exigeCarnet = true;
       fechaInicio = LocalDate.now();
       fechaCierre = LocalDate.now().plusDays(1);
    }

    public EventoTestDataBuilder conCarnet(Boolean exigeCarnet){
        this.exigeCarnet = exigeCarnet;
        return this;
    }
    public EventoTestDataBuilder conValorEntrada(Double valorEntrada){
        this.valorEntrada = valorEntrada;
        return this;
    }
    public EventoTestDataBuilder conFechaInicio(LocalDate fechaInicio){
        this.fechaInicio = fechaInicio;
        return this;
    }

    public Evento build() {return new Evento(id,nombre,direccion,valorEntrada,numeroBoletas,exigeCarnet,fechaInicio,fechaCierre);}
}
