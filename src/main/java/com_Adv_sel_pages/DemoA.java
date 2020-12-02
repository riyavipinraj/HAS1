package com_Adv_sel_pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoA 
{
    @Test
    public void TestA() throws InterruptedException
    {
    	WebDriverManager.chromedriver().setup();
    	
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("file:///C:\\Users\\Kees\\Documents\\brokenlinks.html");
	    WebElement link = driver.findElement(By.linkText("qspiders"));
	    Reporter.log("Element name ="+link.getText(),true);
	    
	    String href = link.getAttribute("href");
	    Reporter.log("Attribute value ="+href,true);
	    
	    try
	    {
	    	URL url =new URL("habfhdbfk");
	    	 HttpURLConnection con=(HttpURLConnection) url.openConnection();
	    	 
	    	 int status =con.getResponseCode();
	    	 Reporter.log("url status code ="+status,true);
	    	 if(status ==200)
	    	 {
	    		 Reporter.log("Link is broken...",true);
	    		 String message=con.getResponseMessage();
	    		 Reporter.log("Response message ="+message,true);
	    		 
	    	 }
	    	
	    }
	    catch(Exception e)
	    {
	    	Reporter.log("url is invalide...",true);
	    	
	    }
	    Thread.sleep(2000);
	    driver.close();
    }
    
    
}
