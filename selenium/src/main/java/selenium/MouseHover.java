package selenium;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {

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
		
		//admin menu mouse hover
		WebElement adminMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement nationalitiesSubMenu = driver.findElement(By.id("menu_admin_nationality"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(adminMenu).perform();
		Thread.sleep(3000);
		nationalitiesSubMenu.click();

	}

}
