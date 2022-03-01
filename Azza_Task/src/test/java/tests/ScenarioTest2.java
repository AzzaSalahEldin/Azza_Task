package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ScreenShots.screen_shot;
import base.baseClass;
import core.ExcelData;
import core.setUpEnv;

public class ScenarioTest2 {
	String URL = "https://www.youtube.com/";
	baseClass base;
	String filePath = "./Excel" + "\\" + "Test.xlsx";
	setUpEnv setup;
	WebDriver driver;

	@DataProvider(name = "testdata")
	public Object[][] testDataExample() throws InvalidFormatException, IOException {
		ExcelData configuration = new ExcelData();
		return configuration.readFromExcelBySheet(filePath, "Sheet2");
	}

	@BeforeMethod
	public void scenarioTest2_BeforeMethod() {
		setup = new setUpEnv();
		driver = setup.openChromeBrowser(URL);
		base = new baseClass(driver);
	}

	@Test(dataProvider = "testdata")
	public void case01(String searchValue, String vedioNumber)
			throws IOException, InvalidFormatException, InterruptedException {
		base.enterText(searchValue);
		base.clickSearch();
		base.clickFilterMenu();
		base.clickVedioButton();
		String expected = base.getVedioName(base.getVedioNum(vedioNumber) - 1);
		base.clickOnVedio(base.getVedioNum(vedioNumber) - 1);
		String actual = base.getVedioTitle();
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void scenarioTest2_AfterMethod(ITestResult TestCaseResult) throws IOException {
		if (TestCaseResult.getStatus() == ITestResult.FAILURE) {
			screen_shot.table_screenshot(driver,
					".\\ScreenShotsfiles\\" + TestCaseResult.getName() + ".png");
			base.closeDriver();
		}
		else if (TestCaseResult.getStatus() == ITestResult.SUCCESS) {
			screen_shot.table_screenshot(driver,
					".\\ScreenShotsfiles\\" + TestCaseResult.getName() + ".png");
			base.closeDriver();
		}

	}
}