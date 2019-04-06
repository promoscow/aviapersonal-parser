package ru.xpendence.aviapersonal.parser.entity;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 13:56
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "resume")
@Setter
@ToString
public class Resume extends AbstractEntity {

    private String title;
    private Integer experience;
    private Integer age;
    private Long salary;

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "experience")
    public Integer getExperience() {
        return experience;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    @Column(name = "salary")
    public Long getSalary() {
        return salary;
    }
}
