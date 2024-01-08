package com.concessionary.service.service;



import com.concessionary.domain.exception.CarOwnerNotFoundException;
import com.concessionary.domain.model.CarOwner;

import java.util.List;

public interface CarOwnerService
{
    public List<CarOwner> getCarOwners();
    public CarOwner getCarOwnerById(Long id) throws CarOwnerNotFoundException;
    public CarOwner createCarOwner(CarOwner cons);
    public CarOwner updateCarOwner(CarOwner cons) throws CarOwnerNotFoundException;
    public void deleteCarOwner(Long id) throws CarOwnerNotFoundException;
}
