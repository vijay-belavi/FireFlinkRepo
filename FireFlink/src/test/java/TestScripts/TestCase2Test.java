package TestScripts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2Test {
@Test
public void test(){
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));    
	driver.get("https://www.selenium.dev/");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	for (int i = 0; i <4; i++) {
	js.executeScript("window.scrollBy(0,1500)");
	}
	driver.findElement(By.xpath("//i[@class='fab fa-github']")).click();
	String p_id = driver.getWindowHandle();
	Set<String> c_id = driver.getWindowHandles();
	c_id.remove(p_id);
	for(String ch:c_id)
	{
		driver.switchTo().window(ch);
	}
	driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
	driver.findElement(By.xpath("//input[@name='login']")).sendKeys("vijaybelavi108@gmail.com");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("vijay1234");
	driver.findElement(By.xpath("//input[@name='commit']")).click();
	driver.quit();
}
}
