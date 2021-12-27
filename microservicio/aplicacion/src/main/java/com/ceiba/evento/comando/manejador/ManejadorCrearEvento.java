package com.ceiba.evento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.comando.fabrica.FabricaEvento;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.servicio.ServicioCrearEvento;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEvento {
    private final FabricaEvento fabricaEvento;
    private final ServicioCrearEvento servicioCrearEvento;

    public ManejadorCrearEvento(FabricaEvento fabricaEvento, ServicioCrearEvento servicioCrearEvento) {
        this.fabricaEvento = fabricaEvento;
        this.servicioCrearEvento = servicioCrearEvento;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEvento comandoEvento) {
        Evento evento = this.fabricaEvento.crear(comandoEvento);
        return new ComandoRespuesta<>(this.servicioCrearEvento.ejecutar(evento));
    }
}
