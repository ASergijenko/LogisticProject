package com.logisticproject;

import com.logisticproject.domain.Cargo;
import com.logisticproject.services.excelService.ContainerToConsoleViewService;
import com.logisticproject.services.cargoSortingLogics.CargoSorting;
import com.logisticproject.services.excelService.ExcelReadingService;
import com.logisticproject.services.excelService.ExcelWritingService;
import com.logisticproject.services.excelService.TwoDArrayToImageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    @Autowired
    private TwoDArrayToImageConverter twoDArrayToImageConverter;

    public void execute() throws Exception {
        //Считывание из excel

//        String excelFilePath = "C:/Users/Grigorijs Skulteckis/Google Drive/Данные/Логистический вопрос/SampleData/Table_mnogo.xlsx";
//        String excelFilePath = "D:/Google Диск/Данные/Логистический вопрос/SampleData/Table_8fig.xlsx";
//        String excelFilePath = "C:/Users/aserg/Desktop/Logistics/multi.xlsx";
//        String excelFilePath = "C:/Users/aserg/Desktop/Logistics/Table.xlsx";

        //Ввод данных
        List<Cargo> cargoList = reader.read("src/main/resources/Table.xlsx");

        //Обработка
        Map<Integer, Double[][]> result = cargoSorting.cargoSortingProcess(cargoList);

        //Вывод данных
        writer.write(cargoList, "src/main/resources/resultsetttttttttt.xlsx");

        for (Cargo cargo : cargoList) {
            System.out.println(cargo.toString());
        }


        //Вывод данных
        result.forEach((key, value) -> {
            System.out.println("Container number: " + (key + 1));
            containerToConsoleViewService.printToConsole(value);

            twoDArrayToImageConverter.writeImage(value, "src/main/resources/" + "CN" + key + 1 + ".png");

            System.out.println();
        });
    }
}
