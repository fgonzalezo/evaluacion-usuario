package com.everis.cl.evaluacion.service.implentation;

import com.everis.cl.evaluacion.request.FindUserByEmailRequest;
import com.everis.cl.evaluacion.request.IngresarRequest;
import com.everis.cl.evaluacion.response.FindUserByEmailResponse;
import com.everis.cl.evaluacion.response.GetUsersResponse;
import com.everis.cl.evaluacion.response.IngresarResponse;
import com.everis.cl.evaluacion.service.contract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final IngresarService ingresarService;
    private final GetUserService getUsersUseCase;
    private final FindUserByEmailService findUserByEmailUseCase;

    @Autowired
    public UserService(
            final IngresarService ingresarService,
            final GetUserService getUsersUseCase,
            final FindUserByEmailService findUserByEmailUseCase) {
        this.ingresarService = ingresarService;
        this.getUsersUseCase = getUsersUseCase;
        this.findUserByEmailUseCase = findUserByEmailUseCase;
    }

    @Override
    public IngresarResponse ingresar(final IngresarRequest ingresarRequest) {
        return ingresarService.ingresar(ingresarRequest);
    }

    @Override
    public GetUsersResponse getUsers() {
        return getUsersUseCase.getUsers();
    }

    @Override
    public FindUserByEmailResponse findUserByEmail(FindUserByEmailRequest findUserByEmailRequest) {
        return findUserByEmailUseCase.findUserByEmail(findUserByEmailRequest);
    }
}
