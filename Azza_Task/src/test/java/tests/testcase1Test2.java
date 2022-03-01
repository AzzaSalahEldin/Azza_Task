package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.baseClass;
import core.ExcelData;
import core.setUpEnv;

public class testcase1Test2 {
	String URL = "https://www.youtube.com/";
	baseClass base;
	String filePath = "./Excel" + "\\" + "Test.xlsx";
	setUpEnv setup;
	@DataProvider(name = "testdata")
	public Object[][] testDataExample() throws InvalidFormatException, IOException {
		ExcelData configuration = new ExcelData();
		return configuration.readFromExcelBySheet(filePath, "Sheet2");
	}

	@BeforeMethod
	public void NewTest_BeforeClass() {
		setup=new setUpEnv();
		setup.openChromeBrowser(URL);
		base = new baseClass(setup.openChromeBrowser(URL));
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
	public void NewTest_AfterClass() {
		base.closeDriver();
	}
}