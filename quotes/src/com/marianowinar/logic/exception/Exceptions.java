package com.marianowinar.logic.exception;

public class Exceptions extends Exception{
    protected int idError;
    protected String error;

    public Exceptions() {}

    public Exceptions(String message) {
        super(message);
    }

    public String getError(){
        return this.error;
    }

    protected void setError(String message){
        this.error = message;
    }
}
