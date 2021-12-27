package com.ceiba.boleta.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.boleta.modelo.entidad.Boleta;
import com.ceiba.boleta.puerto.repositorio.RepositorioBoleta;
import com.ceiba.boleta.servicio.testdatabuilder.BoletaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.evento.modelo.dto.DtoEvento;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.servicio.testdatabuilder.EventoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCrearBoletaTest {

    @Test
    @DisplayName("Deberia Crear la boleta de manera correcta")
    void ejecutar() {
        // arrange
        Boleta boleta = new BoletaTestDataBuilder().build();
        DtoEvento evento = new BoletaTestDataBuilder().buildDtoEvento();
        RepositorioBoleta repositorioBoleta = Mockito.mock(RepositorioBoleta.class);
        Mockito.when(repositorioBoleta.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioBoleta.crear(boleta)).thenReturn(100L);
        Mockito.when(repositorioBoleta.cargarEventoPorId(boleta.getIdEvento())).thenReturn(new BoletaTestDataBuilder().buildListDtoEvento(evento));
        ServicioCrearBoleta servicioCrearBoleta = new ServicioCrearBoleta(repositorioBoleta);
        // act
        Long idBoleta = servicioCrearBoleta.ejecutar(boleta);
        // assert
        assertEquals(100L, idBoleta);
        Mockito.verify(repositorioBoleta, Mockito.times(1)).crear(boleta);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del evento asociado a la boleta")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelEventoAsociadoALaBoleta() {
        // arrange
        Boleta boleta = new BoletaTestDataBuilder().build();
        RepositorioBoleta repositorioBoleta = Mockito.mock(RepositorioBoleta.class);
        Mockito.when(repositorioBoleta.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioBoleta.crear(boleta)).thenReturn(100L);
        Mockito.when(repositorioBoleta.cargarEventoPorId(boleta.getIdEvento())).thenReturn(null);
        ServicioCrearBoleta servicioCrearBoleta = new ServicioCrearBoleta(repositorioBoleta);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearBoleta.ejecutar(boleta), ExcepcionSinDatos.class, "El evento no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia la boleta")
    void validarExistenciaPrevia(){
        // arrange
        Boleta boleta = new BoletaTestDataBuilder().build();
        RepositorioBoleta repositorioBoleta = Mockito.mock(RepositorioBoleta.class);
        Mockito.when(repositorioBoleta.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearBoleta servicioCrearBoleta = new ServicioCrearBoleta(repositorioBoleta);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearBoleta.validarExistenciaPrevia(boleta), ExcepcionSinDatos.class, "Ya se han creado boletas en el sistema");
    }

    @Test
    @DisplayName("Deberia Cargar el evento de manera correcta")
    void cargarEvento() {
        // arrange
        Boleta boleta = new BoletaTestDataBuilder().build();
        DtoEvento evento = new BoletaTestDataBuilder().buildDtoEvento();
        RepositorioBoleta repositorioBoleta = Mockito.mock(RepositorioBoleta.class);
        Mockito.when(repositorioBoleta.cargarEventoPorId(boleta.getIdEvento())).thenReturn(new BoletaTestDataBuilder().buildListDtoEvento(evento));
        ServicioCrearBoleta servicioCrearBoleta = new ServicioCrearBoleta(repositorioBoleta);
        // act
        DtoEvento eventoConsultado = servicioCrearBoleta.cargarEvento(boleta.getIdEvento());
        // assert
        assertEquals(eventoConsultado, evento);
    }

    @Test
    @DisplayName("Deberia calcular el valor del descuento de la boleta al comprarla una semana antes de manera correcta")
    void calcularDescuentoXUnaSemanaAntes() {
        // arrange
        Boleta boleta = new BoletaTestDataBuilder().conFechaCompra(LocalDate.now().minusDays(7)).build();
        DtoEvento evento = new BoletaTestDataBuilder().buildDtoEvento();
        RepositorioBoleta repositorioBoleta = Mockito.mock(RepositorioBoleta.class);
        ServicioCrearBoleta servicioCrearBoleta = new ServicioCrearBoleta(repositorioBoleta);
        // act
        Double valorDescuento = servicioCrearBoleta.calcularDescuentoXUnaSemanaAntes(boleta, evento);
        // assert
        assertEquals(valorDescuento, 1000L);
    }

    @Test
    @DisplayName("Deberia calcular el valor de descuento de la boleta al comprar mas de 3 boletas de manera correcta")
    void calcularDescuentoXCantidadDeBoletas() {
        // arrange
        Boleta boleta = new BoletaTestDataBuilder().conCantidad(4L).build();
        DtoEvento evento = new BoletaTestDataBuilder().buildDtoEvento();
        RepositorioBoleta repositorioBoleta = Mockito.mock(RepositorioBoleta.class);
        ServicioCrearBoleta servicioCrearBoleta = new ServicioCrearBoleta(repositorioBoleta);
        // act
        Double valorDescuento = servicioCrearBoleta.calcularDescuentoXCantidadDeBoletas(boleta, evento);
        // assert
        assertEquals(valorDescuento, 250L);
    }

    @Test
    @DisplayName("Deberia calcular el valor de descuento de la boleta al comprar mas de 3 boletas de manera correcta")
    void calcularValorTotalCompra() {
        // arrange
        Boleta boleta = new BoletaTestDataBuilder().build();
        DtoEvento evento = new BoletaTestDataBuilder().buildDtoEvento();
        RepositorioBoleta repositorioBoleta = Mockito.mock(RepositorioBoleta.class);
        ServicioCrearBoleta servicioCrearBoleta = new ServicioCrearBoleta(repositorioBoleta);
        // act
        Double valorTotalCompra = servicioCrearBoleta.calcularValorTotalCompra(boleta, evento);
        // assert
        assertEquals(valorTotalCompra, 10000L);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se intente comprar boletas si el evento no cuenta con ellas")
    void actualizarNumeroBoletas() {
        // arrange
        Boleta boleta = new BoletaTestDataBuilder().conCantidad(4L).build();
        DtoEvento evento = new BoletaTestDataBuilder().buildDtoEvento(0L);
        RepositorioBoleta repositorioBoleta = Mockito.mock(RepositorioBoleta.class);
        ServicioCrearBoleta servicioCrearBoleta = new ServicioCrearBoleta(repositorioBoleta);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearBoleta.actualizarNumeroBoletas(boleta,evento), ExcepcionValorInvalido.class, "La cantidad de boletas no esta disponible");
    }
}