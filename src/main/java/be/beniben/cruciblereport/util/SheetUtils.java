package be.beniben.cruciblereport.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

@Service
public class SheetUtils {

    public static void createCell(Row row1, int pos, String cellValue, String cellStyle) {
        Cell cell1 = row1.createCell(pos);
        cell1.setCellValue(cellValue);
        cell1.setCellStyle(StyleLibrary.STYLES.get(cellStyle));
    }

    public static void createCell(Row row1, int pos, double cellValue, String cellStyle) {
        Cell cell1 = row1.createCell(pos);
        cell1.setCellValue(cellValue);
        cell1.setCellStyle(StyleLibrary.STYLES.get(cellStyle));
    }
}
