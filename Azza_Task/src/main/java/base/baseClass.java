package base;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import core.ExcelData;
import core.coreClass;

public class baseClass {

	coreClass c;

	public baseClass(WebDriver driver) {
		c = new coreClass(driver);
	}

	public void enterText(String text) throws InterruptedException {
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
	}

	public void closeDriver() {
		c.closeDriver();
	}

	public int getVedioNum(String numval) throws NumberFormatException, InvalidFormatException, IOException {
		int indexOfDecimal = String.valueOf(Double.parseDouble(numval)).indexOf(".");
		String value = String.valueOf(Double.parseDouble(numval)).substring(0, indexOfDecimal);
		int num = Integer.parseInt(value);
		return num;
	}
	@DataProvider(name = "testdata")
	public Object[][] readFromExcelBySheet(String filePath,String sheetName) throws IOException, InvalidFormatException {
		ExcelData objExcelFile = new ExcelData();
		return objExcelFile.readFromExcelBySheet(filePath,sheetName);

	}
	@DataProvider(name = "testdata2")
	public String readFromExcelByIndex(String sheetName, int row, int col) throws IOException, InvalidFormatException {
		ExcelData objExcelFile = new ExcelData();
		return objExcelFile.readFromExcelByIndex(sheetName, row, col);

	}
	
}