package com.concessionary.api;

import com.concessionary.domain.exception.CarOwnerNotFoundException;
import com.concessionary.domain.model.CarOwner;
import com.concessionary.service.service.CarOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/car_owner")
public class CarOwnerController
{
    @Autowired
    CarOwnerService service;

    @GetMapping("/fetch_car_owners")
    public List<CarOwner> getAllCarOwners()
    {
        return service.getCarOwners();
    }

    @GetMapping("/fetch_car_owners/{id}")
    public CarOwner getSingleCarOwner(@PathVariable Long id) throws CarOwnerNotFoundException
    {
        CarOwner carOwnerFound = service.getCarOwnerById(id);
        return ResponseEntity.ok(carOwnerFound).getBody();
    }

    @PostMapping("/create_car_owner")
    public CarOwner createCarOwner(@RequestBody CarOwner carOwner)
    {
        CarOwner newCarOwner = service.createCarOwner(carOwner);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCarOwner).getBody();
    }

    @PutMapping("/update_car_owner")
    public ResponseEntity<CarOwner> updateCarOwner(@RequestBody CarOwner carOwner) throws CarOwnerNotFoundException
    {
        CarOwner cons = service.updateCarOwner(carOwner);
        return ResponseEntity.ok(cons);
    }

    @DeleteMapping("/delete_car_owner/{id}")
    public ResponseEntity<CarOwner> deleteCarOwner(@PathVariable Long id) throws CarOwnerNotFoundException
    {
        service.deleteCarOwner(id);
        return ResponseEntity.noContent().build();
    }

}
