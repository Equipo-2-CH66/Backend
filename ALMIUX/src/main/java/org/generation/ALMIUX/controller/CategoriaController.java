package org.generation.ALMIUX.controller;

import org.generation.ALMIUX.model.Categoria;
import org.generation.ALMIUX.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/categorias")
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier frontend
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Obtener todas las categorías
    @GetMapping
    public List<Categoria> getCategorias(){
        return categoriaService.getCategorias();
    }

    // Obtener categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id){
        Categoria categoria = categoriaService.getCategoriaById(id);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    // Crear nueva categoría
    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria nuevaCategoria){
        Categoria savedCategoria = categoriaService.createCategoria(nuevaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoria);
    }

    // Actualizar categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        Categoria existente = categoriaService.getCategoriaById(id);
        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        categoria.setId(id);
        return ResponseEntity.ok(categoriaService.updateCategoria(id, categoria));
    }

    // Eliminar categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
