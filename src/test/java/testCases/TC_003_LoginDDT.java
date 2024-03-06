package testCases;



import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass 
{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String username,String password,String exp)
	{
		try
		{
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		MyAccountPage macc=new MyAccountPage(driver);
		
		logger.info("**** starting TC_003_LoginDDT **** ");
		
		hp.clickMyAccount();
		logger.info("clicked on MyAccount link");
		
		hp.clickLogin();
		logger.info("clicked on login link");
		
		logger.info("entering valid email and password");
		lp.setEmail(username);
		lp.setPassword(password);
		
		lp.clickLogin();
		logger.info("clicked on login button");
		
		boolean targetpage=macc.isMyAccountExists();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
		
	}
		catch(Exception e) 
		{
			e.getMessage();
		}
		logger.info("finishing login ddt test");
}
	

}
