package com.petadopt.service;

import com.petadopt.domain.Adoptante;
import com.petadopt.domain.Mascota;
import com.petadopt.domain.SolicitudAdopcion;
import com.petadopt.repository.AdoptanteRepo;
import com.petadopt.repository.MascotaRepo;
import com.petadopt.repository.SolicitudAdopcionRepo;

public class MascotaService {
    
    private final MascotaRepo mascotaRepo;
    private final AdoptanteRepo adoptanteRepo;
    private final SolicitudAdopcionRepo solicitudAdopcionRepo;

    public MascotaService(MascotaRepo mascotaRepo, AdoptanteRepo adoptanteRepo, SolicitudAdopcionRepo solicitudAdopcionRepo) {
        this.mascotaRepo = mascotaRepo;
        this.adoptanteRepo = adoptanteRepo;
        this.solicitudAdopcionRepo = solicitudAdopcionRepo;
    }




    public SolicitudAdopcion procesarSolicitudAdopcion(int idMascota, int idAdoptante){

        //.stream funciona para convertir una lista en un flujo de datos
        //lo que permite aplicar operaciones de filtrado, mapeo y reducción en los elementos de la lista
        

        Mascota mascota = mascotaRepo.findById(idMascota).stream().findFirst().orElse(null);

        Adoptante adoptante = adoptanteRepo.findById((int) idAdoptante).stream().findFirst().orElse(null);
       


        //validaciones

        if(adoptante.getEdad() <= 17){
            throw new IllegalArgumentException("El adoptante debe ser mayor de edad");
        }

        if(!mascota.isDisponible()){
            throw new IllegalArgumentException("La mascota no está disponible para adopción");
        }
        // 2 reglas de negocio

        mascota.setDisponible(false);
        mascotaRepo.save(mascota);

        SolicitudAdopcion solicitudAdopcion = new SolicitudAdopcion(mascota, adoptante);
        solicitudAdopcion.setEstado("APROBADA");

        return solicitudAdopcionRepo.save(solicitudAdopcion);


        //despues de esta nos dirigimos al test de service 
        
    }
}
