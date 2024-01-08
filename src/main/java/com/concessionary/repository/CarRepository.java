package com.concessionary.repository;

import com.concessionary.domain.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>
{
    List<Car> findCarsByOwnerId(Long ownerId);
}
