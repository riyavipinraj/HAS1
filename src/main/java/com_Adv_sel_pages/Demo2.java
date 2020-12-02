package com_Adv_sel_pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 
{
	@Test
	public void samplePage() throws InterruptedException
	{
		 WebDriverManager.chromedriver().setup();
			
		    WebDriver driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("file:///C:/Users/Kees/Downloads/SVG.html");
		    List<WebElement> AllElements = driver.findElements(By.xpath("//*"));
		    Reporter.log("All Elements :"+AllElements.size(),true);
		    int count=0;
		    Actions act=new Actions(driver);
		    for(WebElement line : AllElements)
		    {
		    	String tName = line.getTagName();
		    	if(tName.equals("line"))
		    	{
		    		Thread.sleep(2000);
		    	    count++;	
		    	    
		    	    String bforecolour=line.getCssValue("stroke");
		    	    Reporter.log("Before placing the cursor:"+bforecolour,true);
		    	    
		    	    act.moveToElement(line).perform();
		    	    
		    	    String aforecolour=line.getCssValue("stroke");
		    	    Reporter.log("After placing the cursor:"+aforecolour,true);
		    	    Reporter.log("-------------------------------------------------------------------",true);
		    	    
		    	    WebElement tooltip = line.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
		    	    
		    	    String text = tooltip.getText();
		    	    Reporter.log("Tooltip information :"+text,true);
		    	    
		    	    Reporter.log("============================================================");
		    	    
		    	    
		    	    
		    	    
		    	}
		    }
		    Reporter.log("Number of lines present on the webpage:"+count,true);
		    Thread.sleep(2000);
		    driver.close();
	}

}
