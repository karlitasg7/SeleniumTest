package selenium;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticaDropDown {

	public static void main(String[] args) {

		String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
		System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));

		// login
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		loginBtn.click();

		WebElement assignLeave = driver.findElement(By.className("quickLinkText"));
		assignLeave.click();

		// declarando Webelement tipo dropdown
		Select dropdownLeaveType = new Select(driver.findElement(By.id("assignleave_txtLeaveType")));
		dropdownLeaveType.selectByVisibleText("US - FMLA");

	}

}
