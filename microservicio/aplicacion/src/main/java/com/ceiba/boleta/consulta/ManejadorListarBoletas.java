package com.ceiba.boleta.consulta;

import com.ceiba.boleta.modelo.dto.DtoBoleta;
import com.ceiba.boleta.puerto.dao.DaoBoleta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarBoletas {

    private final DaoBoleta daoBoleta;

    public ManejadorListarBoletas(DaoBoleta daoBoleta) {
        this.daoBoleta = daoBoleta;
    }

    public List<DtoBoleta> ejecutar(){return this.daoBoleta.listar();}
}
