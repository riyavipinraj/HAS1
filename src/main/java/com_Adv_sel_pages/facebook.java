package com_Adv_sel_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook 
{
	
	@Test
	public void fb() throws InterruptedException
	{
		ChromeOptions cp =new ChromeOptions();
		cp.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		
	    WebDriver driver=new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.facebook.com/");
	    fbLoginPage fbl = new fbLoginPage(driver);
	    enterFacebookPage efb= new enterFacebookPage(driver);
	    fbl.enterusername("amvipikuttu@gmail.com");
	    fbl.enterpassword("Trynow1434");
	    fbl.clickOnLogin();
	    Thread.sleep(1000);
	    efb.Clickacbutton();
	    Thread.sleep(1000);
	    efb.Clicktxtbox();
	    Thread.sleep(1000);
	    efb.writetxt("Hello Good morning");
	    Thread.sleep(1000);
	   
	    
	    Thread.sleep(2000);
	    driver.close();
	    
	}
}