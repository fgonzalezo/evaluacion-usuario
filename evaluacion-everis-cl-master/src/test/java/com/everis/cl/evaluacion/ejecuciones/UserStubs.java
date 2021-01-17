package com.everis.cl.evaluacion.ejecuciones;

import com.everis.cl.evaluacion.model.User;

import static com.everis.cl.evaluacion.util.Varios.getStubs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

public class UserStubs {

    public UserStubs() {
    }

    public static User getUser() throws IOException {
        return new ObjectMapper().readValue(getStubs("user.json"), new TypeReference<User>() {
        });
    }
}
