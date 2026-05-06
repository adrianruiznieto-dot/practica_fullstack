package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.stereotype.Controller;

import jakarta.validation.constraints.NotEmpty;
public class ProductoDTO {
    private Integer id;
    
    
    @NotEmpty(message = "El nombre del producto no puede estar vacío")
    private String nombreProducto;
    
    @NotEmpty(message = "La descripción del producto no puede estar vacía")
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    


}
