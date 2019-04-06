package ru.xpendence.aviapersonal.parser.strategy;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:50
 * e-mail: 2262288@gmail.com
 */
@Service
@Slf4j
public class VacancyStrategy implements Strategy<Vacancy> {
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=%D0%9F%D0%B8%D0%BB%D0%BE%D1%82&specialization=21.12&specialization=21.403&specialization=21.402&area=1&salary=&currency_code=RUR&experience=doesNotMatter&order_by=relevance&search_period=&items_on_page=20&no_magic=true";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static final String REFERRER = "none";

    @Override
    public List<Vacancy> parse() {
        log.info("Parsing vacancies...");
        List<Vacancy> vacancies = new ArrayList<>();

        for (int i = 0; true; i++) {
            Document document;
            try {
                document = getDocument(i);
                List<Element> list = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (list.isEmpty()) {
                    break;
                }
                vacancies.addAll(
                        list
                                .stream()
                                .map(e -> {
                                    Vacancy vacancy = new Vacancy();
                                    vacancy.setTitle(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                                    vacancy.setCompany(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                                    vacancy.setCity(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                                    vacancy.setSalary(obtainSalary(e));
                                    log.info(vacancy.toString());
                                    return vacancy;
                                }).collect(Collectors.toList())
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("Vacancies parsed: {}", vacancies.size());
        return vacancies;
    }

    private Long obtainSalary(Element e) {
        String salary = e.getElementsByClass("vacancy-serp__vacancy-compensation").text();
        try {
            return Objects.nonNull(salary) && !salary.isEmpty()
                    ? Long.parseLong(salary.replaceAll("[а-яА-Яa-zA-Z., ]*", ""))
                    : (new Random().nextInt(12) + 8) * 10000L;
        } catch (NumberFormatException e1) {
            return (new Random().nextInt(12) + 8) * 10000L;
        }
    }

    private Document getDocument(int i) throws IOException {
        return Jsoup.connect(URL_FORMAT + "&page=" + i).userAgent(USER_AGENT).referrer(REFERRER).get();
    }
}
