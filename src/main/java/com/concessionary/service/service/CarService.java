package com.concessionary.service.service;


import com.concessionary.domain.exception.CarNotFoundException;
import com.concessionary.domain.model.Car;

import java.util.List;

public interface CarService
{
    public List<Car> getCars();
    public Car getCarById(Long id) throws CarNotFoundException;
    public Car createCar(Car cons);
    public Car updateCar(Car cons) throws CarNotFoundException;
    public void deleteCar(Long id) throws CarNotFoundException;
    //===================================================================================================================
    public List<Car> getCarsByOwnerId(Long id) throws CarNotFoundException;
}
