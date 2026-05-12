package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "direccion")
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_calle", nullable = false)
    private String nombreCalle;
    @Column(name = "numero_calle", nullable = false)
    private String numeroCalle;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "direccion_principal")
    private Boolean direccionPrincipal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }
    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }
    public String getNumeroCalle() {
        return numeroCalle;
    }
    public void setNumeroCalle(String numeroCalle) {
        this.numeroCalle = numeroCalle;
    }
    public UsuarioEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    public Boolean getDireccionPrincipal() {
        return direccionPrincipal;
    }
    public void setDireccionPrincipal(Boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }
    


}
