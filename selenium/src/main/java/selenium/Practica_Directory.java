package selenium;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practica_Directory {

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

		WebElement menuDirectory = driver.findElement(By.id("menu_directory_viewDirectory"));
		menuDirectory.click();

		WebElement txtSearchName = driver.findElement(By.id("searchDirectory_emp_name_empName"));
		txtSearchName.sendKeys("Nathan");

		WebElement btnSearch = driver.findElement(By.id("searchBtn"));
		btnSearch.click();

		String textResult = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[2]/td[2]/ul/li[1]/b"))
				.getText();

		if (textResult.contains("Nathan Elliot")) {
			System.out.println("Si lo encontro");
		} else {
			System.out.println("No lo encontro");
		}

		driver.quit();

	}

}
