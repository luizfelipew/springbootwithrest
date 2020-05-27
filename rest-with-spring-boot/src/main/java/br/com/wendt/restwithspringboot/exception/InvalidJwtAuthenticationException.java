package br.com.wendt.restwithspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 8387815181647637258L;

    public InvalidJwtAuthenticationException(String exception){
        super(exception);
    }
}
