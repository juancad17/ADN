package com.ceiba.evento.controlador;

import com.ceiba.evento.consulta.ManejadorListarEventos;
import com.ceiba.evento.modelo.dto.DtoEvento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventos")
@Api(tags={"Controlador consulta evento"})
public class ConsultaControladorEvento {

    private final ManejadorListarEventos manejadorListarEvento;

    public ConsultaControladorEvento(ManejadorListarEventos manejadorListarEvento) {
        this.manejadorListarEvento = manejadorListarEvento;
    }

    @GetMapping
    @ApiOperation("Listar Eventos")
    public List<DtoEvento> listar(){return this.manejadorListarEvento.ejecutar();}

}
