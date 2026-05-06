package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class UsuarioServices {


  
    private static final List<UsuarioDto> USUARIOS = new ArrayList<>();

   

    public boolean iniciarSesion(String nickUsuario, String contraseña) {
        if (nickUsuario == null || contraseña == null) {
            return false;
        }
        return USUARIOS.stream()
                .anyMatch(usuario -> usuario.nickUsuario().equals(nickUsuario)
                        && usuario.contraseña().equals(contraseña));
    }

    public List<UsuarioDto> obtenerUsuarios() {
        return new ArrayList<>(USUARIOS);
    }

    public UsuarioDto obtenerUsuario(int id) {
        return USUARIOS.stream()
                .filter(usuario -> usuario.id() == id)
                .findFirst()
                .orElse(null);
    }

    public UsuarioDto crearUsuario(UsuarioDto usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDto usuarioCreado = new UsuarioDto(
                new AtomicInteger(1).getAndIncrement(),
                usuario.nickUsuario(),
                usuario.contraseña(),
                usuario.genero(),
                usuario.nombre(),
                usuario.primerApellido(),
                usuario.segundoApellido(),
                usuario.horaDesayuno(),
                usuario.puestoDeTrabajo()
        );

        USUARIOS.add(usuarioCreado);
        return usuarioCreado;
    }

    public UsuarioDto actualizarUsuario(int id, UsuarioDto usuarioActualizado) {
        if (usuarioActualizado == null) {
            return null;
        }

        for (int i = 0; i < USUARIOS.size(); i++) {
            if (USUARIOS.get(i).id() == id) {
                UsuarioDto actualizado = new UsuarioDto(
                        id,
                        usuarioActualizado.nickUsuario(),
                        usuarioActualizado.contraseña(),
                        usuarioActualizado.genero(),
                        usuarioActualizado.nombre(),
                        usuarioActualizado.primerApellido(),
                        usuarioActualizado.segundoApellido(),
                        usuarioActualizado.horaDesayuno(),
                        usuarioActualizado.puestoDeTrabajo()
                );
                USUARIOS.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }

    public boolean eliminarUsuario(int id) {
        return USUARIOS.removeIf(usuario -> usuario.id() == id);
    }

    public static record UsuarioDto(
            int id,
            String nickUsuario,
            String contraseña,
            String genero,
            String nombre,
            String primerApellido,
            String segundoApellido,
            String horaDesayuno,
            PuestoDeTrabajoInfo puestoDeTrabajo
    ) {
    }

    public static record PuestoDeTrabajoInfo(int id, String nombre) {
    }
}
