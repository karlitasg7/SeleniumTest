package searchTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.CommonMethods;
import driverSetup.DriverSetup;
import globalVariables.GlobalVariables;
import navigationPages.DashboardPage;
import navigationPages.DirectoryPage;
import navigationPages.LoginPage;

public class TC_02 {

	WebDriver driver = DriverSetup.setupDriver();

	// Page object
	LoginPage login = new LoginPage(driver);
	DashboardPage dashboard = new DashboardPage(driver);
	DirectoryPage directory = new DirectoryPage(driver);

	@BeforeTest
	public void startWebDriver() {

		driver.get(GlobalVariables.HOME_PAGE);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_02_Search_Natham() throws InterruptedException {
		login.login(GlobalVariables.USER_ADMIN, GlobalVariables.PASSWORD_ADMIN);

		dashboard.clickMenuDirectory();

		directory.searchByName("Nathan");

		directory.selectJobTitle("Sales Representative");

		directory.selectLocationTitle("1");

		directory.clickSearchBtn();

		boolean isUserDisplayed = directory.verifySearchName("Nathan");

		Assert.assertTrue(isUserDisplayed);
	}

	@AfterTest
	public void closeDriver() {
		CommonMethods.takeScreenshot(driver, "TC_02_Search_Natham");
		driver.quit();
	}

}
