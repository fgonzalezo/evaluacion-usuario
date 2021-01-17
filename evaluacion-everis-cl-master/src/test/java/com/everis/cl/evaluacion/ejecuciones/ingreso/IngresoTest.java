package com.everis.cl.evaluacion.ejecuciones.ingreso;

import static com.everis.cl.evaluacion.ejecuciones.UserStubs.getUser;
import static com.everis.cl.evaluacion.ejecuciones.ingreso.IngresoStubs.getDoSignInRequest;
import static com.everis.cl.evaluacion.ejecuciones.ingreso.IngresoStubs.getDoSignInResponse;

import com.everis.cl.evaluacion.controller.UserController;
import com.everis.cl.evaluacion.service.implentation.UserService;
import com.everis.cl.evaluacion.repository.UserRepository;
import com.everis.cl.evaluacion.model.User;
import com.everis.cl.evaluacion.service.implentation.IngresarService;

import com.everis.cl.evaluacion.response.IngresarResponse;
import com.everis.cl.evaluacion.service.implentation.FindUserByEmailService;
import com.everis.cl.evaluacion.service.implentation.GetUserService;

import com.everis.cl.evaluacion.util.exceptions.ExceptionHandlerResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class IngresoTest {

    @Mock
    private GetUserService getUserService;
    @Mock
    private FindUserByEmailService findUserByEmailService;
    @Mock
    private UserRepository userRepository;

    private UserController userController;

    @Before
    public void setup() throws IOException {

        final IngresarService ingresarService = new IngresarService(userRepository);
        final UserService userService = new UserService(ingresarService, getUserService, findUserByEmailService);
        userController = new UserController(userService);

        final User user =
                new User(
                        getUser().getId(),
                        getUser().getName(),
                        getUser().getEmail(),
                        getUser().getPassword(),
                        getUser().getPhones(),
                        getUser().getCreated(),
                        getUser().getModified(),
                        getUser().getLastLogin(),
                        getUser().getToken(),
                        getUser().isActive());
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findByEmail(any(String.class))).thenReturn(user);
        when(userRepository.updateUser(any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(1);
    }

    @Test
    public void exito() throws IOException {
        assertNotNull(getDoSignInRequest());

        final IngresarResponse doSignInResponse = userController.ingresar(getDoSignInRequest());

        assertNotNull(getDoSignInResponse());
        assertNotNull(doSignInResponse);
        assertEquals(
                doSignInResponse,
                new IngresarResponse(
                        getDoSignInResponse().getId(),
                        getDoSignInResponse().getCreated(),
                        getDoSignInResponse().getModified(),
                        getDoSignInResponse().getLastLogin(),
                        getDoSignInResponse().getToken(),
                        getDoSignInResponse().isActive()));
    }

    @Test
    public void falla() throws IOException {
        assertNotNull(getDoSignInRequest());
        try {
            userController.ingresar(null);
        } catch (NullPointerException ex) {
            assertEquals(new ExceptionHandlerResponse<>(null).getMessage(), ex.getMessage());
        }
    }
}

