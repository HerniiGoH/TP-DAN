package com.tpdan.msusuarios.controller;

import com.tpdan.msusuarios.exceptions.BusinessRuleException;
import com.tpdan.msusuarios.model.Obra;
import com.tpdan.msusuarios.model.dto.JsonWrapper;
import com.tpdan.msusuarios.service.ObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obra")
public class ObraController {

    private final ObraService obraService;

    public ObraController(ObraService obraService){
        this.obraService = obraService;
    }

    @GetMapping
    public ResponseEntity<List<Obra>> buscarTodas(@RequestParam(required = false) List<Integer> ids){
        return ResponseEntity.ok(obraService.buscarTodas(ids));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> busarObraPorId(@PathVariable Integer id){
        return ResponseEntity.of(obraService.buscarObraPorId(id));
    }

    @GetMapping("/obra")
    public ResponseEntity<List<Obra>>buscarObra(@RequestParam(required = false, name = "id") Integer id, @RequestParam(required = false, name = "descripcion") String descripcion, @RequestParam(required = false, name = "latitud") Float latitud, @RequestParam(required = false, name = "longitud") Float longitud, @RequestParam(required = false, name = "direccion") String direccion, @RequestParam(required = false, name = "superficie") Integer superficie, @RequestBody(required = false) JsonWrapper jsonWrapper){
        return ResponseEntity.of(obraService.buscarObra(id, descripcion, latitud, longitud, direccion, superficie, jsonWrapper.getTipoObra(), jsonWrapper.getCliente()));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Obra>>buscarObraPorCliente(@RequestParam(required = false) Integer id, @RequestParam(required = false) String cuit){
        return ResponseEntity.of(obraService.buscarObraPorCliente(id, cuit));
    }

    @PostMapping
    public ResponseEntity<Obra> crearObra(@RequestBody Obra obra){
        return new ResponseEntity<Obra>(obraService.crearObra(obra), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Obra> actualizarObra(@RequestBody Obra obra){
        return ResponseEntity.ok(obraService.actualizarObra(obra));
    }

    @DeleteMapping("/{id}")
    public HttpStatus eliminarObra(@PathVariable Integer id) throws BusinessRuleException {
        obraService.borrarObra(id);
        return HttpStatus.NO_CONTENT;
    }
}
