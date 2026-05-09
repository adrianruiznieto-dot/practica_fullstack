package es.ediae.master.programacion.gestionusuario.service.impl;

import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;

@Service
public class DireccionService {
    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

}
