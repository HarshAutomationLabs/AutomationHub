##### Install Java Development Kit (jdk 1.8)
Go to oracle site - download the correct package for your OS and install it and after installing set up PATH environment variable appropriately.

##### Prerequisites
 * JDK 1.8
 * Maven 3+
	
##### Install TestNG in Eclipse IDE
 * Launch the Eclipse IDE and from Help menu, click “Install New Software”.
 * You will see a dialog window, click “Add” button.
 * Type TestNG - “http://beust.com/eclipse/”
 * You come back to the previous window but this time you must see TestNG option in the available software list. Just Click TestNG and press “Next” button.
 * Click “I accept the terms of the license agreement” then click Finish.
 * You may or may not encounter a Security warning, if in case you do just click OK.
 * Click Next again on the succeeding dialog box until it prompts you to Restart the Eclipse.
 * After restart, verify if TestNG was indeed successfully installed. Right click on you project and see if TestNG is displayed in the opened menu.

##### Install Drivers
 * Go to [selenium driver download](http://www.seleniumhq.org/download/) link.
 * Download drivers for Google Chrome Driver, Mozilla GeckoDriver etc compatible with the system configurations.
 * Add these drives in the "Driver" folder of the project directory.
 * Set the path for the Google Chrome Driver, Mozilla GeckoDriver etc inside "config.properties" file. For example:-
    * For linux system -> selenium.chrome.driver.path=Drivers/chromedriver
    * For Windows system -> selenium.chrome.driver.path=Drivers/chromedriver.exe

##### Execute Test Cases
 * Run the TestNG.xml file by Run as TestNG suit.

##### Note
 * Please comment out the browser parameter value if the particular browser is not present on the system.
 * Also, comment out the mobile test code in TestNG.xml file when running for web and vice versa.