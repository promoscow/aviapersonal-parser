package ru.xpendence.aviapersonal.parser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:26
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "airdromes")
public class Airdrome extends AbstractEntity {

    private String name;
    private String certificate;
    private String operator;
    private String grade;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "certificate")
    public String getCertificate() {
        return certificate;
    }

    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
