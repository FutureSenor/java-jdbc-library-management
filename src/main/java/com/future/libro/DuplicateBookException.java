package com.future.libro;

class DuplicateBookException extends RuntimeException { 
    public DuplicateBookException (String message) {
        super(message);
    }
}