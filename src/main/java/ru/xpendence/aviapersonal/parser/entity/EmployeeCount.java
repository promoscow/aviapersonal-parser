package ru.xpendence.aviapersonal.parser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 16:53
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "employee_count")
public class EmployeeCount extends AbstractEntity {

    private String federalDistrict;
    private String region;
    private Double value;
    private Integer year;
    private Boolean byDistrict;

    public EmployeeCount() {
    }

    public EmployeeCount(String federalDistrict, String region, Double value, Integer year, Boolean byDistrict) {
        this.federalDistrict = federalDistrict;
        this.region = region;
        this.value = value;
        this.year = year;
        this.byDistrict = byDistrict;
    }

    public EmployeeCount(Integer year) {
        this.year = year;
    }

    @Column(name = "federal_district")
    public String getFederalDistrict() {
        return federalDistrict;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    @Column(name = "value")
    public Double getValue() {
        return value;
    }

    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    @Column(name = "by_district")
    public Boolean getByDistrict() {
        return byDistrict;
    }

    public void setFederalDistrict(String federalDistrict) {
        this.federalDistrict = federalDistrict;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setByDistrict(Boolean byDistrict) {
        this.byDistrict = byDistrict;
    }

    @Override
    public String toString() {
        return "EmployeeCount{" +
                "federalDistrict='" + federalDistrict + '\'' +
                ", region='" + region + '\'' +
                ", value=" + value +
                ", year=" + year +
                ", byDistrict=" + byDistrict +
                '}';
    }
}
