package com.TaskHub.TaskHub.exception;

public class SenhaErrada extends RuntimeException {
    public SenhaErrada(String message) {
        super(message);
    }
}
