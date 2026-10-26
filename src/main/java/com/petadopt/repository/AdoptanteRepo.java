package com.petadopt.repository;

import java.util.List;

import com.petadopt.domain.Adoptante;

public interface AdoptanteRepo {
    List<Adoptante> findById(int id);
}