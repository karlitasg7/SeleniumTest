package navigationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Dashboard object
	@FindBy(id = "welcome")
	private WebElement welcomeDropDown;

	@FindBy(xpath = "//*[@id=\"welcome-menu\"]/ul/li[3]/a")
	private WebElement logoutBtn;

	@FindBy(id = "menu_directory_viewDirectory")
	private WebElement menuDirectory;

	public void logout() throws InterruptedException {
		welcomeDropDown.click();
		logoutBtn.click();

		Thread.sleep(3000);

	}

	public void clickMenuDirectory() {
		menuDirectory.click();
	}

}
