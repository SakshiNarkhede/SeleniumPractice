package seleniumpractice;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addingItemToCartEcommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String[] searchItems= {"Brocolli","Cauliflower","Cucumber"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		int j=0;
		List itemsToBeAdded=Arrays.asList(searchItems);
		List <WebElement> items=driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
		Thread.sleep(3000);
		for(int i=0;i<items.size();i++) {
			String[] name = items.get(i).getText().split("-");
			String nameUpdated=name[0].trim();
			if(itemsToBeAdded.contains(nameUpdated)) {
				j++;
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
				if(j==itemsToBeAdded.size()) {
					break;
				}
			}
				
		}
		Thread.sleep(3000);
		driver.close();


	}

}
