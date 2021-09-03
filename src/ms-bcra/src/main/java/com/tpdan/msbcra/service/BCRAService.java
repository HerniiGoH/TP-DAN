package com.tpdan.msbcra.service;

import com.tpdan.msbcra.model.RiesgoBCRA;

public interface BCRAService {
    RiesgoBCRA obtenerRiesgoPorCuit(String cuit);
}
