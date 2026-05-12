package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ValidationController {
    @PostMapping("/producto")
    public ResponseEntity<Object> crearProducto(@RequestBody ProductoDTO productoDTO) {
        if (productoDTO.getId() == null || productoDTO.getId() == 0) {
            return ResponseEntity.badRequest().body("El ID del producto no puede ser 0");
        }
        return ResponseEntity.ok(productoDTO);
    }
}
