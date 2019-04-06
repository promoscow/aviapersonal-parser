package ru.xpendence.aviapersonal.parser.attribute;

import java.util.Arrays;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 13:43
 * e-mail: 2262288@gmail.com
 */
public enum ActiveType {
    DELETED(0),
    ENABLED(1);

    private Integer id;

    ActiveType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static ActiveType valueOf(Integer id) {
        return Arrays.stream(values())
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(ActiveType.DELETED);
    }
}
