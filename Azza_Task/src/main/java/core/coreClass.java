package core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class coreClass {
	WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	@FindBy(xpath = "//input[@name='search_query']")
	WebElement searchField;

	@FindBy(xpath = "//div[@id='filter-menu']//tp-yt-paper-button[@id='button']")
	WebElement filterMenu;

	@FindBy(xpath = "//yt-formatted-string[text()='Video']")
	WebElement vedioButton;

	@FindBy(xpath = "//ytd-video-renderer[@class='style-scope ytd-item-section-renderer']//a[@id='thumbnail']")
	List<WebElement> vedioList;

	@FindBy(xpath = "//ytd-video-renderer[@class='style-scope ytd-item-section-renderer']//div[@id='title-wrapper']//yt-formatted-string[@class='style-scope ytd-video-renderer']")
	List<WebElement> vedioName;

	@FindBy(xpath = "//div[@id='info-contents']//div[@id='container']//h1//yt-formatted-string[contains(@class,'ytd-video-primary-info-renderer')]")
	WebElement vedioTitle;

	public coreClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 200);
		actions = new Actions(driver);
	}

	public void enterText(String text) throws InterruptedException {
		searchField.sendKeys(text);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void clickSearch() {
		driver.findElement(By.id("search-icon-legacy")).click();
	}

	public void clickFilterMenu() {
		actions.moveToElement(filterMenu).click().build().perform();
	}

	public void clickVedioButton() {
		vedioButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public String getVedioName(int num) {
		return vedioName.get(num).getText();
	}

	public String getVedioTitle() {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(vedioTitle)));
		return vedioTitle.getText();
	}

	public void clickOnVedio(int num) {
		actions.moveToElement(vedioList.get(num)).click().build().perform();
	}

	public void closeDriver() {
		driver.close();
	}
}
