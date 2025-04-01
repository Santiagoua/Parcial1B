package com.miempresa.productos.controller;

import com.miempresa.productos.modelo.Producto;
import com.miempresa.productos.repositorio.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    private final ProductoRepository ProductRepository;

    public ProductController(ProductoRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

    @GetMapping
    public List<Producto> getAllProducts(@RequestParam(defaultValue = "es") String lang) {
        List<Producto> products = ProductRepository.findAll();
        return products;
    }

    @PostMapping
    public Producto addProduct(@RequestBody Producto product) {
        return ProductRepository.save(product);
    }
}
