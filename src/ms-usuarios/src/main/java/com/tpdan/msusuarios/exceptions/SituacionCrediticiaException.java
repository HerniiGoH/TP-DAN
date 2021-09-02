package com.tpdan.msusuarios.exceptions;

import com.tpdan.msusuarios.model.dto.RiesgoBCRA;

import java.util.Locale;

public class SituacionCrediticiaException extends BusinessRuleException {
    public SituacionCrediticiaException(RiesgoBCRA riesgoBCRA){
        super("No es posible dar de alta a un cliente con un Riesgo BCRA: " + riesgoBCRA.toString().toUpperCase(Locale.ROOT) + ".");
    }
}
