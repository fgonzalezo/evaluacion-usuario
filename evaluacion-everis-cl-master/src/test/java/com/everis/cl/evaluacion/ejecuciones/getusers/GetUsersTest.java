package com.everis.cl.evaluacion.ejecuciones.getusers;

import com.everis.cl.evaluacion.model.User;
import com.everis.cl.evaluacion.controller.UserController;
import com.everis.cl.evaluacion.repository.UserRepository;
import com.everis.cl.evaluacion.response.GetUsersResponse;
import com.everis.cl.evaluacion.service.implentation.FindUserByEmailService;
import com.everis.cl.evaluacion.service.implentation.GetUserService;
import com.everis.cl.evaluacion.service.implentation.IngresarService;
import com.everis.cl.evaluacion.service.implentation.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.everis.cl.evaluacion.ejecuciones.UserStubs.getUser;
import static com.everis.cl.evaluacion.ejecuciones.getusers.GetUsersStubs.getGetUsersResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetUsersTest {

    @Mock
    private IngresarService ingresarService;
    @Mock
    private FindUserByEmailService findUserByEmailService;
    @Mock
    private UserRepository userRepository;

    private UserController userController;

    @Before
    public void setup() throws IOException {

        final GetUserService getUserService = new GetUserService(userRepository);

        final UserService userService = new UserService(ingresarService, getUserService, findUserByEmailService);

        userController = new UserController(userService);

        final List<User> listUser = new ArrayList<>();
        listUser.add(
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
                        getUser().isActive()));

        when(userRepository.findAll()).thenReturn(listUser);
    }

    @Test
    public void exito() throws IOException {
        final GetUsersResponse getUsersResponse = userController.getUsers();
        assertNotNull(getGetUsersResponse());
        assertNotNull(getUsersResponse);
        assertEquals(getUsersResponse, getGetUsersResponse());
    }
}
