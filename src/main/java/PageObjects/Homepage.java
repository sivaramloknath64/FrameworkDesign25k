package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public WebDriver driver;

	public Homepage(WebDriver driver) {
//	super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class='inventory_item_description']/div/a")
	private List<WebElement> items;

	 @FindBy(css = ".shopping_cart_link")
	private WebElement addcart ;
	 @FindBy(css = ".app_logo")
	private WebElement logo;
	 //= driver.findElement(By.cssSelector(".app_logo"));

	public void itemslist() {
		for (int i = 0; i < this.items.size(); i++) {
			List<WebElement> add = driver
					.findElements(By.xpath("//div[@class='inventory_item_description']/div/button"));
			if (items.get(i).getText().equals("Sauce Labs Bike Light")) {
				add.get(i).click();
			}
		}
		this.addcart.click();

	}

	public boolean homepagelogo() {

		return this.logo.isDisplayed();
	}

}
