package com.logisticproject.services.excelService;

import org.springframework.stereotype.Component;

@Component
public class ContainerToConsoleViewService {

    public void printToConsole(Double[][] array) {
        for (Double[] doubles : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%5s", doubles[j]);
            }
            System.out.println();
        }
    }
}