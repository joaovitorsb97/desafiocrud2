package com.desafiocrud.desafiocrud2.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg){
        super("Database error: " + msg);
    }
}
