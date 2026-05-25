package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioServices;

@Service
public class UsuarioService implements IUsuarioServices {
    private final UsuarioRepository usuarioRepository;
    private final GeneroRepository generoRepository;
    private final PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            GeneroRepository generoRepository,
            PuestoDeTrabajoRepository puestoDeTrabajoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.generoRepository = generoRepository;
        this.puestoDeTrabajoRepository = puestoDeTrabajoRepository;
    }

    @Override
    public List<UsuarioEntity> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> iniciarSesion(String nickUsuario, String contrasena) {
        return usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);
    }

    @Override
    public Optional<UsuarioEntity> obtenerUsuario(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public UsuarioEntity crearUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Optional<UsuarioEntity> actualizarUsuario(Integer id, UsuarioEntity usuarioActualizado) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNickUsuario(usuarioActualizado.getNickUsuario());
                    usuarioExistente.setContrasena(usuarioActualizado.getContrasena());
                    usuarioExistente.setGenero(usuarioActualizado.getGenero());
                    usuarioExistente.setNombre(usuarioActualizado.getNombre());
                    usuarioExistente.setApellido(usuarioActualizado.getApellido());
                    usuarioExistente.setEmail(usuarioActualizado.getEmail());
                    usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
                    usuarioExistente.setPuestoTrabajo(usuarioActualizado.getPuestoTrabajo());
                    return usuarioRepository.save(usuarioExistente);
                });
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
    public Optional<DireccionEntity> obtenerDireccion(Integer id) {
        return Optional.empty();
    }

    

    
}
