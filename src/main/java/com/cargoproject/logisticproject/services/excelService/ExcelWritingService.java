package com.cargoproject.logisticproject.services.excelService;

import com.cargoproject.logisticproject.domain.Cargo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelWritingService {

    public File write(List<Cargo> cargoList, String excelFilePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        //headings
        Row row = sheet.createRow(0);
        for (int i = 0; i < 10; i++) {
            Cell cell = row.createCell(i);

            switch(i) {
                case 0:
                    cell.setCellValue("CargoID");
                    break;
                case 1:
                    cell.setCellValue("Container Number");
                    break;
                case 2:
                    cell.setCellValue("Length");
                    break;
                case 3:
                    cell.setCellValue("Width");
                    break;
                case 4:
                    cell.setCellValue("Height");
                    break;
                case 5:
                    cell.setCellValue("Weight");
                    break;
                case 6:
                    cell.setCellValue("isStackable");
                    break;
                case 7:
                    cell.setCellValue("Quantity");
                    break;
                case 8:
                    cell.setCellValue("Comments");
                    break;
            }
        }

        for (int i = 0; i < cargoList.size(); i++) {
            row = sheet.createRow(i + 1);
            Cargo cargo = cargoList.get(i);

            for (int j = 0; j < 9; j++) {
                Cell cell = row.createCell(j);
                switch(j) {
                    case 0:
                        double charAtZero = Double.parseDouble(Character.toString(Double.toString(cargo.getCargoId()).charAt(0)));
                        if (cargo.getCargoId() - charAtZero > 0) {
                            cell.setCellValue(cargo.getCargoId());
                        } else {
                            cell.setCellValue(charAtZero);
                        }
                        break;
                    case 1:
                        cell.setCellValue(cargo.getContainerNumber());
                        break;
                    case 2:
                        cell.setCellValue(cargo.getLength());
                        break;
                    case 3:
                        cell.setCellValue(cargo.getWidth());
                        break;
                    case 4:
                        cell.setCellValue(cargo.getHeight());
                        break;
                    case 5:
                        cell.setCellValue(cargo.getWeight());
                        break;
                    case 6:
                        cell.setCellValue(cargo.isStackable());
                        break;
                    case 7:
                        double charAtZeroSecond = Double.parseDouble(Character.toString(Double.toString(cargo.getCargoId()).charAt(0)));
                        if (cargo.getCargoId() - charAtZeroSecond > 0) {
                            int calculatedValue = Integer.parseInt(cargo.getCargoId().toString().substring(2));
                            cell.setCellValue(calculatedValue + "/" + cargo.getQuantity());
                        } else {
                            cell.setCellValue(cargo.getQuantity() + "/" + cargo.getQuantity());
                        }
                        break;
                    case 8:
                        cell.setCellValue(cargo.getComments());
                        break;
                }
            }
        }
        File xlsx = new File("cargolist.xlsx");
        try (FileOutputStream outputStream = new FileOutputStream(xlsx)) {
            workbook.write(outputStream);
        }
        return xlsx;
    }
}