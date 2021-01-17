package com.everis.cl.evaluacion.ejecuciones.finduserbyemail;


import com.everis.cl.evaluacion.request.FindUserByEmailRequest;
import com.everis.cl.evaluacion.response.FindUserByEmailResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.everis.cl.evaluacion.util.Varios.*;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;

public class FindUserByEmailStubs {
    public FindUserByEmailStubs() {
    }

    public static FindUserByEmailResponse getFindUserByEmailResponse() throws IOException {
        return new ObjectMapper()
                .readValue(
                        getStubs("find-user-by-email-response.json"),
                        new TypeReference<FindUserByEmailResponse>() {
                        });
    }

    public static FindUserByEmailRequest getFindUserByEmailRequest() throws IOException {
        return new ObjectMapper()
                .readValue(
                        getStubs("find-user-by-email-request.json"),
                        new TypeReference<FindUserByEmailRequest>() {
                        });
    }
}
