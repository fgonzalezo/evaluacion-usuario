package com.everis.cl.evaluacion.ejecuciones.getusers;

import static com.everis.cl.evaluacion.util.Varios.getStubs;

import com.everis.cl.evaluacion.response.GetUsersResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class GetUsersStubs {
    public GetUsersStubs() {
    }

    public static GetUsersResponse getGetUsersResponse() throws IOException {
        return new ObjectMapper()
                .readValue(
                        getStubs("get-users-response.json"),
                        new TypeReference<GetUsersResponse>() {
                        });
    }
}
