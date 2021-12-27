package com.ceiba.boleta.comando.fabrica;

import com.ceiba.boleta.comando.ComandoBoleta;
import com.ceiba.boleta.modelo.entidad.Boleta;
import org.springframework.stereotype.Component;

@Component
public class FabricaBoleta {

 public Boleta crear(ComandoBoleta comandoBoleta){
     return new Boleta(comandoBoleta.getId(),comandoBoleta.getIdUsuario(),comandoBoleta.getIdEvento(),comandoBoleta.getFechaCompra(),comandoBoleta.getValorTotalCompra(),comandoBoleta.getCantidad());
 }
}
