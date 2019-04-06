package ru.xpendence.aviapersonal.parser.strategy;

import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.EmployeeSalary;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:52
 * e-mail: 2262288@gmail.com
 */
@Service
public class EmployeeSalaryStrategy implements Strategy<EmployeeSalary> {

    @Override
    public List<EmployeeSalary> parse() {
        return null;
    }
}
