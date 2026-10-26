package com.petadopt.domain;


import java.time.LocalDate;

public class SolicitudAdopcion {
    private int id;
    private Mascota mascota;
    private Adoptante adoptante;
    private LocalDate fechaSolicitud;
    private String estado;

    public SolicitudAdopcion() {}


    
    public SolicitudAdopcion(Mascota mascota, Adoptante adoptante) {
        this.mascota = mascota;
        this.adoptante = adoptante;
    }



    public SolicitudAdopcion(int id, Mascota mascota, Adoptante adoptante) {
        this.id = id;
        this.mascota = mascota;
        this.adoptante = adoptante;
        this.fechaSolicitud = LocalDate.now();
        this.estado = "PENDIENTE";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }

    public Adoptante getAdoptante() { return adoptante; }
    public void setAdoptante(Adoptante adoptante) { this.adoptante = adoptante; }

    public LocalDate getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDate fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}