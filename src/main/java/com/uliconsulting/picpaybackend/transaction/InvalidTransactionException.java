package com.uliconsulting.picpaybackend.transaction;

public class InvalidTransactionException extends RuntimeException  {

    public InvalidTransactionException(String message){
        super(message);
    }
    
}
