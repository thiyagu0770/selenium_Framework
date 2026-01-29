package og.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriventask {
	
	
	public static void main(String[] args) throws Exception {
		
		File f = new File("D:\\DOC\\Testing-Workspace\\Selenium-Framework\\excel\\Data.xlsx");
		
		// To read a file
		FileInputStream fis = new FileInputStream(f);
		
		Workbook w  = new XSSFWorkbook(fis);
		
		//workbook -->sheet -->row-->cell-->data
		//to get sheet from workbook interface
		Sheet s = w.getSheet("Hotel");
		
		/*// to get row from sheet interface
		Row r = s.getRow(1);
		System.out.println(r);
		
		// to get cell from row interface
		Cell c = r.getCell(0);
		System.out.println(c);*/
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				
				// to get the type
				int cellType = c.getCellType();
				
				if (cellType==1) {
					
					String value = c.getStringCellValue();
					System.out.println(value);
					
				}else if (DateUtil.isCellDateFormatted(c)) {
					
					Date dd = c.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
					String value = sdf.format(dd);
					System.out.println(value);
					
				}else {
					
					double d = c.getNumericCellValue();
					long l = (long) d;
					String value = String.valueOf(l);
					System.out.println(value);
					
				}
				
				
				
			}
		}
		
		
	}

}
