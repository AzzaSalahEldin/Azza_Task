package core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

	@FindBy(xpath = "//input[@name='search_query']")
	WebElement searchField;

	@FindBy(xpath = "//button[contains(@id,'search-icon-legacy')]")
	WebElement searchButton;

	@FindBy(xpath = "//div[@id='filter-menu']//tp-yt-paper-button[@id='button']")
	WebElement filterMenu;

	@FindBy(xpath = "//yt-formatted-string[text()='Video']")
	WebElement vedioButton;

	@FindBy(xpath = "//ytd-video-renderer[@class='style-scope ytd-item-section-renderer']//a[@id='thumbnail']")
	List<WebElement> vedioList;

	@FindBy(xpath = "//ytd-video-renderer[@class='style-scope ytd-item-section-renderer']//div[@id='title-wrapper']//yt-formatted-string[@class='style-scope ytd-video-renderer']")
	List<WebElement> vedioName;

	@FindBy(xpath = "//div[@id='info']//div[@id='container']//h1//yt-formatted-string[contains(@class,'ytd-video-primary-info-renderer')]")
	WebElement vedioTitle;

	public coreClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 15);
	}

	public void enterText(String text) {
		searchField.sendKeys(text);
	}

	public void clickSearch() {
		// wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		Actions actions = new Actions(driver);
		actions.moveToElement(searchButton).click().build().perform();
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}

	public void clickFilterMenu() {
		Actions actions = new Actions(driver);
		actions.moveToElement(filterMenu).click().build().perform();
		filterMenu.click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}

	public void clickVedioButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(vedioButton).click().build().perform();
		vedioButton.click();
	}

	public String getVedioName(int num) {
		String name = vedioName.get(num).getText();
		return name;
	}

	public String getVedioTitle() {
		String vedio_title = vedioTitle.getText();
		return vedio_title;
	}

	public void clickOnVedio(int num) {
		vedioList.get(num).click();
	}

	public void closeDriver() {
		driver.close();
	}
}
