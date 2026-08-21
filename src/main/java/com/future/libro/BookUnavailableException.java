package com.future.libro;

class BookUnavailableException extends RuntimeException { // ошибка когда книгу нельзя выдать 
    public BookUnavailableException (String message) {
        super(message);
    }
}