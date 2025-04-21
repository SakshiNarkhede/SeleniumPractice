package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver=new ChromeDriver();
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		  WebElement drop=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		  Select dropindex=new Select(drop);
		  dropindex.selectByIndex(3);
		  dropindex.deselectByValue("INR");
		  driver.findElement(By.id("divpaxinfo")).click();
		  driver.findElement(By.id("hrefIncAdt")).click();
		  driver.findElement(By.id("btnclosepaxoption")).click();
		  driver.close();


	}

}
