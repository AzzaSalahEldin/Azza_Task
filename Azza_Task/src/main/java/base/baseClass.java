package base;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import core.ExcelData;
import core.coreClass;
import core.setUpEnv;

public class baseClass {

	coreClass core;
	setUpEnv setup;

	public baseClass(WebDriver driver) {
		core = new coreClass(driver);
		setup = new setUpEnv();
	}

	public void enterText(String text) throws InterruptedException {
		core.enterText(text);
	}

	public void clickSearch() {
		core.clickSearch();
	}

	public void clickFilterMenu() {
		core.clickFilterMenu();
	}

	public void clickVedioButton() {
		core.clickVedioButton();
	}

	public String getVedioName(int num) {
		return core.getVedioName(num);
	}

	public String getVedioTitle() {
		return core.getVedioTitle();
	}

	public void clickOnVedio(int num) {
		core.clickOnVedio(num);
	}

	public void closeDriver() {
		core.closeDriver();
	}

	public int getVedioNum(String numval) throws NumberFormatException, InvalidFormatException, IOException {
		int indexOfDecimal = String.valueOf(Double.parseDouble(numval)).indexOf(".");
		String value = String.valueOf(Double.parseDouble(numval)).substring(0, indexOfDecimal);
		int num = Integer.parseInt(value);
		return num;
	}

	@DataProvider(name = "testdata")
	public Object[][] readFromExcelBySheet(String filePath, String sheetName)
			throws IOException, InvalidFormatException {
		ExcelData objExcelFile = new ExcelData();
		return objExcelFile.readFromExcelBySheet(filePath, sheetName);

	}

	@DataProvider(name = "testdata2")
	public String readFromExcelByIndex(String sheetName, int row, int col) throws IOException, InvalidFormatException {
		ExcelData objExcelFile = new ExcelData();
		return objExcelFile.readFromExcelByIndex(sheetName, row, col);

	}

}