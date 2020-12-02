package com_Adv_sel_pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;



import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 
{
    @Test
    public void TestA() throws IOException
    {
    	URL url = new URL("http://www.qsp.com/");
    	
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	
    	int status = con.getResponseCode();
    	Reporter.log("url status ="+status,true);
    	
    	String message = con.getResponseMessage();
    	Reporter.log("Url message ="+message,true);
    }
	
}
