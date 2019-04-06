package ru.xpendence.aviapersonal.parser.entity;

import lombok.Setter;

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
@Setter
public class EmployeeCount extends AbstractEntity {

    private String federalDistrict;
    private String region;
    private Double value;
    private Integer year;

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
}
