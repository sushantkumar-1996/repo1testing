package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Drivers {
	public static WebDriver getDriver(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6b.00.10\\Desktop\\BROWSERS AND DRIVERS\\chromedriver.exe\\");
			return new ChromeDriver();
		}else if(browser.equals("firefox")){
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\training_b6b.00.10\\Desktop\\BROWSERS AND DRIVERS\\geckodriver.exe\\");
			  return new FirefoxDriver();
			
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\training_b6b.00.10\\Desktop\\BROWSERS AND DRIVERS\\IEDriverServer.exe\\");
			  return new InternetExplorerDriver();
		}else {
			return null;
		}
	}
 }

