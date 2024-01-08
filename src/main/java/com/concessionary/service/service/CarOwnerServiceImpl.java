package com.concessionary.service.service;

import com.concessionary.domain.exception.CarOwnerNotFoundException;
import com.concessionary.domain.model.CarOwner;
import com.concessionary.repository.CarOwnerRepository;
import com.concessionary.service.utils.LogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarOwnerServiceImpl implements CarOwnerService
{
    private static final String notFoundMsg = "%s. Car owner ID %s was not found.";

    @Autowired
    private CarOwnerRepository repo;
/*
    @PostConstruct
    public void initCarOwner()
    {
        repo.saveAll
        (
            Stream.of
            (
                new CarOwner(
                        1001L,
                        "Gordon Shumway",
                        LocalDate.now().minusYears(30),
                        "gordons@hotmail.com",
                        "4486541140"),
                new CarOwner(
                        1002L,
                        "Javier Lopez",
                        LocalDate.now().minusYears(75),
                        "chavelo@gmail.com",
                        "4479563354"),
                new CarOwner(
                        1003L,
                        "Abelardo Bajonero",
                        LocalDate.now().minusYears(24),
                        "bajonabe@yahoo.com",
                        "4421479562")
            ).collect(Collectors.toList())
        );
    }
*/
    @Override
    public List<CarOwner> getCarOwners()
    {
        return repo.findAll();
    }

    @Override
    public CarOwner getCarOwnerById(Long id) throws CarOwnerNotFoundException
    {
        Optional<CarOwner> findById = repo.findById(id);
        if(findById.isEmpty())
        {
            String logMsg = String.format(notFoundMsg, "Fetch failed", id);
            LogUtil.logWarning(logMsg);
            throw new CarOwnerNotFoundException(logMsg);
        }
        return findById.get();
    }

    @Override
    public CarOwner createCarOwner(CarOwner carOwner)
    {
        return repo.save(carOwner);
    }

    @Override
    public CarOwner updateCarOwner(CarOwner carOwner) throws CarOwnerNotFoundException
    {
        Optional<CarOwner> findById = repo.findById(carOwner.getOwnerId());

        if(findById.isEmpty())
        {
            String logMsg = String.format(notFoundMsg, "Update failed", carOwner.getOwnerId());
            LogUtil.logWarning(logMsg);
            throw new CarOwnerNotFoundException(logMsg);
        }
        CarOwner consToSave = findById.get();
        BeanUtils.copyProperties(carOwner, consToSave);

        return repo.save(consToSave);
    }

    @Override
    public void deleteCarOwner(Long id) throws CarOwnerNotFoundException
    {
        Optional<CarOwner> findbyId = repo.findById(id);

        if(findbyId.isEmpty())
        {
            String logMsg = String.format(notFoundMsg, "Deletion failed", id);
            LogUtil.logWarning(logMsg);
            throw new CarOwnerNotFoundException(logMsg);
        }
        repo.deleteById(id);
    }

}