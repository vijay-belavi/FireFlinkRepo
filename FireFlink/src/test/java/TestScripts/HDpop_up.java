package TestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HDpop_up {
@Test
public void test() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.redbus.in/");
	driver.findElement(By.xpath("//label[.='Date']")).click();
	driver.findElement(By.xpath("//td[.='16']")).click();
	Thread.sleep(2000);
	driver.quit();
}
}
