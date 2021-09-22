package com.tpdan.msproductos.controller;

import com.tpdan.msproductos.model.Producto;
import com.tpdan.msproductos.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> buscarTodos(@RequestParam(required = false) List<Integer>ids){
        return ResponseEntity.ok(productoService.buscarTodos(ids));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Integer id){
        return ResponseEntity.of(productoService.buscarProductoPorId(id));
    }

    @GetMapping("/producto")
    public ResponseEntity<List<Producto>> buscarProdcuto(@RequestParam(required = false) String nombre, @RequestParam(required = false) Integer stock, @RequestParam(required = false) Double precio){
        return ResponseEntity.of(productoService.buscarProductos(nombre, stock, precio));
    }

    @GetMapping("/sin-stock")
    public ResponseEntity<List<Producto>> buscarProductosSinStock(@RequestParam List<Integer> ids, @RequestParam List<Integer> cantidades){
        return ResponseEntity.ok(productoService.buscarProductosSinStock(ids, cantidades));
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.actualizarProducto(producto));
    }
}
