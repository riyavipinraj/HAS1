package com_Adv_sel_Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com_Adv_sel_pages.EnterTimeTrackerPage;
import com_Adv_sel_pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 
{
	@Test
     public void demo() throws InterruptedException {
    	 
    	 WebDriverManager.chromedriver().setup();
		
    	    WebDriver driver=new ChromeDriver();
    	    
    	    driver.manage().window().maximize();
    	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	    driver.get("https://demo.actitime.com");
    	    LoginPage lp= new LoginPage(driver);
    	    EnterTimeTrackerPage ep= new EnterTimeTrackerPage(driver);
    	    lp.enterusername("admin");
    	    lp.enterpassword("manager");
    	    lp.clickOnLogin();
    	    ep.Clickhelpbutton();
    	    ep.ClickOnContactbutton();
    	    ep.clickOnAttachbutton();
    	    
    	    Thread.sleep(2000);
    	    ep.UploadFile("C:\\Users\\Kees\\Desktop\\Stud.java");
    	    
    	    driver.close();
	}
}
