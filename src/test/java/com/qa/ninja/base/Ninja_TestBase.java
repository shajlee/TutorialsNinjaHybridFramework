package com.qa.ninja.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.ninja.utilities.Ninja_Utilities;

public class Ninja_TestBase {
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public static Properties prop;
	public static Properties dataprop;
	
	public Ninja_TestBase() throws Exception {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\ninja\\propertiesfiles\\configurations.properties");
		prop.load(ip);
		
		dataprop = new Properties();
		FileInputStream ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\ninja\\propertiesfiles\\testData.properties");
		dataprop.load(ip1);
	}
	public WebDriver initializeBrowser(String browserName) {
		if(browserName.equalsIgnoreCase(prop.getProperty("browserName1"))) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			driver = new ChromeDriver(optionsC);
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase(prop.getProperty("browserName2"))) {
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			driver = new FirefoxDriver(optionsF);
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase(prop.getProperty("browserName3"))) {
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			driver = new EdgeDriver(optionsE);
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Ninja_Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Ninja_Utilities.PAGELOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Ninja_Utilities.SCRIPTLOAD_TIME));
		return driver;
		
		}
				
	}
	


