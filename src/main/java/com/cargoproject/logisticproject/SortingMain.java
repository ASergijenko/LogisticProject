package com.cargoproject.logisticproject;

import com.cargoproject.logisticproject.domain.Cargo;
import com.cargoproject.logisticproject.services.cargoSortingLogics.CargoSorting;
import com.cargoproject.logisticproject.services.excelService.ContainerToConsoleViewService;
import com.cargoproject.logisticproject.services.excelService.ExcelReadingService;
import com.cargoproject.logisticproject.services.excelService.ExcelWritingService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Map;

@Component
public class SortingMain {

    @Autowired
    private ExcelReadingService reader;
    @Autowired
    private ExcelWritingService writer;
    @Autowired
    private CargoSorting cargoSorting;
    @Autowired
    private ContainerToConsoleViewService containerToConsoleViewService;

    public File execute(XSSFWorkbook file) throws Exception {
        //Ввод данных
        List<Cargo> cargoList = reader.read(file);

        //Обработка
        Map<Integer, Double[][]> result = cargoSorting.cargoSortingProcess(cargoList);

        //Вывод данных
        File calculatedFile = writer.write(cargoList, "src/main/resources/result.xlsx");

        for (Cargo cargo : cargoList) {
            System.out.println(cargo.toString());
        }

        //Вывод данных
        result.forEach((key, value) -> {
            System.out.println("Container number: " + (key + 1));
            containerToConsoleViewService.printToConsole(value);
            System.out.println();
        });
        return calculatedFile;
    }
}