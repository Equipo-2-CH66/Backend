package org.generation.ALMIUX.controller;

import org.generation.ALMIUX.model.Product;
import org.generation.ALMIUX.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/products")
@CrossOrigin(origins = "*") //N Nueva línea que no se qué hace
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Mapeo de GetProducts
    @GetMapping("/products")
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){

        return ResponseEntity.ok(
                productService.getProductById(id)
        );
    }

    // Mapeo de CreateProduct
    @PostMapping("/create-product")
    public ResponseEntity<?> createProduct(@RequestBody Product newProduct){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(newProduct));
    }


}
