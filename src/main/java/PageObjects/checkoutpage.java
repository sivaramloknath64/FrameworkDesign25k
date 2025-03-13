package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutpage{

	public WebDriver driver;

	public checkoutpage(WebDriver driver) {
	//	super(driver);

		 this.driver=driver;
		 PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".cart_item_label>a")
	private WebElement checkoutitems;
	//=driver.findElement(By.cssSelector(""));

	
	public void itemscheckout() {

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOf(this.checkoutitems));

		String j = this.checkoutitems.getText();
		System.out.println(j);
	}

}
