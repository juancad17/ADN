package com.ceiba.boleta.servicio;

import com.ceiba.boleta.modelo.entidad.Boleta;
import com.ceiba.boleta.puerto.repositorio.RepositorioBoleta;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.modelo.entidad.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioCrearBoleta {

    private static final String CANTIDAD_DE_BOLETAS_NO_DISPONIBLES = "La cantidad de boletas no esta disponible";
    private static final String YA_EXISTEN_COMPRAS_EN_EL_SISTEMA = "Ya se han creado boletas en el sistema";
    private static final String EL_EVENTO_NO_EXISTE_EN_EL_SISTEMA = "El evento no existe en el sistema";
    private static final String FECHA_COMPRA_NO_VALIDA = "La fecha invalida para crear boletas";

    private static final double PROCENTAJE_DE_DESCUENTO_X_COMPRAR_MAS_DE_TRES_BOLETAS = 0.05;
    private static final double PROCENTAJE_DE_DESCUENTO_X_UNA_SEMANA_ANTES = 0.1;
    private static final int CANTIDAD_BOLETAS_PARA_APLICAR_DESCUENTO = 3;
    private static final int CANTIDAD_DIAS_PARA_APLICAR_DESCUENTO = 7;

    private final RepositorioBoleta repositorioBoleta;

    public ServicioCrearBoleta(RepositorioBoleta repositorioBoleta) {
        this.repositorioBoleta = repositorioBoleta;
    }

    public Long ejecutar(Boleta boleta) {
        Long resultadoCreacionBoleta = 0L;
        DtoEvento evento = cargarEvento(boleta.getIdEvento());

        if (evento != null) {
            validarExistenciaPrevia(boleta);
            validarFechaCompra(boleta, evento);
            if (validarCantidadBoletasDisponibles(boleta,evento)){
                Double valorTotalCompra = calcularValorTotalCompra(boleta, evento);
                boleta.setValorTotalCompra(valorTotalCompra);
            }
        } else {
            throw new ExcepcionSinDatos(EL_EVENTO_NO_EXISTE_EN_EL_SISTEMA);
        }

        resultadoCreacionBoleta = this.repositorioBoleta.crear(boleta);

        if (!resultadoCreacionBoleta.equals(0L)){
            actualizarNumeroBoletas(boleta,evento);
        }

        return resultadoCreacionBoleta;
    }

    public DtoEvento cargarEvento(Long idEvento) {
        DtoEvento evento = null;
        List<DtoEvento> listaEventos = this.repositorioBoleta.cargarEventoPorId(idEvento);
        if (listaEventos != null) {
            evento = listaEventos.get(0);
        }
        return evento;
    }

    public void validarExistenciaPrevia(Boleta boleta) {
        boolean existe = this.repositorioBoleta.existe(boleta.getId());
        if (existe) {
            throw new ExcepcionSinDatos(YA_EXISTEN_COMPRAS_EN_EL_SISTEMA);
        }
    }

    public void validarFechaCompra(Boleta boleta, DtoEvento evento) {
        if (!boleta.getFechaCompra().isBefore(evento.getFechaInicio())) {
            throw new ExcepcionValorInvalido(FECHA_COMPRA_NO_VALIDA);
        }
    }

    public double calcularDescuentoXUnaSemanaAntes(Boleta boleta, DtoEvento evento) {
        Double valorDescuento = 0D;
        LocalDate fechaValidaParaDescuento = evento.getFechaInicio().minusDays(CANTIDAD_DIAS_PARA_APLICAR_DESCUENTO);
        if (boleta.getFechaCompra().isBefore(fechaValidaParaDescuento) || fechaValidaParaDescuento.equals(boleta.getFechaCompra())) {
            valorDescuento = (evento.getValorEntrada() * boleta.getCantidad() * PROCENTAJE_DE_DESCUENTO_X_UNA_SEMANA_ANTES);
        }
        return valorDescuento;
    }

    public double calcularDescuentoXCantidadDeBoletas(Boleta boleta, DtoEvento evento) {
        Double valorDescuento = 0D;
        if (boleta.getCantidad() > CANTIDAD_BOLETAS_PARA_APLICAR_DESCUENTO) {
            valorDescuento = evento.getValorEntrada() * (Double.valueOf((boleta.getCantidad() - CANTIDAD_BOLETAS_PARA_APLICAR_DESCUENTO))) * PROCENTAJE_DE_DESCUENTO_X_COMPRAR_MAS_DE_TRES_BOLETAS;
        }
        return valorDescuento;
    }

    public double calcularValorTotalCompra(Boleta boleta, DtoEvento evento) {
        Double valorTotalCompra = 0D;
        valorTotalCompra = (boleta.getCantidad() * evento.getValorEntrada()) - calcularDescuentoXUnaSemanaAntes(boleta, evento) - calcularDescuentoXCantidadDeBoletas(boleta, evento);
        return valorTotalCompra;
    }

    public void actualizarNumeroBoletas(Boleta boleta, DtoEvento evento) {

        Long cantidadBoletasRestantes = evento.getNumeroBoletas();
        if (validarCantidadBoletasDisponibles(boleta,evento)){
            cantidadBoletasRestantes = cantidadBoletasRestantes - boleta.getCantidad();
            Evento eventoActualizado = new Evento(evento.getId(),evento.getNombre(),evento.getDireccion(),evento.getValorEntrada(),cantidadBoletasRestantes,evento.getExigeCarnet(),evento.getFechaInicio(),evento.getFechaCierre());
            this.repositorioBoleta.actualizarEventoPorId(eventoActualizado);
        }
    }

    private boolean validarCantidadBoletasDisponibles(Boleta boleta, DtoEvento evento) {
        if (boleta.getCantidad() > evento.getNumeroBoletas()) {
            throw new ExcepcionValorInvalido(CANTIDAD_DE_BOLETAS_NO_DISPONIBLES);
        }else {
            return true;
        }
    }
}
