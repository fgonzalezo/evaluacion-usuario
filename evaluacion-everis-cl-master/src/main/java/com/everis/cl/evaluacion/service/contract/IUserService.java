package com.everis.cl.evaluacion.service.contract;

import com.everis.cl.evaluacion.request.FindUserByEmailRequest;
import com.everis.cl.evaluacion.request.IngresarRequest;
import com.everis.cl.evaluacion.response.FindUserByEmailResponse;
import com.everis.cl.evaluacion.response.GetUsersResponse;
import com.everis.cl.evaluacion.response.IngresarResponse;

public interface IUserService {

    IngresarResponse ingresar(IngresarRequest ingresarRequest);

    GetUsersResponse getUsers();

    FindUserByEmailResponse findUserByEmail(FindUserByEmailRequest findUserByEmailRequest);
}
