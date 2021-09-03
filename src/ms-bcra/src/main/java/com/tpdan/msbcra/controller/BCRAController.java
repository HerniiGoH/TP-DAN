package com.tpdan.msbcra.controller;

import com.tpdan.msbcra.model.RiesgoBCRA;
import com.tpdan.msbcra.service.BCRAService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bcra")
public class BCRAController {
    private final BCRAService bcraService;

    public BCRAController(BCRAService bcraService){
        this.bcraService = bcraService;
    }

    @GetMapping("/cliente")
    public ResponseEntity<RiesgoBCRA> obtenerRiesgoPorCliente(@RequestParam(required = false) String cuit){
        return ResponseEntity.ok(bcraService.obtenerRiesgoPorCuit(cuit));
    }
}
