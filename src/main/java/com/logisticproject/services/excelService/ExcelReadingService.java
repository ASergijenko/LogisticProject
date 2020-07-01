package com.logisticproject.services.excelService;

import com.logisticproject.domain.Cargo;
import com.logisticproject.services.excelService.validations.CargoValidationService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Component
public class ExcelReadingService {

    @Autowired private CargoValidationService cargoValidationService;
    @Autowired private ListSortingService listSortingService;

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

    private boolean booleanCellValue(Object o) {
        return o.equals("yes");
    }

    private int integerCellValue(Object o) {
        return (int)(double)o;
    }

    private double doubleCellValue(Object o) {
        return (double)o;
    }

    public List<Cargo> read(String excelFilePath) throws Exception {
        List<Cargo> cargoList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);

        for (Row nextRow : firstSheet) {
            if (nextRow.getRowNum() == 0) {
                continue;
            }

            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Cargo cargo = new Cargo();

            while (cellIterator.hasNext()) {

                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        cargo.setCargoId(doubleCellValue(getCellValue(nextCell)));
                        break;
                    case 1:
                        cargo.setLength(integerCellValue(getCellValue(nextCell)));
                        break;
                    case 2:
                        cargo.setWidth(integerCellValue(getCellValue(nextCell)));
                        break;
                    case 3:
                        cargo.setHeight(integerCellValue(getCellValue(nextCell)));
                        break;
                    case 4:
                        cargo.setWeight(integerCellValue(getCellValue(nextCell)));
                        break;
                    case 5:
                        cargo.setStackable(booleanCellValue(Objects.requireNonNull(getCellValue(nextCell))));
                        break;
                    case 6:
                        cargo.setQuantity(integerCellValue(getCellValue(nextCell)));
                        break;
                    case 7:
                        cargo.setComments(String.valueOf(getCellValue(nextCell)));
                        break;
                }
            }
            cargo.setSquare();
            cargoValidationService.validate(cargo);
            cargoList.add(cargo);

            if (cargo.getQuantity() > 1) {
                int quantity = cargo.getQuantity();
                cargo.setQuantity(1);
                double id = cargo.getCargoId() + 0.01;
                for (int i = 1; i < quantity; i++) {
                    Cargo copiedCargo = cargo.clone();
                    double rounded = Math.round(id * 100.0)/100.0;
                    copiedCargo.setCargoId(rounded);
                    cargoList.add(copiedCargo);
                    id += 0.01;
                }
            }
        }

        cargoList = listSortingService.sort(cargoList);
        
        workbook.close();
        inputStream.close();

        return cargoList;
    }
}