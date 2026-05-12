package es.ediae.master.programacion.gestionusuario.repository;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer> {
    List<DireccionEntity> findByUsuarioId(Integer usuarioId);
}
