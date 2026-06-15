package org.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook workbook;
	
	public static void loadExcel(String filePath) throws Exception {
		
		FileInputStream fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	public static String getCellData(String sheetName,int rowNo, int cellNo) {
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		if (sheet == null) {
			
			throw new RuntimeException("Sheet not found: " + sheetName);
		}
		
		Row row = sheet.getRow(rowNo);
        Cell cell = row.getCell(cellNo);
		
        DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell).trim();

	}
	
	public static void closeExcel() throws IOException {
		workbook.close();
    }
}
