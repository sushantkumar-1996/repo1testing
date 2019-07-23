 package com.casestudy;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import testmeapp.utility.Drivers;


import java.io.IOException;
import java.util.Random;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {

ExtentHtmlReporter htmlReporter;
ExtentReports extent;
ExtentTest logger;
WebDriver driver;
String nameU;

 @BeforeTest
  public void startReportbeforeTest() {
   driver=Drivers.getDriver("chrome");
   htmlReporter= new ExtentHtmlReporter("C:\\Users\\training_b6b.00.10\\Desktop\\Reportfolder\\MyReport2.html");
   extent=new ExtentReports();
   extent.attachReporter(htmlReporter);
   driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
   driver.manage().window().maximize();
  
  }

  @Test(priority=3)
  public void testCart() throws InterruptedException {
	  
	  Actions act1=new Actions(driver);
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).perform();
	  Thread.sleep(2000);
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span"))).click().build().perform();
	  Thread.sleep(2000);
	  act1.moveToElement(driver.findElement(By.xpath("//span[@onclick='getProducts(11290,112101)']"))).click().build().perform();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
	  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
	  logger = extent.createTest("CART", "PASSED test case");
	  
	  
	  
	  
  
  }
  @Test(priority=2)
  public void testLogin() throws IOException, InterruptedException {
	 
	 Thread.sleep(5000);
  driver.findElement(By.id("userName")).sendKeys(nameU);
  driver.findElement(By.id("password")).sendKeys("hpkkk123");
 Thread.sleep(5000);
  driver.findElement(By.name("Login")).click();
  Thread.sleep(5000);
  logger = extent.createTest("LOGIN", "PASSED test case");
  }
  
  @Test(priority=4)
  public void testPayment() throws InterruptedException {
	 
	  driver.findElement(By.id("add1")).sendKeys("Bangalore");
	  driver.findElement(By.xpath("//input[@type='submit'and @value='Proceed to Pay']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[@onclick='radioValue()']")).click();
	  driver.findElement(By.xpath("//input[@name='username']")).click();
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@name='password']")).click();
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
	  driver.findElement(By.xpath("//input[@type='submit'and@value='LOGIN']")).click();
	  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
	  driver.findElement(By.xpath("//input[@type='submit'and@value='PayNow']")).click();
	  driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[2]")).click();
	  logger = extent.createTest("PAYMENT", "PASSED test case");
  }
  @Test(priority=1)
  public void testRegistration() throws InterruptedException {
	  logger = extent.createTest("REGISTRATION", "PASSED test case");
	 
	  Random rand = new Random();
	  int value1 = rand.nextInt(9999);
	  nameU="sush"+value1;
 driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
 driver.findElement(By.id("userName")).sendKeys(nameU);
 driver.findElement(By.id("firstName")).sendKeys("s");
 driver.findElement(By.id("lastName")).sendKeys("kumar");
 driver.findElement(By.id("password")).sendKeys("hpkkk123");
 driver.findElement(By.id("pass_confirmation")).sendKeys("hpkkk123");
 
 WebElement radio1=driver.findElement(By.xpath("//*[@id=\"gender\"]"));
 radio1.click();
 driver.findElement(By.id("emailAddress")).sendKeys("1225545666@gmail.com");
 driver.findElement(By.id("mobileNumber")).sendKeys("1234657899");
 driver.findElement(By.name("dob")).sendKeys("05/05/1998");
 driver.findElement(By.id("address")).sendKeys("blhh hhhh");
 driver.findElement(By.id("securityQuestion")).click();
 

 Thread.sleep(1000);
 Select sq=new Select(driver.findElement(By.id("securityQuestion")));
// Random rand = new Random();
 int value = rand.nextInt(3);
 sq.selectByIndex(value);
 Thread.sleep(3000);
 driver.findElement(By.name("answer")).sendKeys("monkey");
 driver.findElement(By.xpath("//input[@value='Register']")).click();
 
 
 
  }
  @AfterMethod
  public void getResultafterMethod(ITestResult result) {
	  
	  if(result.getStatus() == ITestResult.FAILURE) {
          logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
          logger.fail(result.getThrowable());
      }
      else if(result.getStatus() == ITestResult.SUCCESS) {
          logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
      }
	  
  }

 
  @AfterTest
  public void endReportafterTest() {
	  driver.close();
	  extent.flush();
  }

}