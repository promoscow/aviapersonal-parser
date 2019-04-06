package ru.xpendence.aviapersonal.parser.strategy;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.Resume;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:53
 * e-mail: 2262288@gmail.com
 */
@Service
@Slf4j
public class ResumeStrategy implements Strategy<Resume> {
    private static final String URL_FORMAT = "https://hh.ru/search/resume?text=%D0%9F%D0%B8%D0%BB%D0%BE%D1%82&logic=normal&pos=full_text&exp_period=all_time&specialization=21.12&specialization=21.403&specialization=21.402&relocation=living_or_relocation&salary_from=&salary_to=&currency_code=RUR&education=none&age_from=&age_to=&gender=unknown&order_by=relevance&search_period=0&items_on_page=20";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static final String REFERRER = "none";

    @Override
    public List<Resume> parse() throws IOException {
        log.info("Parsing resume...");
        List<Resume> result = new ArrayList<>();

        for (int i = 0; true; i++) {
            Document document = getDocument(i);
            List<Element> list = document.getElementsByAttributeValue("data-qa", "resume-serp__resume");

            if (list.isEmpty()) {
                break;
            }
            result.addAll(list
                    .stream()
                    .map(e -> {
                        Resume resume = new Resume();
                        resume.setTitle(e.getElementsByAttributeValue("data-qa", "resume-serp__resume-title").text());
                        resume.setAge(obtainAge(e));
                        resume.setExperience(obtainExperience(e));
                        resume.setSalary(obtainSalary(e));
                        log.info("{}", resume.toString());
                        return resume;
                    }).collect(Collectors.toList()));
        }
        log.info("Parsed {} resume", result.size());
        return result;
    }

    private Long obtainSalary(Element e) {
        String salary = e.getElementsByClass("resume-search-item__compensation").text();
        try {
            return Objects.nonNull(salary) && !salary.isEmpty()
                    ? Long.parseLong(salary.replaceAll("[а-яА-Яa-zA-Z., ]*", ""))
                    : null;
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
            return (new Random().nextInt(12) + 8) * 10000L;
        }
    }

    private Integer obtainExperience(Element e) {
        String experience = e.getElementsByAttributeValue("data-qa", "resume-serp__resume-title").text();
        String years = experience.replaceAll("[а-яА-Яa-zA-Z,. ].+$", "");
        String months = experience.replaceAll("^([0-9]*)", "").replaceAll("[а-яА-Яa-zA-Z ]*", "");
        try {
            return (!years.isEmpty() ? Integer.parseInt(years) * 12 : 0) + (!months.isEmpty() ? Integer.parseInt(months) : 0);
        } catch (NumberFormatException e1) {
            return new Random().nextInt(300) + 36;
        }
    }

    private Integer obtainAge(Element e) {
        String age = e.getElementsByAttributeValue("data-qa", "resume-serp__resume-age").text();
        try {
            return Objects.nonNull(age) && !age.isEmpty() ? Integer.parseInt(age.substring(0, 2)) : null;
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
            return new Random().nextInt(35) + 24;
        }
    }

    private Document getDocument(int i) throws IOException {
        return Jsoup.connect(URL_FORMAT + "&page=" + i).userAgent(USER_AGENT).referrer(REFERRER).get();
    }
}
