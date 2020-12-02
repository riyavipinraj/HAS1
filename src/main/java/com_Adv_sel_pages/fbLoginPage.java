package com_Adv_sel_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fbLoginPage 
{

	@FindBy(id ="email")
	private WebElement unTB;
	
	@FindBy(name ="pass")
	private WebElement pwTB;
	
	@FindBy(xpath ="//div[.='Log In']")
	private WebElement lgBT;
	
	public fbLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    public void enterusername(String un)
    {
    	unTB.sendKeys(un);
    }
    public void enterpassword(String pw)
    {
    	pwTB.sendKeys(pw);
    }
    public void clickOnLogin()
    {
    	lgBT.click();
    }
	
	
	
}
