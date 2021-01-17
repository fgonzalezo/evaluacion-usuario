package com.everis.cl.evaluacion.util;

public class AppConstant {

    public static final String USER_DOES_NOT_EXIST_EXCEPTION_MESSAGE = "Usuario no existe.";
    public static final String USERS_DOES_NOT_EXIST_EXCEPTION_MESSAGE = "Usuarios no existen.";
    public static final String CONSTRAINT_EMAIL_VIOLATION_EXCEPTION_MESSAGE = "El correo ingresado ya existe.";
    public static final String EMAIL_FORMAT_ERROR_MESSAGE = "Ingrese un correo valido. Ejemplo: email@email.com";
    public static final String CREDENTIALS_FORMAT_ERROR_MESSAGE =
            "La contraseña debe tener entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula. Ejemplo 'Password22'.";

    public static final String EMAIL_NULL_ERROR_MESSAGE = "El correo no puede estar vacío.";
    public static final String NAME_NULL_ERROR_MESSAGE = "El nombre no puede estar vacío.";
    public static final String CREDENTIALS_NULL_ERROR_MESSAGE = "El password no puede estar vacío.";
    public static final String PHONES_NULL_ERROR_MESSAGE = "Debe ingresar al menos un teléfono.";
    public static final String NUMBER_NULL_ERROR_MESSAGE = "El número telefónico no puede estar vacío.";
    public static final String CITYWIDE_NULL_ERROR_MESSAGE = "El código de ciudad no puede estar vacío.";
    public static final String COUNTRYSIDE_NULL_ERROR_MESSAGE = "El código de país no puede estar vacío.";

    public static final String EMAIL_EMPTY_ERROR_MESSAGE = "El correo es requerido.";
    public static final String NAME_EMPTY_ERROR_MESSAGE = "El nombre es requerido.";
    public static final String CREDENTIALS_EMPTY_ERROR_MESSAGE = "El password es requerido.";
    public static final String PHONES_EMPTY_ERROR_MESSAGE = "Es requerido ingresar al menos un número telefónico.";
    public static final String NUMBER_EMPTY_ERROR_MESSAGE = "El número telefónico es requerido.";
    public static final String CITYWIDE_EMPTY_ERROR_MESSAGE = "El código de ciudad es requerido.";
    public static final String COUNTRYSIDE_EMPTY_ERROR_MESSAGE = "El código de país es requerido.";

    public static final String PATTERN_CREDENTIALS = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";

    public static final String FORMAT_MESSAGE_JWT = "{\"message\": \"%s\"}";
    public static final String TYPE_MESSAGE_JWT = "application/json";
    public static final String CHARACTER_ENCODING_MESSAGE_JWT = "UTF-8";
    public static final String DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";

    public AppConstant() {
    }
}
