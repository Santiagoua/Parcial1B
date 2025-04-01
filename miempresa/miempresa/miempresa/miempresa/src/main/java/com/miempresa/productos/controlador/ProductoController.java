package com.miempresa.productos.controlador;

import com.miempresa.productos.modelo.Producto;
import com.miempresa.productos.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Listar todos los productos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable String id) {
        return productoRepository.findById(id);
    }

    // Crear un nuevo producto
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable String id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable String id) {
        productoRepository.deleteById(id);
    }
}
