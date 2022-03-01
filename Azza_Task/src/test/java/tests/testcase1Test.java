package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.baseClass;
import core.ExcelData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testcase1Test {
	String URL = "https://www.youtube.com/";
	baseClass base;

	@BeforeMethod
	public void NewTest_BeforeClass() {
		WebDriver driver;
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
		base = new baseClass(driver);
	}

	@Test
	public void case01() throws IOException, InvalidFormatException, InterruptedException {
		base.enterText(base.excel("Sheet1", 1, 0));
		base.clickSearch();
		base.clickFilterMenu();
		base.clickVedioButton();
		String expected = base.getVedioName(base.getVedioNum(1, 1) - 1);
		base.clickOnVedio(base.getVedioNum(1, 1) - 1);
		String actual=base.getVedioTitle();
		Assert.assertEquals(actual, expected);
	}

//	@Test
//	public void case02() throws IOException, InvalidFormatException {
//		base.enterText(base.excel("Sheet1", 2, 0));
//		base.clickSearch();
//		base.clickFilterMenu();
//		base.clickVedioButton();
//		String expected = base.getVedioName(base.getVedioNum(1, 1) - 1);
//		base.clickOnVedio(base.getVedioNum(1, 1) - 1);
//		Assert.assertEquals(base.getVedioTitle(), expected);
//	}

//	@Test
//	public void case03() throws IOException, InvalidFormatException {
//		base.enterText(base.excel("Sheet1", 1, 0));
//		base.clickSearch();
//		base.clickFilterMenu();
//		base.clickVedioButton();
//		String expected = base.getVedioName(base.getVedioNum(1, 1) - 1);
//		base.clickOnVedio(base.getVedioNum(2, 1) - 1);
//		Assert.assertEquals(base.getVedioTitle(), expected);
//	}

	@AfterMethod
	public void NewTest_AfterClass() {
		base.closeDriver();
	}
}