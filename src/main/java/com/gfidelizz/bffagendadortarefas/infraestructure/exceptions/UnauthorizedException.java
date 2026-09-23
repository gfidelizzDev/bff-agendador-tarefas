package com.gfidelizz.bffagendadortarefas.infraestructure.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }

}
