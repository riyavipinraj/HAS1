package com_Adv_sel_pages;



import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo 
{

	@Test 
    public void demo() throws InterruptedException, AWTException, IOException {
   	 
   	 WebDriverManager.chromedriver().setup();
		
   	    WebDriver driver=new ChromeDriver();
   	    
   	    driver.manage().window().maximize();
   	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	    driver.get("https://www.naukri.com/");
   	    driver.findElement(By.id("wdgt-file-upload")).click();
   	    
   	    Thread.sleep(3000);
   	    
   	    Robot r= new Robot();
   	    
	    Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
	    
	    Rectangle re= new  Rectangle(d);
	    
	    BufferedImage img= r.createScreenCapture(re);
	    
	    ImageIO.write(img, "png", new File("./DemoB.png"));
	    
	    Thread.sleep(2000);
	    driver.close();
	    
	
	
}
	@Test
	public void test()
	{
		Reporter.log("hi",true);
	}
}
