package com.petadopt.repository;

import java.util.List;

import com.petadopt.domain.Mascota;

public interface MascotaRepo {

    List<Mascota> findAll();
    List <Mascota> findById(int id);

    Mascota save(Mascota mascota);
    
}
