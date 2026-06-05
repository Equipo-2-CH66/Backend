package org.generation.ALMIUX.service;

import org.generation.ALMIUX.model.Categoria;
import org.generation.ALMIUX.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    // Obtener todas las categorías
    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }

    // Crear una nueva categoría
    public Categoria createCategoria(Categoria nuevaCategoria){
        return categoriaRepository.save(nuevaCategoria);
    }

    // Buscar categoría por ID
    public Categoria getCategoriaById(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    // Buscar categoría por nombre
    public Categoria getCategoriaByNombre(String nombre){
        return categoriaRepository.findByNombre(nombre);
    }

    // Actualizar categoría existente
    public Categoria updateCategoria(Long id, Categoria categoria){
        Categoria existente = getCategoriaById(id);
        if(existente == null){
            return null;
        }
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    // Eliminar categoría
    public void deleteCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
