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
 * Time: 17:26
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "airdromes")
@SQLDelete(sql = "UPDATE airdromes SET active = 0 WHERE id = ?")
@Where(clause = "active = 1")
@Setter
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
}
