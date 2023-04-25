package com.scaler.lld.exception;

public class ExistingUserIdOrEmailIdException extends Exception{

    public ExistingUserIdOrEmailIdException(String msg){
        super(msg);
    }
}
