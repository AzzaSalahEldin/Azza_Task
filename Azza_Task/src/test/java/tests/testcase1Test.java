package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import base.setup;

public class testcase1Test {
	
	@Parameters({ "browser"})
	@BeforeClass
	public void setupEnv(String browser)throws IOException {
		String url=null;
		setup.openBrowser(browser, url);
	}

}
