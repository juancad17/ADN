package com.ceiba.boleta.controlador;

import com.ceiba.boleta.consulta.ManejadorListarBoletas;
import com.ceiba.boleta.modelo.dto.DtoBoleta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boletas")
@Api(tags = { "Controlador consulta boleta"})
public class ConsultaControladorBoleta {

    private final ManejadorListarBoletas manejadorListarBoletas;

    public ConsultaControladorBoleta(ManejadorListarBoletas manejadorListarBoletas) {
        this.manejadorListarBoletas = manejadorListarBoletas;
    }

    @GetMapping
    @ApiOperation("Listar Boletas")
    public List<DtoBoleta> listar() {
        return this.manejadorListarBoletas.ejecutar();
    }
}
