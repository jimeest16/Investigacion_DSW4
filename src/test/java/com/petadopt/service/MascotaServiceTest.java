package com.petadopt.service;


import com.petadopt.domain.Adoptante;
import com.petadopt.domain.Mascota;
import com.petadopt.domain.Refugio;
import com.petadopt.domain.SolicitudAdopcion;
import com.petadopt.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MascotaServiceTest {

    // --- CONFIGURACIÓN DE AISLAMIENTO Y MOCKS ---
    @Mock private MascotaRepo mascotaRepository;
    @Mock private AdoptanteRepo adoptanteRepository;
    @Mock private SolicitudAdopcionRepo solicitudRepository;

    @InjectMocks
    private MascotaService mascotaService;

    //SOLUCIÓN EJERCICIO 1
    @Test
    @DisplayName("Procesar solicitud exitosa")

    void procesarSolicitudAdopcion_Exitoso() {
        // ARRANGE: prepara los datos de prueba
        Refugio refugioMock = new Refugio(100, "Refugio Cartago", "Cartago", "25500000");
        Mascota mascotaMock = new Mascota(1, "Firulais", "Perro", true, refugioMock);
        Adoptante adoptanteMock = new Adoptante(10, "Jimena", 22, "118230495");


//when funciona para definir el comportamiento simulado de los métodos del repositorio
//cuando .....
        when(mascotaRepository.findById(1)).thenReturn(List.of(mascotaMock));
        when(adoptanteRepository.findById(10)).thenReturn(List.of(adoptanteMock));
        when(solicitudRepository.save(any(SolicitudAdopcion.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        //  ACT 
        SolicitudAdopcion resultado = mascotaService.procesarSolicitudAdopcion(1, 10);



        // ASSERT
        assertNotNull(resultado, "La solicitud retornada no debe ser nula.");
        assertEquals("APROBADA", resultado.getEstado(), "El estado debe ser APROBADA.");
        assertFalse(mascotaMock.isDisponible(), "La mascota debió cambiar su estado a NO disponible.");



        //verify es una función de Mockito que permite verificar que ciertos métodos
        //  hayan sido llamados en los mocks durante la ejecución del test
        verify(mascotaRepository, times(1)).save(mascotaMock);
        verify(solicitudRepository, times(1)).save(any(SolicitudAdopcion.class));
    }



    //SOLUCIÓN EJERCICIO 2
    @Test
    @DisplayName(" Lanza excepción si el adoptante es menor de edad")
    void procesarSolicitudAdopcion_MenorDeEdad_LanzaExcepcion() {
       
        //ARRANGE
        Refugio refugioMock = new Refugio(100, "Refugio Cartago", "Cartago", "25500000");
        Mascota mascotaMock = new Mascota(1, "Tobby", "Perro", true, refugioMock);
        Adoptante menorMock = new Adoptante(11, "Alejandro", 16, "208390123");


        when(mascotaRepository.findById(1)).thenReturn(List.of(mascotaMock));
        when(adoptanteRepository.findById(11)).thenReturn(List.of(menorMock));


        // ACT & ASSERT 
        assertThrows(IllegalArgumentException.class, () -> {
            mascotaService.procesarSolicitudAdopcion(1, 11);

        }, "Si el adoptante es menor de 18 años, no puede solicitar una mascota.");

        // verifica si los 2 meotods nunca se llamaron 
        verify(solicitudRepository, never()).save(any());
        verify(mascotaRepository, never()).save(any());
    }
}