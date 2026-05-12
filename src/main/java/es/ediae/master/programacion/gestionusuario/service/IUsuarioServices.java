package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;
import java.util.Optional;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

public interface IUsuarioServices {
    List<UsuarioEntity> obtenerUsuarios();
    Optional<UsuarioEntity> iniciarSesion(String nickUsuario, String contrasena);
    Optional<UsuarioEntity> obtenerUsuario(Integer id);
    UsuarioEntity crearUsuario(UsuarioEntity usuario);
    Optional<UsuarioEntity> actualizarUsuario(Integer id, UsuarioEntity usuarioActualizado);
    void eliminarUsuario(Integer id);
}
