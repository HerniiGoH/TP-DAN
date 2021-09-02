package com.tpdan.msusuarios.model.dto;

public enum RiesgoBCRA {
    NORMAL,
    RIESGO_BAJO,
    RIESGO_MEDIO,
    RIESGO_ALTO,
    IRRECUPERABLE,
    IRRECUPERABLE_POR_DISPOSICION_TECNICA;

    public static Boolean esSituacionValida(RiesgoBCRA riesgoBCRA) {
        return RiesgoBCRA.NORMAL.equals(riesgoBCRA) || RiesgoBCRA.RIESGO_BAJO.equals(riesgoBCRA);
    }
}
