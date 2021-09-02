package com.tpdan.msusuarios.service.impl;

import com.tpdan.msusuarios.model.Empleado;
import com.tpdan.msusuarios.repository.EmpleadoRepository;
import com.tpdan.msusuarios.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository){
        this.empleadoRepository=empleadoRepository;
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> buscarEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Optional<List<Empleado>> buscarEmpleado(Integer id, String razonSocial, String mail) {
        return empleadoRepository.findAllByQuery(id, razonSocial, mail);
    }

    @Override
    public Empleado crearEmpleado(Empleado nuevoEmpleado) {
        return empleadoRepository.save(nuevoEmpleado);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado nuevoEmpleado) {
        return empleadoRepository.save(nuevoEmpleado);
    }

    @Override
    public void borrarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
