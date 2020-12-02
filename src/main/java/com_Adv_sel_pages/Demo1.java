package com_Adv_sel_pages;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1{
@Test
public void Testa () throws IOException, InterruptedException
{
	    
	    File f = new File("./src/test/resources/Data/input.properties");
	    FileInputStream file = new FileInputStream(f);
	    
	    Properties p = new Properties();
	    
	    p.load(file);
	    
	    String url =p.getProperty("url");
	    String un = p.getProperty("un");
	    String pw=p.getProperty("pw");
	   
	    WebDriverManager.chromedriver().setup();
	
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
	
        driver.findElement(By.id("username")).sendKeys(un);
        driver.findElement(By.name("pwd")).sendKeys(pw);
        driver.findElement(By.xpath("//div[.='Login ']")).click();
        
        Thread.sleep(2000);
        driver.close();
	
}
}