package com.petadopt.domain;

public class HistorialMedico{

    private int id;
    private String diagnostico;
    private String tratamiento;
    private String fechaAtencion;

    public HistorialMedico() {
    }
    public HistorialMedico(int id, String diagnostico, String tratamiento, String fechaAtencion) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fechaAtencion = fechaAtencion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    public String getFechaAtencion() {
        return fechaAtencion;
    }
    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    
}