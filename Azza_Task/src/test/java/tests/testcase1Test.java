package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import base.baseClass;
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
				driver.navigate().to(URL);
				base = new baseClass(driver);
		}
		@Test
		public void case01() {
			base.enterText("Selenium Tutorial");
			base.clickSearch();
			base.clickFilterMenu();
			base.clickOnVedio(2);
			Assert.assertEquals(base.getVedioTitle(), base.getVedioName(2));
		}
//
//		@Test
//		public void case02() {
//			base.enterText("Test Automation Tutorial");
//			base.clickSearch();
//			base.clickFilterMenu();
//			base.clickOnVedio(2);
//			Assert.assertEquals(base.getVedioTitle(), base.getVedioName(2));
//		}
//
//		@Test
//		public void case03() {
//			base.enterText("Test Automation Tutorial");
//			base.clickSearch();
//			base.clickFilterMenu();
//			base.clickOnVedio(10);
//			Assert.assertEquals(base.getVedioTitle(), base.getVedioName(10));
//		}
		@AfterMethod
		public void NewTest_AfterClass() {
			base.closeDriver();
		}
}
