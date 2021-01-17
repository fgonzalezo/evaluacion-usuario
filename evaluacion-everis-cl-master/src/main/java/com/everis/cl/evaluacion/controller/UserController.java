package com.everis.cl.evaluacion.controller;

import com.everis.cl.evaluacion.request.FindUserByEmailRequest;
import com.everis.cl.evaluacion.request.IngresarRequest;
import com.everis.cl.evaluacion.response.FindUserByEmailResponse;
import com.everis.cl.evaluacion.response.GetUsersResponse;
import com.everis.cl.evaluacion.response.IngresarResponse;
import com.everis.cl.evaluacion.service.implentation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            value = "/ingresar",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IngresarResponse ingresar(@Valid @RequestBody final IngresarRequest ingresarRequest) {
        return userService.ingresar(ingresarRequest);
    }

    @RequestMapping(
            value = "/getUsers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GetUsersResponse getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(
            value = "/findUserByEmail",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FindUserByEmailResponse findUserByEmail(
            @RequestBody @Valid final FindUserByEmailRequest findUserByEmailRequest) {
        return userService.findUserByEmail(findUserByEmailRequest);
    }
}
