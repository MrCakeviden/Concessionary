package com.concessionary.domain.exception;

public class CarOwnerNotFoundException extends Exception
{
    public CarOwnerNotFoundException(String message)
    {
        super(message);
    }

    public CarOwnerNotFoundException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
