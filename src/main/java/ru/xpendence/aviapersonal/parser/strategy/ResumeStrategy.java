package ru.xpendence.aviapersonal.parser.strategy;

import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.Resume;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:53
 * e-mail: 2262288@gmail.com
 */
@Service
public class ResumeStrategy implements Strategy<Resume> {

    @Override
    public List<Resume> parse() {
        return null;
    }
}
