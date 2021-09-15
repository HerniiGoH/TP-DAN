package com.tpdan.mspagos.rest;

import com.tpdan.mspagos.exceptions.BusinessRuleException;
import com.tpdan.mspagos.model.Pago;
import com.tpdan.mspagos.service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoRest {
    private final PagoService pagoService;

    public PagoRest(PagoService pagoService){
        this.pagoService=pagoService;
    }

    @GetMapping
    public ResponseEntity<List<Pago>> buscarTodos() throws BusinessRuleException {
        return ResponseEntity.ok(pagoService.buscarTodos());
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Pago>> buscarPagoPorCliente(@PathVariable Integer idCliente) throws BusinessRuleException {
        return ResponseEntity.of(pagoService.buscarPorIdCliente(idCliente));
    }

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago){
        return new ResponseEntity<>(pagoService.crearPago(pago), HttpStatus.CREATED);
    }
}
