package core;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {

	@DataProvider(name = "azza")
	public String readExcel(String sheetName, int rowNum, int col) throws IOException, InvalidFormatException {
		String filePath = "C:\\Users\\asalah\\git\\Azza_Task\\Azza_Task\\Excel";
		File file = new File(filePath + "\\" + "Test.xlsx");
		Workbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheet(sheetName);
// int rowCount = sheet.getPhysicalNumberOfRows();
// int colCount = sheet.getRow(0).getLastCellNum();
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(col);
		String CellDate = null;
		if (cell.getCellType() == CellType.STRING) {
			CellDate = row.getCell(col).getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			CellDate = String.valueOf(cell.getNumericCellValue());
		}
//
		return CellDate;
// Object files[][] = new Object[rowCount][colCount];
// for (int i = 1; i < rowCount; i++) {
//
// for (int j = 0; j < colCount; j++) {
//
// Row row = sheet.getRow(i);
// Cell cell = row.getCell(i);
// if (cell.getCellType() == CellType.STRING) {
// String CellDate = row.getCell(j).getStringCellValue();
// files[i - 1][j] = CellDate;
// System.out.println(CellDate);
//
// } else if (cell.getCellType() == CellType.NUMERIC) {
// String CellDate = String.valueOf(cell.getNumericCellValue());
// files[i - 1][j] = CellDate;
// System.out.println(CellDate);
// }
//
// // String CellDate = row.getCell(j).getStringCellValue();
//
//// files[i - 1][j] = CellDate;
//// System.out.println(CellDate);
// }
// }

	}
}