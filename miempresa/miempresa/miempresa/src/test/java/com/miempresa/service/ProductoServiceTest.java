package com.miempresa.productos.service;

import com.miempresa.productos.model.Producto;
import com.miempresa.productos.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void testListarProductos() {
        Producto producto1 = new Producto("1", "Laptop", 1500.0);
        Producto producto2 = new Producto("2", "Smartphone", 800.0);

        when(productoRepository.findAll()).thenReturn(Flux.just(producto1, producto2));

        Flux<Producto> resultado = productoService.listarProductos();

        StepVerifier.create(resultado)
                .expectNext(producto1)
                .expectNext(producto2)
                .verifyComplete();

        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void testObtenerProductoPorId() {
        Producto producto = new Producto("1", "Laptop", 1500.0);

        when(productoRepository.findById("1")).thenReturn(Mono.just(producto));

        Mono<Producto> resultado = productoService.obtenerProductoPorId("1");

        StepVerifier.create(resultado)
                .expectNextMatches(p -> p.getNombre().equals("Laptop"))
                .verifyComplete();

        verify(productoRepository, times(1)).findById("1");
    }

    @Test
    void testCrearProducto() {
        Producto producto = new Producto("1", "Tablet", 500.0);

        when(productoRepository.save(any(Producto.class))).thenReturn(Mono.just(producto));

        Mono<Producto> resultado = productoService.crearProducto(producto);

        StepVerifier.create(resultado)
                .expectNextMatches(p -> p.getNombre().equals("Tablet") && p.getPrecio() == 500.0)
                .verifyComplete();

        verify(productoRepository, times(1)).save(producto);
    }
}
