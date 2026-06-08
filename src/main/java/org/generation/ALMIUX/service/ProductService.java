package org.generation.ALMIUX.service;

import org.generation.ALMIUX.exceptions.ProductNotFoundException;
import org.generation.ALMIUX.model.Product;
import org.generation.ALMIUX.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Obtener todos los productos
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Obtener producto por ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    // Crear un nuevo producto
    @Transactional
    public Product createProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    // Actualizar un producto existente por ID
    @Transactional
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setCategoria(product.getCategoria()); // * Actualiza la categoría (relación FK nueva del diagrama ER)
                    existing.setNombre(product.getNombre()); // * Usa setNombre en lugar del anterior setProductname
                    existing.setDescripcion(product.getDescripcion()); // * Usa setDescripcion en lugar del anterior setDescription
                    existing.setIcono(product.getIcono()); // * Usa setIcono en lugar del anterior setImageUrl
                    existing.setPrecio(product.getPrecio()); // * Usa setPrecio en lugar del anterior setProductprice
                    existing.setEnOferta(product.getEnOferta());
                    existing.setDescuentoPct(product.getDescuentoPct());
                    existing.setPrecioFinal(product.getPrecioFinal());
                    existing.setActivo(product.getActivo());
                    return productRepository.save(existing);
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    // Eliminar un producto por ID
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
