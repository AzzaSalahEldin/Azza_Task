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

	@DataProvider(name = "azza")
	public String excel(String sheetName, int row, int col) throws IOException, InvalidFormatException {
		ExcelData objExcelFile = new ExcelData();
		return objExcelFile.readExcel(sheetName, row, col);

	}
	public int getVedioNum(int i, int j) throws NumberFormatException, InvalidFormatException, IOException {
		int indexOfDecimal = String.valueOf(Double.parseDouble(excel("Sheet1", i, j))).indexOf(".");
		String value = String.valueOf(Double.parseDouble(excel("Sheet1", i,j))).substring(0, indexOfDecimal);
		int num = Integer.parseInt(value);
		return num;
	}
}