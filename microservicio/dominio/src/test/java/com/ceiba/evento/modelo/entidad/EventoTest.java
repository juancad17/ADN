package com.ceiba.evento.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.evento.servicio.testdatabuilder.EventoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    @DisplayName("Deberia crear correctamente el evento")
    void deberiaCrearCorrectamenteElEvento() {
        // arrange
        Boolean exigeCarnet = false;
        // act
        Evento evento = new EventoTestDataBuilder().conCarnet(exigeCarnet).build();
        //assert
        assertEquals(100L, evento.getId());
        assertEquals("Evento100", evento.getNombre());
        assertEquals("Calle 100", evento.getDireccion());
        assertEquals(5000D, evento.getValorEntrada());
        assertEquals(50L, evento.getNumeroBoletas());
        assertEquals(exigeCarnet, evento.getExigeCarnet());
        assertEquals(LocalDate.now(), evento.getFechaInicio());
        assertEquals(LocalDate.now().plusDays(1), evento.getFechaCierre());
    }

    @Test
    @DisplayName("Deberia fallar al crear el evento")
    void deberiaFallarSinValorEntradaDelEvento() {

        // act
        EventoTestDataBuilder eventoTestDataBuilder = new EventoTestDataBuilder().conValorEntrada(null);
        //assert
        BasePrueba.assertThrows(() ->{
            eventoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Se debe ingresar el valor de la entrada");
    }
}