package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
public WebDriver driver;

public LoginPage(WebDriver driver) {
	 //Initialize the elements on this page
	this.driver=driver;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}

	
	

	@FindBy(id="user-name")
	public WebElement username;
	//=driver.findElement(By.id(""));
	
	@FindBy(id="password")
	public WebElement Password;

	@FindBy(id="login-button")
	public WebElement Loginbutton;
	
	
	
	public void Loginmethod() {
	username.sendKeys("standard_user");
	Password.sendKeys("secret_sauce");
	Loginbutton.click();
	}
	

}
