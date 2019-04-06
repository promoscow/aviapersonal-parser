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
 * Time: 13:56
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "resume")
@SQLDelete(sql = "UPDATE resume SET active = 0 WHERE id = ?")
@Where(clause = "active = 1")
@Setter
public class Resume extends AbstractEntity {

    private String title;
    private String category;
    private String specialization;
    private Integer experience;
    private String name;
    private Long salary;

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    @Column(name = "specialization")
    public String getSpecialization() {
        return specialization;
    }

    @Column(name = "experience")
    public Integer getExperience() {
        return experience;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "salary")
    public Long getSalary() {
        return salary;
    }
}
