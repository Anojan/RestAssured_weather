package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.ReadPropertiesHelper;



public class BasePage {
	protected static WebDriver driver ;
	WebDriverWait wait = new WebDriverWait(driver,30);
	ReadPropertiesHelper readProp = new ReadPropertiesHelper();
	Properties prop= readProp.readProperty();
	
	public void setUp(){
		driver=new ChromeDriver();
	}
	
	public void launchApp(){
		driver.get(prop.getProperty("url"));
	}
	
	public void clearSession(){
		driver.quit();
	}

}
