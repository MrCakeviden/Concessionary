package com.concessionary.domain.model;

public class Coverage
{
    private String type;
    private Integer deductible;
    private String coveragePeriod;

    public Coverage(String type, Integer deductible, String coveragePeriod) {
        this.type = type;
        this.deductible = deductible;
        this.coveragePeriod = coveragePeriod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDeductible() {
        return deductible;
    }

    public void setDeductible(Integer deductible) {
        this.deductible = deductible;
    }

    public String getCoveragePeriod() {
        return coveragePeriod;
    }

    public void setCoveragePeriod(String coveragePeriod) {
        this.coveragePeriod = coveragePeriod;
    }
}
