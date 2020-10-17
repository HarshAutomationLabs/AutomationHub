package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadInputFromExcelSheet2 {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ReadInputFromExcelSheet2(String excelPath, String sheetName) throws IOException {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
	}

	public static void main(String[] args) throws IOException {
		getRowCount();
		getCellDataString(0, 0);
		getCellDataNumber(1, 1);
	}

	public static int getRowCount() throws IOException {
		int rowsCount = 0;
		rowsCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row count is " + rowsCount);
		return rowsCount;
	}

	public static int getColumnCount() throws IOException {
		int colCount = 0;
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Row count is " + colCount);
		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum) throws IOException {
		String cellData = null;
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(cellData);
		return cellData;
	}

	public static void getCellDataNumber(int rowNum, int colNum) throws IOException {
		sheet = workbook.getSheet("Sheet1");
		double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cellData);
	}

}
