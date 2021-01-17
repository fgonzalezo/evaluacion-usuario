package com.everis.cl.evaluacion.service.implentation;

import com.everis.cl.evaluacion.model.User;
import com.everis.cl.evaluacion.repository.UserRepository;
import com.everis.cl.evaluacion.request.IngresarRequest;
import com.everis.cl.evaluacion.response.IngresarResponse;

import static com.everis.cl.evaluacion.util.Varios.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngresarService {

    private final UserRepository userRepository;

    @Autowired
    public IngresarService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public IngresarResponse ingresar(final IngresarRequest ingresarRequest) {

        User user = userRepository.findByEmail(ingresarRequest.getEmail());

        final String token = UUID.randomUUID().toString().replace("-", "");
        if (user == null) {
            user = userRepository.save(
                    new User(
                            ingresarRequest.getName(),
                            ingresarRequest.getEmail(),
                            ingresarRequest.getPassword(),
                            ingresarRequest.getPhones(),
                            dateNow(),
                            dateNow(),
                            dateNow(),
                            token,
                            true));
        } else if (user.getToken() != null) {
            final String dateNow = dateNow();
            final int updateUser = userRepository.updateUser(user.getEmail(), token, dateNow, dateNow);
        }

        final IngresarResponse ingresarResponse =
                new IngresarResponse(
                        user.getId(),
                        user.getCreated(),
                        user.getModified(),
                        user.getLastLogin(),
                        user.getToken(),
                        user.isActive());
        return ingresarResponse;
    }
}
