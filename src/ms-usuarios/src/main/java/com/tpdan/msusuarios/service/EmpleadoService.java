package com.tpdan.msusuarios.service;

import com.tpdan.msusuarios.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> buscarTodos();
    Optional<Empleado> buscarEmpleadoPorId(Integer id);
    Optional<List<Empleado>> buscarEmpleado(Integer id, String razonSocial, String mail);
    Empleado crearEmpleado(Empleado nuevoEmpleado);
    Empleado actualizarEmpleado(Empleado nuevoEmpleado);
    void borrarEmpleado(Integer id);
}
