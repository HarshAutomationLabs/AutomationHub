//package com.brightside.mentoring.utils;
//
//import java.util.ArrayList;
//
//import com.excel.utility.XLs_reader;
//
//public class ExcelTestUtils {
//
//	static XLs_reader reader;
//	
//	public static ArrayList<Object[]> getDataFromExcel() {
//		
//		ArrayList<Object[]> myData = new ArrayList<Object[]>();
//		try {
//			reader = new XLs_reader(System.getProperty("user.dir") + "");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		for(int rowNum=2; rowNum<=reader.getRowCount("sheetName"); rowNum++) {
//		
//			String colName = reader.getCellData("sheetName", "colName", 2);
//		
//			Object ob[]= {colName};
//			myData.add(ob);
//		}
//		return myData;
//	}
//}
