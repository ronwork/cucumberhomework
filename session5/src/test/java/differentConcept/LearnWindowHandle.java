package differentConcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {
	WebDriver driver;
	
	@Test
	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title1=driver.getTitle();
		System.out.println(title1);
		String handle1 = driver.getWindowHandle();
		System.out.println(handle1);
		
		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		
		Thread.sleep(2000);
		String title2=driver.getTitle();
		System.out.println(title2);
		String handle2 = driver.getWindowHandle();
		System.out.println(handle2);
		
		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		
		
		
		Set<String> handle3=driver.getWindowHandles();
		System.out.println(handle3);
		
		for(String i : handle3) {
			System.out.println(i);
			driver.switchTo().window(i);
			
		}
		
		String title3=driver.getTitle();
		System.out.println(title3);
		
		
	}
	

}
