package ru.xpendence.aviapersonal.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xpendence.aviapersonal.parser.entity.Resume;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:46
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
