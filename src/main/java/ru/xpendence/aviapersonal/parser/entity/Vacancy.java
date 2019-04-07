package ru.xpendence.aviapersonal.parser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 15:36
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "vacancy")
public class Vacancy extends AbstractEntity {

    private String title;
    private String company;
    private String city;
    private Long salary;

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    @Column(name = "salary")
    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }
}
