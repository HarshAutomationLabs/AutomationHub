package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String basePath = System.getProperty("user.dir");
	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 20;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					basePath + "\\src\\main\\java\\properties\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		try {
			String browserName = prop.getProperty("BROWSER");
			if (browserName.equals("chrome")) {
				System.out.println("Tried to " + browserName);
				System.setProperty("webdriver.chrome.driver", basePath + "\\chromedriver.exe");
				driver = new ChromeDriver(setChromeOptions());
			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", basePath + "\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if(browserName.equals("edge")) {
				System.setProperty("webdriver.edge.driver", basePath + "\\edgedriver.exe");
				driver = new EdgeDriver();
			}

			// Browser Properties
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("BASE_URL"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ChromeOptions setChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("disable-infobars");
		return options;
	}

	public void teardown() {
		driver.close();
		driver.quit();
		System.out.println("Closed the browser");
	}
}
