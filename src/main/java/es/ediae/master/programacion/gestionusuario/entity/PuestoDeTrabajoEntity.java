package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class PuestoDeTrabajoEntity {
    @Id
    private Integer id;
    @Column(name = "nombre_puesto", nullable = false)
    private String nombrePuesto;
    public String getNombrePuesto() {
        return nombrePuesto;
    } 
    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }



}
