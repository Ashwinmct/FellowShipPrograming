package com.linkedlist;

public class WrongIndexErrorException extends Exception {
    public enum ExceptionType{
        INVALID_INDEX,INDEX_OUT_OF_BOUND,EMPTY_LIST
    }
    public ExceptionType type;
    public WrongIndexErrorException(ExceptionType type,String message){
        super(message);
        this.type=type;
    }
}
