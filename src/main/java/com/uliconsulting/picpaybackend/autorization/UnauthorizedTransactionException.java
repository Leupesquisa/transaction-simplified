package com.uliconsulting.picpaybackend.autorization;

public class UnauthorizedTransactionException extends RuntimeException {

    public UnauthorizedTransactionException(String message){
        super(message);

    }
    
}
