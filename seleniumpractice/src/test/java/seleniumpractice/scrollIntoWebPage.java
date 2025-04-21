package seleniumpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollIntoWebPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		int sum = 0;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		Thread.sleep(3000);
		List<WebElement>amount=driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]//td[4]"));
		for(int i=0;i<amount.size();i++) {
			
		sum = sum + Integer.parseInt(amount.get(i).getText());
		}
		System.out.println(sum);
		driver.close();
		
	}

}
