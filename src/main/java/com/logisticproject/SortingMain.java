package com.logisticproject;

import com.logisticproject.domain.Cargo;
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

    public void execute() throws Exception {

        //scitivanie iz excel
        String excelFilePath = "C:/Users/aserg/Desktop/Logistics/Table.xlsx";
        List<Cargo> cargoList = reader.read(excelFilePath);

        //logika sortirovki
        Map<Integer, Integer[][]> result = cargoSorting.cargoSortingProcess(cargoList);

        //vivod infi iz peremennih
        //...okay
    }

}
