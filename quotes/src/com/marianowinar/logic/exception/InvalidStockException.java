package com.marianowinar.logic.exception;

import java.time.LocalDateTime;

public class InvalidStockException extends Exceptions{
    public InvalidStockException() {
        idError = 3;
        String currentTime = LocalDateTime.now().toString().replace("T", " ");
        setError("["+ currentTime +"] Error " + idError + ": Está realizando una consulta sobre un producto el cual no hay stock disponible.");
    }
}
