package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_genero", nullable = false)
    private String nombreGenero;

    public String getNombreGenero() {
        return nombreGenero;
    }
    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

}
