package ru.xpendence.aviapersonal.parser.entity;

import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@SQLDelete(sql = "UPDATE vacancy SET active = 0 WHERE id = ?")
@Where(clause = "active = 1")
@Setter
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
}
