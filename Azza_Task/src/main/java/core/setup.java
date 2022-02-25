package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class setup {
	public void openBrowser(String name,String url) {
		switch (name) {
		case "Chrome":
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get(url);
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			break;
		}

	}

	public static void closeBrowser(String name) {
		switch (name) {
		case "Chrome":
			WebDriver driver = new ChromeDriver();
			driver.quit();
			//WebDriverManager.chromedriver().quit();
			break;
		case "FireFox":
		//	WebDriverManager.firefoxdriver().quit();
			break;
		case "IE":
		//	WebDriverManager.iedriver().quit();
			break;
		}
	}

}
