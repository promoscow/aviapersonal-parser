package ru.xpendence.aviapersonal.parser.strategy;

import ru.xpendence.aviapersonal.parser.entity.Resume;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 15:11
 * e-mail: 2262288@gmail.com
 */
public interface Strategy {

    List<Resume> getResume();
}
