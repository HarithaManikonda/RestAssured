package Utils;

public class ExcelUtilsTest {
	public static void main(String[] args) {
		
		String excelpath="./ExcelData/Book2.xlsx";
		String sheetName="Sheet1";
		ExcelUtils excel=new ExcelUtils(excelpath,sheetName);
		excel.getRowCount();
		excel.getCellData(1,0);
		excel.getCellData(1,1);
		
	}

}
