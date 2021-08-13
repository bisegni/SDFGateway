package it.deas.sdfgateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class AppAlreadyRegisteredException extends ResponseStatusException {
    public AppAlreadyRegisteredException(String appName) {
        super(HttpStatus.CONFLICT, String.format("Application with same name[%s] already registered", appName));
    }
}
