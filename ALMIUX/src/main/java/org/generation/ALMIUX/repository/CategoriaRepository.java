package org.generation.ALMIUX.repository;

import org.generation.ALMIUX.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Buscar categoría por nombre
    Categoria findByNombre(String nombre);

    // Validar si existe una categoría con un slug específico
    boolean existsBySlug(String slug);
}
