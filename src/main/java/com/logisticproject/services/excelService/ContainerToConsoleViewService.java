package com.logisticproject.services.excelService;

import org.springframework.stereotype.Component;

@Component
public class ContainerToConsoleViewService {

    public void printToConsole(Integer[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                System.out.printf("%5d ", array[i][j]);
            }
            System.out.println();
        }
    }
}