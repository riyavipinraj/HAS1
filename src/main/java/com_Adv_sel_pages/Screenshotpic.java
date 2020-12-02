package com_Adv_sel_pages;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshotpic 
{
 
	@Test
	public void Demopic() throws Exception
	{
WebDriverManager.chromedriver().setup();
		
   	    WebDriver driver=new ChromeDriver();
   	    
   	    driver.manage().window().maximize();
   	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	    driver.get("https://skillrary.com/qjtncq");
   	    
   	    TakesScreenshot ts = (TakesScreenshot) driver;
   	    File src=ts.getScreenshotAs(OutputType.FILE);
   	    Files.copy(src, new File("./Demo.png"));
   	    
   	    WebElement img =driver.findElement(By.xpath("//div[@class='image']"));
   	    
   	    int x=img.getLocation().getX();
   	    int y=img.getLocation().getY();
   	    int h=img.getSize().getHeight();
   	    int w=img.getSize().getWidth();
   	    
   	    BufferedImage orgimg= ImageIO.read(new File("./Demo.png"));
   	    BufferedImage subimg=orgimg.getSubimage(x, y, w, h);
   	    
   	    ImageIO.write(subimg, "png", new File("./D.png"));
		
   	    BufferedImage aimg= ImageIO.read(new File("./Demo.png"));
   	    BufferedImage eimg= ImageIO.read(new File("./D.png"));
   	    
   	   DataBuffer aimgpix= aimg.getData().getDataBuffer();
   	   DataBuffer eimgpix=eimg.getData().getDataBuffer();
   	   
   	   int apixcount=aimgpix.getSize();
   	   int epixcount=eimgpix.getSize();
   	   
   	   Reporter.log("Actuall pixel count.."+apixcount,true);
   	   Reporter.log("Expected pixel count..."+epixcount,true);
   	   
   	   int matchcount=0;
   	   int count=0;
   	   
   	   if(apixcount>epixcount)
   	   {
   		   count=epixcount;
   	   }
   	   else
   	   {
   		   count=apixcount;
   	   }
   	   for(int i=0;i<count;i++)
   	   {
   		   if(aimgpix.getElem(i)==eimgpix.getElem(i))
   		   {
   			   matchcount++;
   		   }
   	   }
		int percent=(matchcount*100)/epixcount;
		Reporter.log("percent ="+percent,true);
   	    Thread.sleep(2000);
   	    driver.close();	
	}
	
	
	
	
}
