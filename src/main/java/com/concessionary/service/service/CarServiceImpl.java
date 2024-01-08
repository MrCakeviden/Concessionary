package com.concessionary.service.service;

import com.concessionary.domain.exception.CarNotFoundException;
import com.concessionary.domain.model.Car;
import com.concessionary.repository.CarRepository;
import com.concessionary.service.utils.LogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService
{
    private static final String notFoundMsg = "%s. Car owner ID %s was not found.";

    @Autowired
    private CarRepository repo;



    @Override
    public List<Car> getCars()
    {
        return repo.findAll();
    }


    @Override
    public Car getCarById(Long id) throws CarNotFoundException
    {
        Optional<Car> findById = repo.findById(id);
        if(findById.isEmpty())
        {
            String logMsg = String.format(notFoundMsg, "Fetch failed", id);
            LogUtil.logWarning(logMsg);
            throw new CarNotFoundException(logMsg);
        }
        return findById.get();
    }


    @Override
    public Car createCar(Car car)
    {
        return repo.save(car);
    }


    @Override
    public Car updateCar(Car car) throws CarNotFoundException
    {
        Optional<Car> findById = repo.findById(car.getOwnerId());

        if(findById.isEmpty())
        {
            String logMsg = String.format(notFoundMsg, "Update failed", car.getOwnerId());
            LogUtil.logWarning(logMsg);
            throw new CarNotFoundException(logMsg);
        }
        Car consToSave = findById.get();
        BeanUtils.copyProperties(car, consToSave);

        return repo.save(consToSave);
    }


    @Override
    public void deleteCar(Long id) throws CarNotFoundException
    {
        Optional<Car> findbyId = repo.findById(id);

        if(findbyId.isEmpty())
        {
            String logMsg = String.format(notFoundMsg, "Deletion failed", id);
            LogUtil.logWarning(logMsg);
            throw new CarNotFoundException(logMsg);
        }
        repo.deleteById(id);
    }


    @Override
    public List<Car> getCarsByOwnerId(Long ownerId)
    {
        return repo.findCarsByOwnerId(ownerId);
    }

}