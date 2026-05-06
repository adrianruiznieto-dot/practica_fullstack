package es.ediae.master.programacion.gestionusuario.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import jakarta.persistence.Id;

@Controller
public class UsuarioController {
    @Id
    private Integer id;
    private String nick_usuario;
    private String contraseña;
    private LocalDateTime fecha_nacimiento;
    private String genero;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private LocalDateTime fecha_hora_creacion;
    private String hora_desayuno;
    private PuestoDeTrabajoEntity puestoDeTrabajo;
    public LocalDateTime getFecha_hora_creacion() {
        return fecha_hora_creacion;
        
    }
    public PuestoDeTrabajoEntity getPuestoDeTrabajo() {
        return puestoDeTrabajo;
        
    }
    public void setPuestoDeTrabajo(PuestoDeTrabajoEntity puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
        
    }
    public String getSegundo_apellido() {
        return segundo_apellido;
        
    }
    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
        
    }
    public String getPrimer_apellido() {
        return primer_apellido;
        
    }
    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
        
    }
    public String getNombre() {
        return nombre;
        
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
        
    }
    public String getGenero() {
        return genero;
        
    }
    public void setGenero(String genero) {
        this.genero = genero;
        
    }
    public String getContraseña() {
        return contraseña;
        
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
        
    }
    public String getNick_usuario() {
        return nick_usuario;
        
    }
    public void setNick_usuario(String nick_usuario) {
        this.nick_usuario = nick_usuario;
        
    }
    public String getHora_desayuno() {
        return hora_desayuno;
        
    }
    public void setHora_desayuno(String hora_desayuno) {
        this.hora_desayuno = hora_desayuno;
        
    }
    public LocalDateTime getFecha_nacimiento() {
        return fecha_nacimiento;
        
    }
    public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
        
    }
    public void setFecha_hora_creacion(LocalDateTime fecha_hora_creacion) {
        this.fecha_hora_creacion = fecha_hora_creacion;
        
    }

    
   

}
