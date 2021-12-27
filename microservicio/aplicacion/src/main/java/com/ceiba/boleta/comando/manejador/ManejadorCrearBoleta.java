package com.ceiba.boleta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.boleta.comando.ComandoBoleta;
import com.ceiba.boleta.comando.fabrica.FabricaBoleta;
import com.ceiba.boleta.modelo.entidad.Boleta;
import com.ceiba.boleta.servicio.ServicioCrearBoleta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearBoleta implements ManejadorComandoRespuesta<ComandoBoleta, ComandoRespuesta<Long>> {

    private final FabricaBoleta fabricaBoleta;
    private final ServicioCrearBoleta servicioCrearBoleta;

    public ManejadorCrearBoleta(FabricaBoleta fabricaBoleta, ServicioCrearBoleta servicioCrearBoleta) {
        this.fabricaBoleta = fabricaBoleta;
        this.servicioCrearBoleta = servicioCrearBoleta;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoBoleta comandoBoleta) {
        Boleta boleta = this.fabricaBoleta.crear(comandoBoleta);
        return new ComandoRespuesta<>(this.servicioCrearBoleta.ejecutar(boleta));
    }
}
