package com.sparta.wla.exceptions;

import javax.swing.plaf.basic.BasicTreeUI;
import java.sql.SQLOutput;

public class ChildNotFoundException extends Exception {

    private String message;

    public ChildNotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
