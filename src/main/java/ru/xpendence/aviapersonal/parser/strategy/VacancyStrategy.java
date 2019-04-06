package ru.xpendence.aviapersonal.parser.strategy;

import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.Vacancy;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:50
 * e-mail: 2262288@gmail.com
 */
@Service
public class VacancyStrategy implements Strategy<Vacancy> {

    @Override
    public List<Vacancy> parse() {
        return null;
    }
}
