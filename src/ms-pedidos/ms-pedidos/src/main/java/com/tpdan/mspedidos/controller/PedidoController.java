package com.tpdan.mspedidos.controller;

import com.tpdan.mspedidos.model.DetallePedido;
import com.tpdan.mspedidos.model.Pedido;
import com.tpdan.mspedidos.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService=pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodos() {
        return ResponseEntity.ok(pedidoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Integer id) {
        return ResponseEntity.of(pedidoService.buscarPedidoPorId(id));
    }

    @GetMapping("/obra/{id}")
    public ResponseEntity<List<Pedido>> buscarPedidosPorIdObra(@PathVariable Integer id){
        return ResponseEntity.of(pedidoService.buscarPedidosPorIdObra(id));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Pedido>> buscarPedidosPorCliente(@RequestParam(required = false, name = "id") Integer id, @RequestParam(required = false, name = "cuit") String cuit){
        return ResponseEntity.of(pedidoService.buscarPedidosPorCliente(id, cuit));
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Pedido>> buscarPedidosPorEstado(@RequestParam(name = "estado") String estado){
        return ResponseEntity.of(pedidoService.buscarPedidosPorEstado(estado));
    }

    @GetMapping("/{idPedido}/detalle/{id}")
    public ResponseEntity<DetallePedido> buscarDetallePedidoPorId(@PathVariable Integer idPedido, @PathVariable Integer id){
        return ResponseEntity.of(pedidoService.buscarDetallePedidoPorId(idPedido, id));
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido nuevoPedido){
        //TODO hacer la correcta validacion
        if(nuevoPedido.getObra()!=null && nuevoPedido.getObraId()!=null && nuevoPedido.getDetallePedido()!=null && !nuevoPedido.getDetallePedido().isEmpty() && nuevoPedido.getDetallePedido().stream().allMatch(detallePedido -> detallePedido.getProductoId()!=null && detallePedido.getProducto()!=null && detallePedido.getCantidad()!=null)){
            return new ResponseEntity<>(pedidoService.crearPedido(nuevoPedido), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/{id}/detalle")
    public ResponseEntity<DetallePedido> crearDetallePedido(@RequestBody DetallePedido nuevoDetallePedido, @PathVariable Integer id){
        return new ResponseEntity<>(pedidoService.crearDetallePedido(nuevoDetallePedido, id), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pedido> actualizarPedido(@RequestBody Pedido nuevoPedido){
        return ResponseEntity.ok(pedidoService.actualizarPedido(nuevoPedido));
    }

    @PutMapping("/{idPedido}/detallePedido")
    public ResponseEntity<DetallePedido> actualizarDetallePedido(@RequestBody DetallePedido nuevoDetalle, @PathVariable Integer idPedido){
        return ResponseEntity.ok(pedidoService.actualizarDetallePedido(nuevoDetalle, idPedido));
    }

    @PatchMapping("/{id}/actualizar-estado")
    public ResponseEntity<Pedido> actualizarEstadoPedido(@PathVariable(name = "id") Integer id, @RequestParam(name = "estado") String estado){
        return ResponseEntity.of(pedidoService.actualizarEstadoPedido(id, estado));
    }

    @DeleteMapping("/{id}")
    public HttpStatus borrarPedido(@PathVariable Integer id){
        pedidoService.borrarPedido(id);
        return HttpStatus.NO_CONTENT;
    }

    @DeleteMapping("/{idPedido}/detalle/{id}")
    public HttpStatus borrarDetallePedido(@PathVariable Integer idPedido, @PathVariable Integer id){
        pedidoService.borrarDetallePedido(idPedido,id);
        return HttpStatus.NO_CONTENT;
    }
}
