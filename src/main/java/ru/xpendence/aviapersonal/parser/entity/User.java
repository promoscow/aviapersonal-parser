package ru.xpendence.aviapersonal.parser.entity;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:15
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "users")
@Setter
public class User extends AbstractEntity {

    private String name;
    private String password;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }
}
