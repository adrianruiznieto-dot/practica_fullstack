package es.ediae.master.programacion.gestionusuario.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false)
    private String nickUsuario;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String contrasena;
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(name = "direccion", nullable = false)
    private String direccion;

    

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

    @ManyToOne
    @JoinColumn(name = "puesto_trabajo_id")
    private PuestoDeTrabajoEntity puestoTrabajo;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDateTime getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public GeneroEntity getGenero() {
        return this.genero;
    }

    public void setGenero(GeneroEntity genero) {
        this.genero = genero;
    }

    public PuestoDeTrabajoEntity getPuestoTrabajo() {
        return this.puestoTrabajo;
    }

    public void setPuestoTrabajo(PuestoDeTrabajoEntity puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public void setGenero(Object genero) {
        throw new UnsupportedOperationException("Unimplemented method 'setGenero'");
    }

    public String getNickUsuario() {
        throw new UnsupportedOperationException("Unimplemented method 'getNickUsuario'");
    }

    public void setNickUsuario(String nickUsuario2) {
        throw new UnsupportedOperationException("Unimplemented method 'setNickUsuario'");
    }

    public Object getFechaNacimiento() {
        throw new UnsupportedOperationException("Unimplemented method 'getFechaNacimiento'");
    }

    public void setFechaNacimiento(Object fechaNacimiento) {
        throw new UnsupportedOperationException("Unimplemented method 'setFechaNacimiento'");
    }

    public Object getHoraDesayuno() {
        throw new UnsupportedOperationException("Unimplemented method 'getHoraDesayuno'");
    }

    public void setHoraDesayuno(Object horaDesayuno) {
        throw new UnsupportedOperationException("Unimplemented method 'setHoraDesayuno'");
    }
   




}
