package org.generation.ALMIUX.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String slug;

    @Column(name = "icono", nullable = false)
    private String icono;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    // --- Constructores ---
    public Categoria() {}

    public Categoria(Long id, String nombre, String slug, String icono, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.slug = slug;
        this.icono = icono;
        this.descripcion = descripcion;
    }

    // --- Getters y Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", slug='" + slug + '\'' +
                ", icono='" + icono + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
