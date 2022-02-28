package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import core.coreClass;

public class baseClass {

	coreClass c;

	public baseClass(WebDriver driver) {
		c = new coreClass(driver);
	}

	public void enterText(String text){
		c.enterText(text);
	}

	public void clickSearch() {
		c.clickSearch();
	}

	public void clickFilterMenu() {
		c.clickFilterMenu();
	}

	public void clickVedioButton() {
		c.clickVedioButton();
	}

	public String getVedioName(int num) {
		return c.getVedioName(num);
	}

	public String getVedioTitle() {
		return c.getVedioTitle();
	}

	public void clickOnVedio(int num) {
		c.clickOnVedio(num);
		;
	}

	public void closeDriver() {
		c.closeDriver();
	}
}
