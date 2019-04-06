package ru.xpendence.aviapersonal.parser.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.Resume;
import ru.xpendence.aviapersonal.parser.repository.ResumeRepository;
import ru.xpendence.aviapersonal.parser.strategy.ResumeStrategy;

import java.io.IOException;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 18:39
 * e-mail: 2262288@gmail.com
 */
@Service
public class SchedulerService {

    private final ResumeStrategy resumeStrategy;
    private final ResumeRepository resumeRepository;

    @Autowired
    public SchedulerService(ResumeStrategy resumeStrategy,
                            ResumeRepository resumeRepository) {
        this.resumeStrategy = resumeStrategy;
        this.resumeRepository = resumeRepository;
    }

//    @Scheduled(cron = "0 * * * * ?")
//    @Scheduled(initialDelay = 5000, fixedDelay = 259200000)
    public void parseResume() throws IOException {
        List<Resume> resume = resumeStrategy.parse();
        if (!resume.isEmpty()) {
            resumeRepository.deleteAll();
            resumeRepository.saveAll(resume);
        }
    }
}
