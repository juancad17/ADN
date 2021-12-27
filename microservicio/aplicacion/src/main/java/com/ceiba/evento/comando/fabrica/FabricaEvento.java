package com.ceiba.evento.comando.fabrica;

import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.modelo.entidad.Evento;
import org.springframework.stereotype.Component;

@Component
public class FabricaEvento {
    public Evento crear(ComandoEvento comandoEvento){
        return new Evento(comandoEvento.getId(), comandoEvento.getNombre(), comandoEvento.getDireccion(), comandoEvento.getValorEntrada(), comandoEvento.getNumeroBoletas(), comandoEvento.getExigeCarnet(), comandoEvento.getFechaInicio(), comandoEvento.getFechaCierre());
    }
}
