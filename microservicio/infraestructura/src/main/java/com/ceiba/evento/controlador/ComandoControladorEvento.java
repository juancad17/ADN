package com.ceiba.evento.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.evento.comando.ComandoEvento;
import com.ceiba.evento.comando.manejador.ManejadorCrearEvento;
import com.ceiba.evento.consulta.ManejadorListarEventos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
@Api(tags = { "Controlador comando evento"})
public class ComandoControladorEvento {

    private final ManejadorCrearEvento manejadorCrearEvento;

    @Autowired
    public ComandoControladorEvento(ManejadorCrearEvento manejadorCrearEvento, ManejadorListarEventos manejadorListarEvento) {
        this.manejadorCrearEvento = manejadorCrearEvento;
    }

    @PostMapping
    @ApiOperation("Crear Evento")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEvento comandoEvento) {
        return manejadorCrearEvento.ejecutar(comandoEvento);
    }

}
