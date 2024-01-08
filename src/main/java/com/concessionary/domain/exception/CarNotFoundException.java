package com.concessionary.domain.exception;

public class CarNotFoundException extends Exception
{
    public CarNotFoundException(String message)
    {
        super(message);
    }

    public CarNotFoundException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
