package com.ceiba.boleta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.boleta.comando.ComandoBoleta;
import com.ceiba.boleta.comando.manejador.ManejadorCrearBoleta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boletas")
@Api(tags = { "Controlador comando boleta"})
public class ComandoControladorBoleta {

    private final ManejadorCrearBoleta manejadorCrearBoleta;

    @Autowired
    public ComandoControladorBoleta(ManejadorCrearBoleta manejadorCrearBoleta) {
        this.manejadorCrearBoleta = manejadorCrearBoleta;
    }

    @PostMapping
    @ApiOperation("Crear Boleta")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoBoleta comandoBoleta) {
        return manejadorCrearBoleta.ejecutar(comandoBoleta);
    }
}
