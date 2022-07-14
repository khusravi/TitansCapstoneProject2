package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	/**
	 * This is parent class of all classes in this framework We define the
	 * properties of Webdriver, Log4J, Properties class so every class in this
	 * framework can inherit the property of this class and that is implementation
	 * of Inheritance concept of OOPS.
	 */
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private String configPath = ".\\src\\test\\resources\\input\\config.properties";
	private String log4jPath = ".\\src\\test\\resources\\input\\log4j.properties";

	/**
	 * we create a constructor to initialize the variables values from the 
	 * config.properties and log4jproperties files.
	 */
	public Base() {
		
		// we create object of BufferedReader class to read values from the config file	
		try {
			BufferedReader reader = new BufferedReader(new FileReader(configPath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger = logger.getLogger(log4jPath);
		
		////below line of code will configure the property of Log 4 J files.
		PropertyConfigurator.configure(log4jPath);
		
	}
//This method will return the value of url from config.properties file
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}
		
	//this method will retrun the value of browser from config.properties
	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}
	
	//this Method will open the selected browser
	public static void openBrowser() {
		driver.get(getUrl());
	}
	
	//this will close current all open browsers
	public static void tearDown() {
		driver.quit();
	}
		
	//this Method will let us use different browser applications
	public void selectBrowser(){
	switch(getBrowser()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	case "ff":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
	case "opera":
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	}
	//below three lines cod wil maximize the window and will wait for bage to load 
	//and will wait more if needed to do the task
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
