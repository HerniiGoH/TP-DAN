package com.tpdan.msusuarios.controller;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Cliente;
import com.tpdan.msusuarios.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this. clienteService = clienteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> buscarTodos(@RequestParam(required = false) List<Integer>ids){
        return ResponseEntity.ok(clienteService.buscarTodos(ids));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id){
        return ResponseEntity.of(clienteService.buscarClientePorId(id));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> buscarCliente(@RequestParam(required = false, name="id") Integer id, @RequestParam(required = false, name="cuit") String cuit, @RequestParam(required = false, name = "razonSocial") String razonSocial, @RequestParam(required = false, name = "mail") String mail, @RequestParam(required = false, name = "maxCuentaCorriente") Double maxCuentaCorriente, @RequestParam(required = false, name = "habilitadoOnline") Boolean habilitadoOnline){
        return ResponseEntity.of(clienteService.buscarCliente(id, cuit, razonSocial, mail, maxCuentaCorriente, habilitadoOnline));
    }

    @GetMapping("/obra")
    public ResponseEntity<Cliente> buscarClientePorIdObra(@RequestParam(required = false) Integer idObra){
        return ResponseEntity.ok(clienteService.buscarClientePorIdObra(idObra));
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) throws BusinessRuleException {
        return new ResponseEntity<>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente nuevoCliente){
        return new ResponseEntity<>(clienteService.actualizarCliente(nuevoCliente), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus eliminarClientePorId(@PathVariable Integer id) throws BusinessRuleException {
        clienteService.borrarCliente(id);
        return HttpStatus.NO_CONTENT;
    }
}
