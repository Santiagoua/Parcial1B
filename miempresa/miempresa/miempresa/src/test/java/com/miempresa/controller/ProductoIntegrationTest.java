package com.miempresa.productos.controller;

import com.miempresa.productos.model.Producto;
import com.miempresa.productos.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@AutoConfigureWebTestClient
public class ProductoIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ProductoRepository productoRepository;

    @BeforeEach
    void setUp() {
        productoRepository.deleteAll().block();
    }

    @Test
    void testCrearProducto() {
        Producto producto = new Producto(null, "Smartphone", 1200.0);

        webTestClient.post().uri("/api/productos")
                .contentType(APPLICATION_JSON)
                .body(Mono.just(producto), Producto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.nombre").isEqualTo("Smartphone")
                .jsonPath("$.precio").isEqualTo(1200.0);
    }

    @Test
    void testObtenerProductoPorId() {
        Producto producto = new Producto(null, "Monitor", 300.0);
        Producto productoGuardado = productoRepository.save(producto).block();

        webTestClient.get().uri("/api/productos/{id}", productoGuardado.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.nombre").isEqualTo("Monitor");
    }

    @Test
    void testEliminarProducto() {
        Producto producto = new Producto(null, "Mouse", 50.0);
        Producto productoGuardado = productoRepository.save(producto).block();

        webTestClient.delete().uri("/api/productos/{id}", productoGuardado.getId())
                .exchange()
                .expectStatus().isNoContent();
    }
}
