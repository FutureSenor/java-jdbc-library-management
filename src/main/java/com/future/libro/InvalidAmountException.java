package com.future.libro;

class InvalidAmountException extends RuntimeException { // ошибка на введенное неправильное количество при выдаче
    public InvalidAmountException (String message) {
        super(message);
    }
}