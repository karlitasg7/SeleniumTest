package selenium;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practica {

	public static void main(String[] args) throws InterruptedException {
		String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
		System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().window().maximize();

		// Obteniendo objetos/webElement de la pagina web

		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));

		// login
		userName.sendKeys("Admin");
		Thread.sleep(3000);
		password.sendKeys("admin123");
		Thread.sleep(3000);
		loginBtn.click();

		// metodos del explorador

		String title = driver.getTitle();

		System.out.println("El titulo es: " + title);

		// obtener la url
		String urlDashboard = driver.getCurrentUrl();
		System.out.println("La url actual es: " + urlDashboard);

		boolean assigLeaveIsDisplayed = driver.findElement(By.className("quickLinkText")).isDisplayed();

		if (assigLeaveIsDisplayed) {
			System.out.println("La opcion Assign Leave esta desplegada");
		}

		// Obtener el texto
		String welcomeMsj = driver.findElement(By.id("welcome")).getText();

		if (welcomeMsj.contains("Paul")) {
			System.out.println("El mensaje tiene el nombre de paul");
		} else {
			System.out.println("ERROR el mensaje no es correcto");
		}

		// cerrando navegador web
		// driver.close(); // cierra la ventana actual que el drive esta utilizando

		driver.quit(); // cierra todas las ventanas del webdriver

	}

}
