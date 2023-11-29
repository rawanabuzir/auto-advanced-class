//try num two (11/29/2023)
package iteams;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iteamsPrices extends parameters {

	WebDriver driver  =new ChromeDriver();// rawan here we initializes a WebDriver object 'driver' for Google Chrome.
		@BeforeTest
		public void SetUp() { // webdriver setup *_*
			driver.manage().window().maximize();
			driver.get(URL);
			WebElement userName=driver.findElement(By.id("user-name"));
			WebElement passWord=driver.findElement(By.id("password"));
			WebElement logIn=driver.findElement(By.id("login-button"));
			userName.sendKeys(name);
			passWord.sendKeys(password);
			logIn.click();
			}
		@Test()
		public void PriceReview() {
			List <WebElement>Iteamprices =driver.findElements
			(By.className("inventory_item_price"));
			for (int i=0;i<Iteamprices.size();i++)
			{
			//here what we did is Iterate through the list of prices then i extract the price text then remove the doller sighn and at the end convert it to a double
			String	PriceAfterTax=Iteamprices.get(i).getText().replace("$","");
			Double price =Double.parseDouble(PriceAfterTax);
			// add 10% to the price&&round the price 
			price+=(price*.10);
			Double endprice=price ;
			double roundedPrice = Math.ceil(endprice);
			//if statement (please let the output to be based on the value of the final price after the tax )
			int endPrice =r oundedPrice % 2 ;
			if (endPrice == 0){
				System.out.println("price is an even number &&  value =( "+endprice+" ) ");
			}
			else{
				System.out.println("price is an odd number &&  value = ( "+endprice+" )");
			}}
			}
			@AfterTest
		public void PostTest () => driver.quit(); 
		//try to do it with anonumis function syntax &&
		// and this function rols is : lose the WebDriver instance
	}
////////////////////////////////////************///////////////////////////////////////////
	class parameters {
		static String URL = "https://www.saucedemo.com/v1/";
		static String name = "locked_out_user";
		static String password = "secret_sauce";
	}



//to stady later :
//@BeforeTest, meaning it will run before the actual test methods.
// It maximizes the browser window, opens the specified URL, and performs a simple login by locating the usernam.
// password, and login button elements and interacting with them.
//@AfterTest, meaning it will run after the test methods. It quits the WebDriver instance, effectively closing the browser

////////////////////////////////////************///////////////////////////////////////////