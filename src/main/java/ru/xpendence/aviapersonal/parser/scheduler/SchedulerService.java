package ru.xpendence.aviapersonal.parser.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.Resume;
import ru.xpendence.aviapersonal.parser.entity.Vacancy;
import ru.xpendence.aviapersonal.parser.repository.ResumeRepository;
import ru.xpendence.aviapersonal.parser.repository.VacancyRepository;
import ru.xpendence.aviapersonal.parser.strategy.ResumeStrategy;
import ru.xpendence.aviapersonal.parser.strategy.VacancyStrategy;

import java.io.IOException;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 18:39
 * e-mail: 2262288@gmail.com
 */
@Service
@Slf4j
public class SchedulerService {

    private final ResumeStrategy resumeStrategy;
    private final ResumeRepository resumeRepository;
    private final VacancyStrategy vacancyStrategy;
    private final VacancyRepository vacancyRepository;

    @Autowired
    public SchedulerService(ResumeStrategy resumeStrategy,
                            ResumeRepository resumeRepository,
                            VacancyStrategy vacancyStrategy,
                            VacancyRepository vacancyRepository) {
        this.resumeStrategy = resumeStrategy;
        this.resumeRepository = resumeRepository;
        this.vacancyStrategy = vacancyStrategy;
        this.vacancyRepository = vacancyRepository;
    }

//    @Scheduled(cron = "0 * * * * ?")
//    @Scheduled(initialDelay = 10000, fixedDelay = 259200000)
    public void parseResume() throws IOException {
        List<Resume> resume = resumeStrategy.parse();
        if (!resume.isEmpty()) {
            resumeRepository.deleteAll();
            resumeRepository.saveAll(resume);
        }
        log.info("{} resume saved to database", resume.size());
    }

//    @Scheduled(cron = "0 * * * * ?")
//    @Scheduled(initialDelay = 5000, fixedDelay = 259200000)
    public void parseVacancy() {
        List<Vacancy> vacancies = vacancyStrategy.parse();
        if (!vacancies.isEmpty()) {
            vacancyRepository.deleteAll();
            vacancyRepository.saveAll(vacancies);
        }
        log.info("{} vacancies saved to database", vacancies.size());
    }
}
