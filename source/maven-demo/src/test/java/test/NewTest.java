package test;


import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class NewTest {
	ChromeDriver driver;
	
	public NewTest() {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Resources\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
	}
	
  @BeforeClass
  
  public void beforeclass() {
	 
	
	 
	  driver.get("file:///C:/Users/jorge/Documents/courses/SQEDemoChallengeUI-master/src/test/resources/files/index.html");
	  
  }
  
  
  @Test
  public void happyPath() {
	  // select one simple option any field and submit.
	  
	  
	  Select pizzaStyle = new Select (driver.findElement(By.id("pizza1Pizza")));
	  pizzaStyle.selectByIndex(2);
	  
	  Select pizzaToppings1 = new Select (driver.findElement(By.xpath("//*[@id=\"pizza1\"]/select[2]")));
	  pizzaToppings1.selectByIndex(3);
	  
	  Select pizzaToppings2 = new Select (driver.findElement(By.xpath("//*[@id=\"pizza1\"]/select[3]")));
	  pizzaToppings2.selectByIndex(6);
	  
	  WebElement quantity = driver.findElement(By.id("pizza1Qty"));
	  quantity.clear();
	  quantity.sendKeys("1");
	  
	  
	  
	  WebElement name = driver.findElement(By.id("name"));
	  name.sendKeys("Robert Gaust");
	  
	  WebElement email = driver.findElement(By.id("email"));
	  email.sendKeys("robertg@gmail.com");
	  
	  WebElement phone = driver.findElement(By.id("phone"));
	  phone.sendKeys("98765431");
	  
	  WebElement creditPay = driver.findElement(By.id("ccpayment"));
	  creditPay.click();
	  
	  WebElement submit = driver.findElement(By.id("placeOrder"));
	  submit.click();
	  
	  
	  // Pop-up comparition
	  WebElement banner = driver.findElement(By.xpath("//*[@id=\"dialog\"]"));
	  String actual = banner.getText();
	  actual = actual.substring(0,5);
	  String expected = "Thank";
	  
	  
	  // Assertion
	  Boolean checkText = expected.equals(actual);
	  
	  assertTrue (checkText);
	  
	  
	  
	  
  }

@Test
public void breakOrder_One() {
	  // Missing name field and notice to user with pop-up message
	  
		  
		  Select pizzaStyle = new Select (driver.findElement(By.id("pizza1Pizza")));
		  pizzaStyle.selectByIndex(2);
		  
		  Select pizzaToppings1 = new Select (driver.findElement(By.xpath("//*[@id=\"pizza1\"]/select[2]")));
		  pizzaToppings1.selectByIndex(3);
		  
		  Select pizzaToppings2 = new Select (driver.findElement(By.xpath("//*[@id=\"pizza1\"]/select[3]")));
		  pizzaToppings2.selectByIndex(6);
		  
		  WebElement quantity = driver.findElement(By.id("pizza1Qty"));
		  quantity.clear();
		  quantity.sendKeys("1");		  
		  	  
		  WebElement email = driver.findElement(By.id("email"));
		  email.sendKeys("robertg@gmail.com");
		  
		  WebElement phone = driver.findElement(By.id("phone"));
		  phone.sendKeys("98765431");
		  
		  WebElement creditPay = driver.findElement(By.id("ccpayment"));
		  creditPay.click();
		  
		  WebElement submit = driver.findElement(By.id("placeOrder"));
		  submit.click();
		  
		  
		  // Pop-uop comparition
		  WebElement banner = driver.findElement(By.xpath("//*[@id=\"dialog\"]"));
		  String actual = banner.getText();
		  actual = actual.substring(0,12);
		  String expected = "Missing name";
		  
		  
		  // Assertion
		  Boolean checkText = expected.equals(actual);
		  
		  assertTrue (checkText);
		  
		  
		  
		  
		  
	}



@Test
public void breakOrder_Two() {
	  // Quantity is a negative number
	  		
		Boolean checkNumberIsValidate = true;
		int quantityNumber = 0;
		String quantityValor= "";
		  
		  Select pizzaStyle = new Select (driver.findElement(By.id("pizza1Pizza")));
		  pizzaStyle.selectByIndex(2);
		  
		  Select pizzaToppings1 = new Select (driver.findElement(By.xpath("//*[@id=\"pizza1\"]/select[2]")));
		  pizzaToppings1.selectByIndex(3);
		  
		  Select pizzaToppings2 = new Select (driver.findElement(By.xpath("//*[@id=\"pizza1\"]/select[3]")));
		  pizzaToppings2.selectByIndex(6);
		  
		  WebElement quantity = driver.findElement(By.id("pizza1Qty"));
		  quantity.clear();
		  quantity.sendKeys("-5");
		  quantityValor = "-5";
		  
		  
		  	  
		  WebElement email = driver.findElement(By.id("email"));
		  email.sendKeys("robertg@gmail.com");
		  
		  WebElement phone = driver.findElement(By.id("phone"));
		  phone.sendKeys("98765431");
		  
		  WebElement creditPay = driver.findElement(By.id("ccpayment"));
		  creditPay.click();
		  
		  WebElement submit = driver.findElement(By.id("placeOrder"));
		  submit.click();
		  
		  
		  // check if value of quantity is integer & no negative		  
		  
		  
		  try{
		        quantityNumber = Integer.parseInt(quantityValor);
		    }catch(Exception e ){
		    	checkNumberIsValidate =  false;
		    }
		   
		  
		  if(quantityNumber<1)
			  checkNumberIsValidate = false;
				  
		  
		  // Assertion		  
		  
		  assertTrue (checkNumberIsValidate);
		  	  
		  
		  
	}


@Test
public void reset_Checker() {
	  // Validate Reset button restart all selected fields
	  		
		Boolean resetOK = true;
		  
		  Select pizzaStyle = new Select (driver.findElement(By.id("pizza1Pizza")));
		  pizzaStyle.selectByIndex(2);
		  
		  Select pizzaToppings1 = new Select (driver.findElement(By.xpath("//*[@id=\"pizza1\"]/select[2]")));
		  pizzaToppings1.selectByIndex(3);
		  
		  Select pizzaToppings2 = new Select (driver.findElement(By.xpath("//*[@id=\"pizza1\"]/select[3]")));
		  pizzaToppings2.selectByIndex(6);
		  
		   
		  
		  WebElement reset = driver.findElement(By.id("reset"));
		  reset.click();
		  
		  
		  // check if filled fills are correct reseted
		
		  WebElement pizzaDropValue = pizzaStyle.getFirstSelectedOption();
		  
		  String valueZero = "Choose Pizza";
		  if(!pizzaDropValue.getText().equals(valueZero))
			  resetOK = false;
		  
		  WebElement toppingsDropValue = pizzaToppings1.getFirstSelectedOption();
		  
		  String valueZeroToppings = "Choose a Toppings 1";
		  if(!toppingsDropValue.getText().equals(valueZeroToppings))
			  resetOK = false;
		  
		  WebElement toppingsDropValue2 = pizzaToppings2.getFirstSelectedOption();
		  
		  String valueZeroToppings2 = "Choose a Toppings 2";
		  if(!toppingsDropValue2.getText().equals(valueZeroToppings2))
			  resetOK = false;
		  
		  
		  // Assertion		  
		  
		  assertTrue (resetOK);  
		  
		  
		  
		  
	}




@AfterClass
public void Afterclass() {
	 
	
	 
	  driver.quit();
	  
}
}
