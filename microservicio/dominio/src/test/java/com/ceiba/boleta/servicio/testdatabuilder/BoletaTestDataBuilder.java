package com.ceiba.boleta.servicio.testdatabuilder;

import com.ceiba.boleta.modelo.entidad.Boleta;
import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.modelo.entidad.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BoletaTestDataBuilder {

    private Long id;
    private String idUsuario;
    private Long idEvento;
    private LocalDate fechaCompra;
    private Double valorTotalCompra;
    private Long cantidad;

    public BoletaTestDataBuilder(){
        id = 100L;
        idUsuario = "100";
        idEvento = 100L;
        fechaCompra = LocalDate.now().minusDays(2);
        valorTotalCompra = 5000D;
        cantidad = 2L;
    }

    public BoletaTestDataBuilder conIdUsuario(String idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }
    public BoletaTestDataBuilder conIdEvento(Long idEvento){
        this.idEvento = idEvento;
        return this;
    }
    public BoletaTestDataBuilder conFechaCompra(LocalDate fechaCompra){
        this.fechaCompra = fechaCompra;
        return this;
    }
    public BoletaTestDataBuilder conValorTotalCompra(Double valorTotalCompra){
        this.valorTotalCompra = valorTotalCompra;
        return this;
    }
    public BoletaTestDataBuilder conCantidad(Long cantidad){
        this.cantidad = cantidad;
        return this;
    }

    public Boleta build(){
        return new Boleta(id,idUsuario,idEvento,fechaCompra,valorTotalCompra,cantidad);
    }

    public DtoEvento buildDtoEvento(){
        return new DtoEvento(100L,"EventoTestBoleta","Calle blt", 5000D,50l,true, LocalDate.now(), LocalDate.now().plusDays(1));
    }

    public DtoEvento buildDtoEvento(Long numeroBoletas){
        return new DtoEvento(100L,"EventoTestBoleta","Calle blt", 5000D,numeroBoletas,true, LocalDate.now(), LocalDate.now().plusDays(1));
    }

    public List<DtoEvento> buildListDtoEvento(DtoEvento evento){
        List<DtoEvento> listaEventos = new ArrayList<DtoEvento>();
        listaEventos.add(0,evento);
        return listaEventos;
    }

    public Evento buildEvento(){
        return new Evento(100L,"EventoTestBoleta","Calle blt", 5000D,0l,true, LocalDate.now(), LocalDate.now().plusDays(1));
    }

}
