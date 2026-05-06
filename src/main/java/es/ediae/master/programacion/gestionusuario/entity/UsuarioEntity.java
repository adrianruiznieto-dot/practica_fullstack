package es.ediae.master.programacion.gestionusuario.entity;

import java.sql.Time;
import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nick_usuario", nullable = false)
    private String nickUsuario;
    @Column(name = "fecha_hora_creacion", nullable = false)
    private LocalDateTime fechaHoraCreacion;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;
    @Column(name = "segundo_apellido", nullable = true)
    private String segundoApellido;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;
    @Column(name = "hora_desayuno", nullable = true)
    private Time horaDesayuno;


    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
     private GeneroEntity genero;

    public String getNickUsuario () {
        return nickUsuario;
     }
    public void setNickUsuario(String nickUsuario) {
            this.nickUsuario = nickUsuario;
        }
    public LocalDateTime getFechaHoraCreacion() {
            return fechaHoraCreacion;
        }
    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
            this.fechaHoraCreacion = fechaHoraCreacion;
        }
    public String getNombre() {
            return nombre;
        }
    public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    public String getPrimerApellido() {
            return primerApellido;
        }
    public void setPrimerApellido(String primerApellido) {
            this.primerApellido = primerApellido;
        }
        
    public String getSegundoApellido() {
            return segundoApellido;
        }
    public void setSegundoApellido(String segundoApellido) {
            this.segundoApellido = segundoApellido;
        }
    public LocalDateTime getFechaNacimiento() {
            return fechaNacimiento;
        }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }
    public Time getHoraDesayuno() {
            return horaDesayuno;
        }
    public void setHoraDesayuno(Time horaDesayuno) {
            this.horaDesayuno = horaDesayuno;
        }
   




}
