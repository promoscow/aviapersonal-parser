package ru.xpendence.aviapersonal.parser.strategy;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import ru.xpendence.aviapersonal.parser.entity.EmployeeCount;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.04.19
 * Time: 17:52
 * e-mail: 2262288@gmail.com
 */
@Service
public class EmployeeCountStrategy implements Strategy<EmployeeCount> {
    private final static Logger log = Logger.getLogger(EmployeeCountStrategy.class.getName());

    private final static String FILE_URL = "http://www.gks.ru/free_doc/new_site/population/trud/trud1_15-72.xls";
    private final static int CONNECTION_TIMEOUT = 10000;
    private final static int READ_TIMEOUT = 20000;
    private final static String PATH_NAME = "trud1_15-72.xls";

    @Override
    public List<EmployeeCount> parse() {
        try {
            FileUtils.copyURLToFile(new URL(FILE_URL), new File(PATH_NAME), CONNECTION_TIMEOUT, READ_TIMEOUT);
            HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(PATH_NAME));
            HSSFSheet myExcelSheet = myExcelBook.getSheet("Год 15-72 лет ");

            Map<Integer, Integer> years = new HashMap<>();
            HSSFRow rowOfYears = myExcelSheet.getRow(4);

            for (Cell cell : rowOfYears) {
                if (Objects.nonNull(cell) && cell.getColumnIndex() > 0) {
                    try {
                        int year = (int) cell.getNumericCellValue();
                        years.put(year, cell.getColumnIndex());
                    } catch (NumberFormatException e) {
                        log.warning(String.format("Cell %s not parsed", String.valueOf(cell.getColumnIndex())));
                    }
                }
            }
            return years.entrySet()
                    .stream()
                    .flatMap(e -> parseByYear(e, myExcelSheet))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

    private Stream<EmployeeCount> parseByYear(Map.Entry<Integer, Integer> entry, HSSFSheet myExcelSheet) {
        List<EmployeeCount> result = new ArrayList<>();
        String federalDistrict = null;
        for (Row row : myExcelSheet) {
            int rowIndex = row.getRowNum();
            if (rowIndex >= 6) {
                String region = null;
                try {
                    region = row.getCell(0).getStringCellValue();
                } catch (NullPointerException e) {
                    log.info(String.format("%d: %d", entry.getKey(), result.size()));
                    return result.stream();
                }
                if (region.contains("федеральный округ")) {
                    federalDistrict = region;
                }
                if (!region.contains("в том числе")) {
                    EmployeeCount count = new EmployeeCount(
                            federalDistrict,
                            region,
                            getNumericCellValue(entry, row),
                            entry.getKey(),
                            region.contains("федеральный округ")
                    );
//                    log.info("{}", count.toString());
                    result.add(count);
                }
            }
        }
        log.info(String.format("%d: %d", entry.getKey(), result.size()));
        return result.stream();
    }

    private Double getNumericCellValue(Map.Entry<Integer, Integer> entry, Row row) {
        try {
            return row.getCell(entry.getValue()).getNumericCellValue();
        } catch (Exception e) {
            return null;
        }
    }
}
