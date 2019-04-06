package ru.xpendence.aviapersonal.parser.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeCount extends AbstractEntity {

    private String federalDistrict;
    private String region;
    private Double value;
    private Integer year;
    private Boolean byDistrict;

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
}
