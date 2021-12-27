package com.ceiba.evento.servicio.testdatabuilder;

import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDate;

public class ComandoEventoTestDataBuilder {

    private Long id;
    private String nombre;
    private String direccion;
    private Double valorEntrada;
    private Long numeroBoletas;
    private Boolean exigeCarnet;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;

    public ComandoEventoTestDataBuilder(){
        nombre = "TestInfraEvento";
        direccion= "Calle Infra";
        valorEntrada = 5000D;
        numeroBoletas = 50L;
        exigeCarnet = true;
        fechaInicio = LocalDate.now();
        fechaCierre = LocalDate.now().plusDays(1);
    }

    public ComandoEventoTestDataBuilder conFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public ComandoEvento build(){ return new ComandoEvento(id,nombre,direccion,valorEntrada,numeroBoletas,exigeCarnet,fechaInicio,fechaCierre);}

}
