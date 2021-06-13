package com.marianowinar.util.validator;

import com.marianowinar.logic.exception.Exceptions;
import com.marianowinar.logic.exception.InvalidNumberException;
import com.marianowinar.logic.exception.InvalidStockException;
import com.marianowinar.logic.exception.NullException;

import java.util.regex.Pattern;

public class Validator {

    public void validData(String text) throws Exceptions {
        if(text == null)
            throw new NullException();

        if(!Pattern.matches("^[0-9]+([,][0-9]+)?$", text))
            throw new InvalidNumberException();
    }

    public void validStock(int stock) throws Exceptions {
        if(stock <= 0){
            throw new InvalidStockException();
        }
    }
}
