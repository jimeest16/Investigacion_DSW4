package com.petadopt.domain;


import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private int id;
    private String nombre;
    private String especie;
    private boolean disponible;
    private Refugio refugio;
    private List<HistorialMedico> historialesMedicos = new ArrayList<>();

    public Mascota() {}

    public Mascota(int id, String nombre, String especie, boolean disponible, Refugio refugio) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.disponible = disponible;
        this.refugio = refugio;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public Refugio getRefugio() { return refugio; }
    public void setRefugio(Refugio refugio) { this.refugio = refugio; }

    public List<HistorialMedico> getHistorialesMedicos() { return historialesMedicos; }
    public void setHistorialesMedicos(List<HistorialMedico> historialesMedicos) { this.historialesMedicos = historialesMedicos; }

    public void agregarHistorialMedico(HistorialMedico historial) {
        this.historialesMedicos.add(historial);
    }
}