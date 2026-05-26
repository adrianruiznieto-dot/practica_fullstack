package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;

@RestController
@RequestMapping("/api/catalogos")
@CrossOrigin(origins = "*", allowedHeaders = "*",
        methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
                org.springframework.web.bind.annotation.RequestMethod.POST,
                org.springframework.web.bind.annotation.RequestMethod.PUT,
                org.springframework.web.bind.annotation.RequestMethod.DELETE }
        

)
public class CatalogoController {
    private final GeneroRepository generoRepository;
    private final PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    public CatalogoController(
            GeneroRepository generoRepository,
            PuestoDeTrabajoRepository puestoDeTrabajoRepository) {
        this.generoRepository = generoRepository;
        this.puestoDeTrabajoRepository = puestoDeTrabajoRepository;
    }

    @GetMapping("/generos")
    public List<GeneroEntity> listarGeneros() {
        return generoRepository.findAll();
    }

    @GetMapping("/puestos-trabajo")
    public List<PuestoDeTrabajoEntity> listarPuestosTrabajo() {
        return puestoDeTrabajoRepository.findAll();
    }
}
