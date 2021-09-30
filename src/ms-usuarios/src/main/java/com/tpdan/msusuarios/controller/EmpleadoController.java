package com.tpdan.msusuarios.controller;

import com.tpdan.msusuarios.model.Empleado;
import com.tpdan.msusuarios.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Empleado>> buscarTodos(){
        return ResponseEntity.ok(this.empleadoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Integer id){
        return ResponseEntity.of(empleadoService.buscarEmpleadoPorId(id));
    }

    @GetMapping("/empleado")
    public ResponseEntity<List<Empleado>> buscarEmpleado(@RequestParam(required = false, name= "id") Integer id, @RequestParam(required = false, name= "razonSocial") String razonSocial, @RequestParam(required = false, name= "mail") String mail){
        return ResponseEntity.of(empleadoService.buscarEmpleado(id, razonSocial, mail));
    }

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado nuevoEmpleado){
        return new ResponseEntity<Empleado>(empleadoService.crearEmpleado(nuevoEmpleado), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado nuevoEmpleado){
        return new ResponseEntity<Empleado>(empleadoService.actualizarEmpleado(nuevoEmpleado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus borrarEmpleado(@PathVariable Integer id){
        empleadoService.borrarEmpleado(id);
        return HttpStatus.NO_CONTENT;
    }
}
