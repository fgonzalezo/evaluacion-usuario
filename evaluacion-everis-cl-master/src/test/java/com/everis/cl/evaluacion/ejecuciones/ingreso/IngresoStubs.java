package com.everis.cl.evaluacion.ejecuciones.ingreso;

import com.everis.cl.evaluacion.response.IngresarResponse;
import com.everis.cl.evaluacion.request.IngresarRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.everis.cl.evaluacion.util.Varios.getStubs;

import java.io.IOException;

public class IngresoStubs {
    public IngresoStubs() {
    }

    public static IngresarRequest getDoSignInRequest() throws IOException {
        return new ObjectMapper().readValue(getStubs("sign-in-request.json"), new TypeReference<IngresarRequest>() {
        });
    }

    public static IngresarResponse getDoSignInResponse() throws IOException {
        return new ObjectMapper()
                .readValue(getStubs("sign-in-response.json"), new TypeReference<IngresarResponse>() {
                });
    }
}
