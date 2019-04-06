package ru.xpendence.aviapersonal.parser.strategy;

import ru.xpendence.aviapersonal.parser.entity.AbstractEntity;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:48
 * e-mail: 2262288@gmail.com
 */
public interface Strategy<T extends AbstractEntity> {

    List<T> parse();
}
