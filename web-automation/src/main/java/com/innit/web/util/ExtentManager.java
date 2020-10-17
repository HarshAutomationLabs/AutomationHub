package com.innit.web.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * 
 * @author Harsh Wardhan Gupta
 * 
 *         Class Extent report Configuration function.
 */
public class ExtentManager {
	public static ExtentReports extent;

	public static ExtentReports getInstance() {
		try {
			if (extent == null) {
				Date d = new Date();
				String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
				extent = new ExtentReports(System.getProperty("user.dir") + "/TestReport/" + fileName, false,
						DisplayOrder.OLDEST_FIRST);
				extent.loadConfig(new File(System.getProperty("user.dir") + "/ReportsConfig.xml"));
				extent.addSystemInfo("Selenium Version", "3.7.1").addSystemInfo("Environment", "Prod");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return extent;
	}
}