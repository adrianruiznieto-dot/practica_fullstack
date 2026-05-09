package es.ediae.master.programacion.gestionusuario.service.impl;

import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    public static final String GENERO_MASCULINO = "Masculino";
    public static final String GENERO_FEMENINO = "Femenino";

    public boolean esGeneroValido(String genero) {
        return GENERO_MASCULINO.equalsIgnoreCase(genero) || GENERO_FEMENINO.equalsIgnoreCase(genero);   
    }

    }


