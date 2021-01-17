package com.everis.cl.evaluacion.service.implentation;

import com.everis.cl.evaluacion.model.User;
import com.everis.cl.evaluacion.repository.UserRepository;
import com.everis.cl.evaluacion.response.GetUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.everis.cl.evaluacion.util.AppConstant.*;

@Service
public class GetUserService {

    private final UserRepository userRepository;

    @Autowired
    public GetUserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public GetUsersResponse getUsers() {
        final List<User> users = userRepository.findAll();
        Objects.requireNonNull(users, USERS_DOES_NOT_EXIST_EXCEPTION_MESSAGE);
        return new GetUsersResponse(userRepository.findAll());
    }
}
