package com.everis.cl.evaluacion.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import static com.everis.cl.evaluacion.util.AppConstant.*;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FindUserByEmailRequest implements Serializable {

    @NotNull(message = EMAIL_NULL_ERROR_MESSAGE)
    @NotBlank(message = EMAIL_EMPTY_ERROR_MESSAGE)
    @Email(message = EMAIL_FORMAT_ERROR_MESSAGE)
    private String email;

    public FindUserByEmailRequest() {
    }

    public FindUserByEmailRequest(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "FindUserByEmailRequest{" + "email='" + getEmail() + '\'' + '}';
    }
}