package ru.xpendence.aviapersonal.parser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:07
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "employee_salary")
public class EmployeeSalary extends AbstractEntity {

    private String name;
    private String federalDistrict;
    private String region;
    private Double salary;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "federal_district")
    public String getFederalDistrict() {
        return federalDistrict;
    }

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    @Column(name = "salary")
    public Double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFederalDistrict(String federalDistrict) {
        this.federalDistrict = federalDistrict;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
