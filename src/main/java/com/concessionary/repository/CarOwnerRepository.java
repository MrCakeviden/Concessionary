package com.concessionary.repository;

import com.concessionary.domain.model.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long>
{

}
