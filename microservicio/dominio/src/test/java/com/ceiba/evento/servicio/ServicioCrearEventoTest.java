package com.ceiba.evento.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.evento.modelo.entidad.Evento;
import com.ceiba.evento.puerto.repositorio.RepositorioEvento;
import com.ceiba.evento.servicio.testdatabuilder.EventoTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCrearEventoTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha inicial sea menor a la fecha actual")
    void deberiaLanzarUnaExepcionCuandoLaFechaInicialSeaMenorALaFechaActual() {
        // arrange
        EventoTestDataBuilder eventoTestDataBuilder = new EventoTestDataBuilder().conFechaInicio(LocalDate.now().minusDays(1));
        // act - assert
        BasePrueba.assertThrows(eventoTestDataBuilder::build, ExcepcionValorInvalido.class, "Se debe ingresar una fecha de inicio mayor a la actual");
    }

    @Test
    @DisplayName("Deberia Crear el evento de manera correcta")
    void ejecutar() {
        // arrange
        Evento evento = new EventoTestDataBuilder().build();
        RepositorioEvento repositorioEvento =  Mockito.mock(RepositorioEvento.class);
        Mockito.when(repositorioEvento.crear(evento)).thenReturn(100L);
        ServicioCrearEvento servicioCrearEvento = new ServicioCrearEvento(repositorioEvento);
        //act
        Long idEvento = servicioCrearEvento.ejecutar(evento);
        // assert
        assertEquals(100L,idEvento);
        Mockito.verify(repositorioEvento,Mockito.times(1)).crear(evento);
    }
}