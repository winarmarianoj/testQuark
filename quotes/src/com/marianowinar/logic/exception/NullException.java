package com.marianowinar.logic.exception;

import java.time.LocalDateTime;

public class NullException extends Exceptions{
    public NullException() {
        idError = 1;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + ": Los datos no existen o no son válidos.");
    }
}
