package com_Adv_sel_pages;



import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoB 
{

	@Test
	public void Testb() 
	{
        WebDriverManager.chromedriver().setup();
    	
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.selenium.dev/downloads/");
	    List<WebElement> alllinks = driver.findElements(By.tagName("a"));
	    Reporter.log("Total links present on the webpage ="+alllinks.size(),true);
	    for(WebElement link : alllinks)
	    {
	    	String text = link.getText();
	    	Reporter.log("link name="+text,true);
	    	String href=link.getAttribute("href");
	    	Reporter.log("Href value ="+href,true);
	    	
	    	try
	    	{
	    		URL url =new URL(href);
	    		HttpURLConnection con =(HttpURLConnection) url.openConnection();
	    		int code =con.getResponseCode();
	    		if(code ==200)
	    		{
	    			Reporter.log("Link is not broken...",true);
	    		}
	    		else
	    		{
	    			Reporter.log("Url code ="+code,true);
	    			Reporter.log("Link is broken...........",true);
	    			String message=con.getResponseMessage();
	    			Reporter.log("broken link message ="+message,true);
	    			
	    			
	    		}
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		Reporter.log("Invalid url....",true);
	    		
	    	}
	    	Reporter.log("..............................",true);
	    	
	    	
	    }
		driver.close();
	}
	
	
	
	
}
