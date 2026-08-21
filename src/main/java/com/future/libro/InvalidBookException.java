package com.future.libro;

class InvalidBookException extends RuntimeException { 
    public InvalidBookException (String message) {
        super(message);
    }
}