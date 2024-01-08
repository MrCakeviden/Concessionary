package com.concessionary.api;

import com.concessionary.domain.exception.CarNotFoundException;
import com.concessionary.domain.exception.CarOwnerNotFoundException;
import com.concessionary.domain.model.*;
import com.concessionary.service.service.CarOwnerService;
import com.concessionary.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
public class CarController
{
    @Autowired
    CarService carService;

    @Autowired
    CarOwnerService carOwnerService;

// ===========================================================================================================

    @GetMapping("/fetch_car")
    public List<Car> getAllCars()
    {
        return carService.getCars();
    }


    @GetMapping("/fetch_car/{id}")
    public Car getSingleCar(@PathVariable Long id) throws CarNotFoundException
    {
        Car carFound = carService.getCarById(id);
        return ResponseEntity.ok(carFound).getBody();
    }


    @PostMapping("/create_car")
    public Car createCar(@RequestBody Car car)
    {
        Car newCarOwner = carService.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCarOwner).getBody();
    }


    @PutMapping("/update_car")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) throws CarNotFoundException
    {
        Car updateCar = carService.updateCar(car);
        return ResponseEntity.ok(updateCar);
    }


    @DeleteMapping("/delete_car/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id) throws CarNotFoundException
    {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/get_cars_by_owner/{id}")
    public List<Car> getCarsByOwnerId(@PathVariable Long id) throws CarNotFoundException
    {
        return carService.getCarsByOwnerId(id);
    }


    @GetMapping("/send_policy_order")
    public Policy sendPolicyOrder(@RequestBody CoverageRequest request) throws CarNotFoundException, CarOwnerNotFoundException
    {
        Car car = carService.getCarById(request.getCarId());
        CarOwner carOwner = carOwnerService.getCarOwnerById(car.getOwnerId());
        Coverage coverage = request.getCoverage();

        return new Policy(car, carOwner, coverage);
    }

}
