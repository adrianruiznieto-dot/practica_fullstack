package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionService;
import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*",
        methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
                org.springframework.web.bind.annotation.RequestMethod.POST,
                org.springframework.web.bind.annotation.RequestMethod.PUT,
                org.springframework.web.bind.annotation.RequestMethod.PATCH,
                org.springframework.web.bind.annotation.RequestMethod.DELETE }
)
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final DireccionService direccionService;
    private final GeneroRepository generoRepository;
    private final PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    public UsuarioController(
            UsuarioService usuarioService,
            UsuarioRepository usuarioRepository,
            DireccionService direccionService,
            GeneroRepository generoRepository,
            PuestoDeTrabajoRepository puestoDeTrabajoRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
        this.direccionService = direccionService;
        this.generoRepository = generoRepository;
        this.puestoDeTrabajoRepository = puestoDeTrabajoRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return usuarioService.iniciarSesion(loginRequest.nickUsuario(), loginRequest.contrasena())
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("mensaje", "Usuario o contrasena incorrectos")));
    }

    @GetMapping
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/generos")
    public List<GeneroEntity> obtenerGeneros() {
        return generoRepository.findAll();
    }

    @GetMapping("/puestos-trabajo")
    public List<PuestoDeTrabajoEntity> obtenerPuestosDeTrabajo() {
        return puestoDeTrabajoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> obtenerUsuario(@PathVariable Integer id) {
        return usuarioService.obtenerUsuario(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Object> crearUsuario(@RequestBody UsuarioEntity usuario) {
        if (usuarioRepository.existsByNickUsuario(usuario.getNickUsuario())) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "El nombre de usuario ya existe"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody UsuarioEntity usuario) {
        return usuarioService.actualizarUsuario(id, usuario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    public record LoginRequest(String nickUsuario, String contrasena) {
    }

    @GetMapping("/{usuarioId}/direcciones")
    public ResponseEntity<List<DireccionEntity>> obtenerDirecciones(@PathVariable Integer usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccionService.obtenerDirecciones(usuarioId));
    }

    @GetMapping("/{usuarioId}/direcciones/{direccionId}")
    public ResponseEntity<DireccionEntity> obtenerDireccion(
            @PathVariable Integer usuarioId,
            @PathVariable Integer direccionId) {
        DireccionEntity direccion = direccionService.obtenerDireccion(direccionId);
        if (direccion == null || !direccion.getUsuario().getId().equals(usuarioId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccion);
    }

    @PostMapping("/{usuarioId}/direcciones")
    public ResponseEntity<DireccionEntity> crearDireccion(
            @PathVariable Integer usuarioId,
            @RequestBody DireccionEntity direccion) {
        return usuarioService.obtenerUsuario(usuarioId)
                .map(usuario -> {
                    direccion.setUsuario(usuario);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(direccionService.crearDireccion(direccion));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{usuarioId}/direcciones/{direccionId}")
    public ResponseEntity<Void> eliminarDireccion(
            @PathVariable Integer usuarioId,
            @PathVariable Integer direccionId) {
        DireccionEntity direccion = direccionService.obtenerDireccion(direccionId);
        if (direccion == null || !direccion.getUsuario().getId().equals(usuarioId)) {
            return ResponseEntity.notFound().build();
        }
        direccionService.eliminarDireccion(direccionId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{usuarioId}/direcciones/{direccionId}")
    public ResponseEntity<DireccionEntity> actualizarDireccion(
            @PathVariable Integer usuarioId,
            @PathVariable Integer direccionId,
            @RequestBody DireccionEntity direccionActualizada) {
        DireccionEntity direccionExistente = direccionService.obtenerDireccion(direccionId);
        if (direccionExistente == null || !direccionExistente.getUsuario().getId().equals(usuarioId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccionService.crearDireccion(direccionExistente));
    }
    
}
