package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;

@Service
public class DireccionService {
    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }
    public List<DireccionEntity> obtenerDirecciones(Integer usuarioId) {
        return direccionRepository.findByUsuarioId(usuarioId);
    }
    public DireccionEntity obtenerDireccion(Integer id) {
        return direccionRepository.findById(id).orElse(null);
    }
    public DireccionEntity crearDireccion(DireccionEntity direccion) {
        return direccionRepository.save(direccion);
    }
    public DireccionEntity actualizarDireccion(Integer id, DireccionEntity direccionActualizada) {
        DireccionEntity direccionExistente = direccionRepository.findById(id).orElse(null);
        if (direccionExistente != null) {
            direccionExistente.setNombreCalle(direccionActualizada.getNombreCalle());
            direccionExistente.setNumeroCalle(direccionActualizada.getNumeroCalle());
            direccionExistente.setUsuario(direccionActualizada.getUsuario());
            
            return direccionRepository.save(direccionExistente);
        }
        return null;
    }
    public void eliminarDireccion(Integer id) {
        direccionRepository.deleteById(id);
    }

}
