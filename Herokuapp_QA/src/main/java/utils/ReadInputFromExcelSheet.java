package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadInputFromExcelSheet {

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		// Create an object of File class to open xlsx file

		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook herokuWorkbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			herokuWorkbook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of HSSFWorkbook class

			herokuWorkbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		Sheet herokuSheet = herokuWorkbook.getSheet(sheetName);

		// Find number of rows in excel file

		int rowCount = herokuSheet.getLastRowNum() - herokuSheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it

		for (int i = 1; i < rowCount + 1; i++) {

			Row row = herokuSheet.getRow(i);

			String email = row.getCell(0).getStringCellValue();
			System.out.println("Email is: " + email);
			
			String password = row.getCell(1).getStringCellValue();
			System.out.println("Password is: " + password);
			
			String title = row.getCell(2).getStringCellValue();
			System.out.println("Product Title is: " + title);
			
			String sku = row.getCell(3).getStringCellValue();
			System.out.println("Product Sku is: " + sku);
			
			String desc = row.getCell(4).getStringCellValue();
			
			System.out.println("Product Description is: " + desc);
		}
	}

	// Main function is calling readExcel function to read data from excel file
	public static void main(String... strings) throws IOException {

		// Create an object of ReadGuru99ExcelFile class
		ReadInputFromExcelSheet objExcelFile = new ReadInputFromExcelSheet();

		// Prepare the path of excel file
		String filePath = "C:\\Users\\LT-273\\Desktop\\Harsh\\Herokuapp_QA\\";

		// Call read file method of the class to read data
		objExcelFile.readExcel(filePath, "Input_ExcelSheet.xlsx", "Sheet1");

	}

}