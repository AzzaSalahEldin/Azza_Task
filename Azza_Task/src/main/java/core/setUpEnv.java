package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class setUpEnv {
	public WebDriver openChromeBrowser(String URL) {
		WebDriver driver;
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
		return driver;
	}

	public WebDriver openFirefoxBrowser(String URL) {
		WebDriver driver;
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver(firefoxOptions);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
		return driver;
	}
}
