package utils;

import java.io.IOException;

public class ExcelDataProvider {
	
	public static void main(String[] args) throws IOException {
		String projectPath = System.getProperty("user.dir");
		String path = projectPath + "/Input_ExcelSheet.xlsx";
		testData(path, "Sheet1");
	}
	public static void testData(String excelPath, String sheetName) throws IOException {
//		
		
		ReadInputFromExcelSheet2 excel = new ReadInputFromExcelSheet2(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String data = excel.getCellDataString(i, j);
				System.out.println(data);
			}
		}
	}
}
