package org.generation.ALMIUX.service;

import org.generation.ALMIUX.model.Product;
import org.generation.ALMIUX.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // Método para obtener productos
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    // Método para crear productos
    public Product createProduct(Product newProduct){
        return productRepository.save(newProduct);
    }


}
