package com.logisticproject;

import com.logisticproject.domain.Cargo;
import com.logisticproject.services.ListSortingService;
import com.logisticproject.services.cargoSortingLogics.CargoSorting;
import com.logisticproject.services.cargoSortingLogics.Variables;
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
    private Variables variables;

    public void execute() throws Exception {

        //scitivanie iz excel
        String excelFilePath = "C:/Users/aserg/Desktop/Logistics/Table.xlsx";
        variables.cargoList = reader.read(excelFilePath);



        //logika sortirovki
        Map<Integer, Integer[][]> result = cargoSorting.cargoSortingProcess();

        //vivod infi iz peremennih
        //...okay
    }

}
