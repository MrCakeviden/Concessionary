package com.concessionary.domain.model;

public class CoverageRequest
{
    private Long carId;
    private Coverage coverage;

    public CoverageRequest(Long carId, Coverage coverage) {
        this.carId = carId;
        this.coverage = coverage;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }

}
