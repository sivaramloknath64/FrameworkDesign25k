package PageTests;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;

import Utils.prop;

public class BaseTest {

	public WebDriver driver;
	public String browser;
	public String Url;
	prop p = new prop();

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {

		browser = p.getBrowser();
		Url=p.Urll();
		if (browser.toLowerCase().equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.toLowerCase().equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.toLowerCase().equals("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("No browser is defined");
		}
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {

		driver.quit();

	}

}
