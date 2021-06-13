package com.marianowinar.logic.exception;

import java.time.LocalDateTime;

public class InvalidNumberException extends Exceptions{
    public InvalidNumberException() {
        idError = 2;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + ": Los datos ingresados no son números. Se admiten solo valores numéricos mayores a Cero.");
    }
}
