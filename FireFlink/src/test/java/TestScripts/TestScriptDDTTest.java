package TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScriptDDTTest {
@Test(dataProvider = "Sampledata")
public void test(String firstname,	String lastname )
{
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--headless");
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(opt);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.xpath("//a[@class='ico-login']")).click();
	driver.findElement(By.id("Email")).sendKeys(firstname);
	driver.findElement(By.id("Password")).sendKeys(lastname);
	driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	driver.quit();  
}
@DataProvider(name = "Sampledata", parallel=true)
public Object data() throws EncryptedDocumentException, IOException
{
	return DDT_practiceTest.readExcel("Sheet1");
}
}