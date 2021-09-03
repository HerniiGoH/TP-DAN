package com.tpdan.msbcra.service.impl;

import com.tpdan.msbcra.model.RiesgoBCRA;
import com.tpdan.msbcra.service.BCRAService;
import org.springframework.stereotype.Service;

@Service
public class BCRAServiceMockImpl implements BCRAService {
    @Override
    public RiesgoBCRA obtenerRiesgoPorCuit(String cuit) {
        return RiesgoBCRA.RIESGO_BAJO;
    }
}
