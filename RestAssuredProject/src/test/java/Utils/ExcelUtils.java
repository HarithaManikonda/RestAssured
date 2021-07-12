package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static void main(String[] args)
	{
		getRowCount();
	}
	public ExcelUtils(String excelPath,String sheetName) 
	{
		String excelPath1="./ExcelData/Book2.xlsx";
		try {
			workbook=new XSSFWorkbook(excelPath1);
			sheet=workbook.getSheet(sheetName);
		}
		catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
		}
	}

	public static void getCellData(int rowNo,int cellNo)
	{

			DataFormatter formatter=new DataFormatter();
			Object value=formatter.formatCellValue(sheet.getRow(1).getCell(0));
			System.out.println(value);
		
	}
	public static void getRowCount()
	{
			int rowCount=sheet.getLastRowNum();
			System.out.println("No of Rows"+rowCount);
	}
	

}
