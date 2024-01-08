package com.concessionary;

import com.concessionary.domain.model.Car;
import com.concessionary.domain.model.CarOwner;
import com.concessionary.repository.CarOwnerRepository;
import com.concessionary.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ConcessionaryApplication  implements CommandLineRunner
{
	@Autowired
	CarOwnerRepository carOwnerRepository;

	@Autowired
	CarRepository carRepository;

	public static void main(String[] args)
	{
		SpringApplication.run(ConcessionaryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		/*
		CarOwner carOwner01 = new CarOwner(
				1001L,
				"Gordon Shumway",
				LocalDate.now().minusYears(30),
				"gordons@hotmail.com",
				"4486541140");
		CarOwner carOwner02 = new CarOwner(
				1002L,
				"Javier Lopez",
				LocalDate.now().minusYears(75),
				"chavelo@gmail.com",
				"4479563354");
		CarOwner carOwner03 = new CarOwner(
				1003L,
				"Abelardo Bajonero",
				LocalDate.now().minusYears(24),
				"bajonabe@yahoo.com",
				"4421479562");

		carOwnerRepository.save(carOwner01);
		carOwnerRepository.save(carOwner02);
		carOwnerRepository.save(carOwner03);
		*/

		/*
		Car car01 = new Car(
				1L,
				"BMW",
				"Estima",
				"2002",
				"GEN0111VINNO"
		);
		Car car02 = new Car(
				2L,
				"Ferrari",
				"Passo",
				"2017",
				"GEN0112VINNO"
		);
		Car car03 = new Car(
				3L,
				"Ford",
				"Aqua",
				"2015",
				"GEN0113VINNO"
		);

		carRepository.save(car01);
		carRepository.save(car02);
		carRepository.save(car03);

		 */
	}
}
