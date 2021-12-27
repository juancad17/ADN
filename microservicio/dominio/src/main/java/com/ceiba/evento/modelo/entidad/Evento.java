package com.ceiba.evento.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Evento {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_EVENTO = "Se debe ingresar el nombre del evento";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION_DEL_EVENTO = "Se debe ingresar la direccion del evento";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_ENTRADA_DEL_EVENTO = "Se debe ingresar el valor de la entrada del evento";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_BOLETAS_DEL_EVENTO = "Se debe ingresar el numero de boletas del evento";
    private static final String SE_DEBE_INGRESAR_EXIGE_CARNET_DEL_EVENTO = "Se debe ingresar si exige carner el evento";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha de inicio";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CIERRE = "Se debe ingresar la fecha de cierre";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO_MAYOR = "Se debe ingresar una fecha de inicio mayor a la actual";

    private Long id;
    private String nombre;
    private String direccion;
    private Double valorEntrada;
    private Long numeroBoletas;
    private Boolean exigeCarnet;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;

    public Evento(Long id, String nombre, String direccion, Double valorEntrada, Long numeroBoletas, Boolean exigeCarnet, LocalDate fechaInicio, LocalDate fechaCierre) {

        validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DEL_EVENTO);
        validarObligatorio(direccion,SE_DEBE_INGRESAR_LA_DIRECCION_DEL_EVENTO);
        validarObligatorio(valorEntrada,SE_DEBE_INGRESAR_EL_VALOR_ENTRADA_DEL_EVENTO);
        validarObligatorio(numeroBoletas,SE_DEBE_INGRESAR_EL_NUMERO_BOLETAS_DEL_EVENTO);
        validarObligatorio(exigeCarnet,SE_DEBE_INGRESAR_EXIGE_CARNET_DEL_EVENTO);
        validarObligatorio(fechaInicio,SE_DEBE_INGRESAR_LA_FECHA_INICIO);
        validarObligatorio(fechaCierre,SE_DEBE_INGRESAR_LA_FECHA_CIERRE);
        validarMayorActual(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIO_MAYOR);

        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.valorEntrada = valorEntrada;
        this.numeroBoletas = numeroBoletas;
        this.exigeCarnet = exigeCarnet;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
    }
}
