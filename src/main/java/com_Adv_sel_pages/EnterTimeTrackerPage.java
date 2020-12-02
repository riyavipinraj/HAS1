package com_Adv_sel_pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackerPage 
{

	@FindBy(xpath = "(//div[@class= 'popup_menu_icon'])[4]")
	private WebElement helpBT;
	
	@FindBy(linkText = "Contact actiTIME Support")
	private WebElement contactBT;
	
	@FindBy(xpath = "(//div[@class= 'icon dz-clickable'])")
	private WebElement attachBT;
	
	public EnterTimeTrackerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    public void Clickhelpbutton()
    {
    	helpBT.click();
    }
    public void ClickOnContactbutton()
    {
    	contactBT.click();
    }
    public void clickOnAttachbutton()
    {
    	attachBT.click();
    }
    
    public void UploadFile(String File_path)
    {
    	StringSelection file=new StringSelection(File_path);
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
    	
    	try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			
			
		    } 
    	
    	
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}

