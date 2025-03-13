package PageTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Homepage;
import PageObjects.LoginPage;
import PageObjects.checkoutpage;
import Utils.Exceutilss;
import Utils.Exclpract;

public class LoginTests extends BaseTest {

	@Test(groups = "regression")
	public void Loginpage() {
		LoginPage login = new LoginPage(driver);
		login.Loginmethod();
		Homepage home = new Homepage(driver);
		home.homepagelogo();
	}

	@Test(dependsOnMethods = { "Loginpage" })
	public void Itemsadd() {
		LoginPage login = new LoginPage(driver);
		login.Loginmethod();
		Homepage home = new Homepage(driver);
		home.homepagelogo();
		home.itemslist();
	}

	@Test(groups = "regression")
	public void checkoutpageverify() {

		LoginPage login = new LoginPage(driver);
		login.Loginmethod();
		Homepage home = new Homepage(driver);
		home.homepagelogo();
		home.itemslist();

		checkoutpage c = new checkoutpage(driver);
		c.itemscheckout();
	}

	@Test(dataProvider = "excels" )
	public void Excell(String Username, String Password) throws IOException {
		System.out.println(Username + "is" + Password);
	}

	
	
	@DataProvider(name = "excels")
	public String[][] testingdata() throws IOException {

		Exceutilss e = new Exceutilss();
		return e.ExcelReader();
	}

}
