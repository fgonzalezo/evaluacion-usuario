package com.everis.cl.evaluacion.service.implentation;

import com.everis.cl.evaluacion.model.User;
import com.everis.cl.evaluacion.repository.UserRepository;
import com.everis.cl.evaluacion.request.FindUserByEmailRequest;
import com.everis.cl.evaluacion.response.FindUserByEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.everis.cl.evaluacion.util.AppConstant.*;

@Service
public class FindUserByEmailService {

    private UserRepository userRepository;

    @Autowired
    public FindUserByEmailService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public FindUserByEmailResponse findUserByEmail(final FindUserByEmailRequest findUserByEmailRequest) {
        final User user = userRepository.findByEmail(findUserByEmailRequest.getEmail());
        Objects.requireNonNull(user, USER_DOES_NOT_EXIST_EXCEPTION_MESSAGE);

        final FindUserByEmailResponse findUserByEmailResponse =
                new FindUserByEmailResponse(
                        user.getId(),
                        user.getCreated(),
                        user.getModified(),
                        user.getLastLogin(),
                        user.getToken(),
                        user.isActive());

        return findUserByEmailResponse;
    }
}
