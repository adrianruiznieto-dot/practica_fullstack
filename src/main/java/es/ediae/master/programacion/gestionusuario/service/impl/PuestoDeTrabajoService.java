package es.ediae.master.programacion.gestionusuario.service.impl;

import org.springframework.stereotype.Service;

@Service

public class PuestoDeTrabajoService {
    public static final String PUESTO_DESARROLLADOR = "Desarrollador";
    public static final String PUESTO_ANALISTA = "Analista";
    public static final String PUESTO_GERENTE = "Gerente";
    public String obtenerPuestoDeTrabajo(String puesto) {
        if (PUESTO_DESARROLLADOR.equalsIgnoreCase(puesto)) {
            return PUESTO_DESARROLLADOR;
        } else if (PUESTO_ANALISTA.equalsIgnoreCase(puesto)) {
            return PUESTO_ANALISTA;
        } else if (PUESTO_GERENTE.equalsIgnoreCase(puesto)) {
            return PUESTO_GERENTE;
        }
        return null; 
    }

}
