package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screen_shot {
	public static void table_screenshot(WebDriver driver, String screen_shot_path) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFiles = scrShot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SrcFiles, new File(screen_shot_path));
	}

}
