package og.data;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriventask {

    public static void main(String[] args) throws Exception {

        File f = new File("D:\\DOC\\Testing-Workspace\\Selenium-Framework\\excel\\Data.xlsx");
        FileInputStream fis = new FileInputStream(f);
        
        // Use try-with-resources to ensure the workbook closes properly
        Workbook w = new XSSFWorkbook(fis);
        Sheet s = w.getSheet("Hotel");

        for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
            Row r = s.getRow(i);
            if (r == null) continue; // Skip empty rows to avoid NullPointerException

            for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
                Cell c = r.getCell(j);
                if (c == null) continue; // Skip empty cells

                // FIX 1: Compare cellType using the CellType Enum, not an integer
                CellType cellType = c.getCellType();

                if (cellType == CellType.STRING) {
                    String value = c.getStringCellValue();
                    System.out.print(value + "\t");

                } else if (cellType == CellType.NUMERIC) {
                    // FIX 2: Check for date formatting inside the Numeric check
                    if (DateUtil.isCellDateFormatted(c)) {
                        Date dd = c.getDateCellValue();
                        // FIX 3: Use "MM" (capital) for Months. "mm" is for minutes!
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        String value = sdf.format(dd);
                        System.out.print(value + "\t");
                    } else {
                        double d = c.getNumericCellValue();
                        long l = (long) d;
                        String value = String.valueOf(l);
                        System.out.print(value + "\t");
                    }
                }
            }
            System.out.println(); // New line after each row
        }
        w.close(); // Close the workbook to free memory
    }
}