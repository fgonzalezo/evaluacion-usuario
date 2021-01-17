package com.everis.cl.evaluacion.response;

import com.everis.cl.evaluacion.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GetUsersResponse implements Serializable {

    private List<User> users;

    public GetUsersResponse() {
    }

    public GetUsersResponse(final List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUsersResponse that = (GetUsersResponse) o;
        return Objects.equals(getUsers(), that.getUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsers());
    }

    @Override
    public String toString() {
        return "GetUsersResponse{" + "users=" + getUsers() + '}';
    }
}