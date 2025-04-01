package com.miempresa.productos.repositorio;

import com.miempresa.productos.modelo.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {
}
