package services;

import domain.Cargo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelParsingService {

    public List<Cargo> getCargoList(String excelFilePath) throws IOException {
        List<Cargo> cargoList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);

        for (Row nextRow : firstSheet) {
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Cargo aCargo = new Cargo();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 1:
                        aCargo.setTitle((String) getCellValue(nextCell));
                        break;
                    case 2:
                        aCargo.setAuthor((String) getCellValue(nextCell));
                        break;
                    case 3:
                        aCargo.setPrice((double) getCellValue(nextCell));
                        break;
                }


            }
            cargoList.add(aCargo);
        }

        workbook.close();
        inputStream.close();

        return cargoList;
    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }
}