package com.logisticproject;

import com.logisticproject.domain.Cargo;
import com.logisticproject.services.ContainerToConsoleViewService;
import com.logisticproject.services.cargoSortingLogics.CargoSorting;
import com.logisticproject.services.excelService.ExcelReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SortingMain {

    @Autowired
    private ExcelReadingService reader;
    @Autowired
    private CargoSorting cargoSorting;
    @Autowired
    private ContainerToConsoleViewService containerToConsoleViewService;

    public void execute() throws Exception {

        //scitivanie iz excel
//        String excelFilePath = "C:/Users/Grigorijs Skulteckis/Google Drive/Данные/Логистический вопрос/SampleData/Table.xlsx";
        String excelFilePath = "D:/Google Диск/Данные/Логистический вопрос/SampleData/Table.xlsx";

        List<Cargo> cargoList = reader.read(excelFilePath);

                        System.out.println("read completed");

        //logika sortirovki
        Map<Integer, Integer[][]> result = cargoSorting.cargoSortingProcess(cargoList);

                        System.out.println("logic started");

        //vivod infi iz peremennih

                        System.out.println("result printing");

        containerToConsoleViewService.printToConsole(result.get(0));
        result.forEach((key, value) -> {
            System.out.println(key);
            containerToConsoleViewService.printToConsole(value);
        });

        //...okay
    }

}
