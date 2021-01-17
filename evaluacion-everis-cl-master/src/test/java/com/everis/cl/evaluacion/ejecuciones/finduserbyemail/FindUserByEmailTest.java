package com.everis.cl.evaluacion.ejecuciones.finduserbyemail;

import com.everis.cl.evaluacion.controller.UserController;
import com.everis.cl.evaluacion.model.User;
import com.everis.cl.evaluacion.repository.UserRepository;
import com.everis.cl.evaluacion.response.FindUserByEmailResponse;
import com.everis.cl.evaluacion.service.implentation.FindUserByEmailService;
import com.everis.cl.evaluacion.service.implentation.GetUserService;
import com.everis.cl.evaluacion.service.implentation.IngresarService;
import com.everis.cl.evaluacion.service.implentation.UserService;


import com.everis.cl.evaluacion.util.exceptions.ExceptionHandlerResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static com.everis.cl.evaluacion.ejecuciones.UserStubs.getUser;
import static com.everis.cl.evaluacion.ejecuciones.finduserbyemail.FindUserByEmailStubs.getFindUserByEmailRequest;
import static com.everis.cl.evaluacion.ejecuciones.finduserbyemail.FindUserByEmailStubs.getFindUserByEmailResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class FindUserByEmailTest {

    @Mock
    private IngresarService ingresarService;
    @Mock
    private GetUserService getUserService;
    @Mock
    private UserRepository userRepository;

    private UserController userController;


    @Before
    public void setup() throws IOException {

        final FindUserByEmailService findUserByEmailService = new FindUserByEmailService(userRepository);

        final UserService userService = new UserService(ingresarService, getUserService, findUserByEmailService);

        userController = new UserController(userService);

        when(userRepository.findByEmail(any(String.class)))
                .thenReturn(
                        new User(
                                getUser().getId(),
                                getUser().getCreated(),
                                getUser().getModified(),
                                getUser().getLastLogin(),
                                getUser().getToken(),
                                getUser().isActive()));
    }

    @Test
    public void exito() throws IOException {
        assertNotNull(getFindUserByEmailRequest());

        final FindUserByEmailResponse findUserByEmailResponse = userController.findUserByEmail(getFindUserByEmailRequest());

        assertNotNull(getFindUserByEmailResponse());
        assertNotNull(findUserByEmailResponse);
        assertEquals(findUserByEmailResponse, getFindUserByEmailResponse());
    }

    @Test
    public void falla() throws IOException {
        assertNotNull(getFindUserByEmailRequest());
        try {
            userController.findUserByEmail(null);
        } catch (NullPointerException ex) {
            assertEquals(new ExceptionHandlerResponse<>(null).getMessage(), ex.getMessage());
        }
    }
}
