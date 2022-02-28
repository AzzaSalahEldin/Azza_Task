package core;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class coreClass {
	WebDriver driver;

	@FindBy(xpath = "//input[@name='search_query']")
	WebElement searchField;

	@FindBy(xpath = "//button[@aria-label='Search']")
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
	}

	public void enterText(String text) {
		searchField.sendKeys(text);
	}

	public void clickSearch() {
		searchButton.click();
	}

	public void clickFilterMenu() {
		filterMenu.click();
	}

	public void clickVedioButton() {
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
