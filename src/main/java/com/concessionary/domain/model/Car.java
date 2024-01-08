package com.concessionary.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Long carId;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "release_year", nullable = false)
    private String releaseYear;

    @Column(name = "vin", nullable = false)
    private String vin;


    public Car() {}

    public Car(Long carId, Long ownerId, String brand, String model, String releaseYear, String vin) {
        this.carId = carId;
        this.ownerId = ownerId;
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.vin = vin;
    }

    public Car(Long ownerId, String brand, String model, String releaseYear, String vin) {
        this.ownerId = ownerId;
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.vin = vin;
    }


    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", ownerId=" + ownerId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + releaseYear + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }

}
