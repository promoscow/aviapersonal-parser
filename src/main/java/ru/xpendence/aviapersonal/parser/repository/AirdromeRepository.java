package ru.xpendence.aviapersonal.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.aviapersonal.parser.entity.Airdrome;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:44
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface AirdromeRepository extends JpaRepository<Airdrome, Long> {
}
