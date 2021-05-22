package test;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EjemploSoftAssert {

	SoftAssert softAssert = new SoftAssert();

	@Test
	public void sfAssertSelenium() {

		String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
		System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		String badTitle = "oraneHRM";

		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertEquals(actualTitle, badTitle);

		softAssert.assertAll();

	}
}
