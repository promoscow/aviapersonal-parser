package ru.xpendence.aviapersonal.parser.strategy;

import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.Airdrome;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:51
 * e-mail: 2262288@gmail.com
 */
@Service
public class AirdromeStrategy implements Strategy<Airdrome> {

    @Override
    public List<Airdrome> parse() {
        return null;
    }
}
