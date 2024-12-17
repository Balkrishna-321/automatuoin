package Generic_utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excell_utility {

	
	public String getexceldata(String SheetName,int rowNum,int celNum ) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/framework1.xlsx");

		//step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
	
	   //step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet(SheetName);
	
		//step4:-taking Control of the rows
		Row row = sheet.getRow(rowNum);
	
		//step5:-taking Control of the cell
		Cell cel = row.getCell(celNum);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cel);
		//System.out.println(ExcelData);
		return ExcelData;
		
	}
	
	public Object[][] readfromexcelfordataprovider(String sheetname) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/framework1.xlsx");

		Workbook book = WorkbookFactory.create(fis);
	
		Sheet sheet = book.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum()+1;
		short lastcell = sheet.getRow(lastrow).getLastCellNum();
		
		Object[][] obj = new Object[lastrow][lastcell];
		
		for (int i = 0; i < lastrow + 1; i++) 
		{
			for (int j = 0; j < lastcell; j++) 
			{
			obj[i][j]=sheet.getRow(i).getCell(j).toString();	
			}
			
		}
		
		return obj;
		
	}
	
	
	
	
}
