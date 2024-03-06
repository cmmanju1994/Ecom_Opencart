package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"regression","master"})
	public void verify_Login()
	{
		
		try
		{
	HomePage hp=new HomePage(driver);
	LoginPage lp=new LoginPage(driver);
	MyAccountPage macc=new MyAccountPage(driver);
	
	logger.info("**** starting TC_002_LoginTest **** ");
	
	hp.clickMyAccount();
	logger.info("clicked on MyAccount link");
	
	hp.clickLogin();
	logger.info("clicked on login link");
	
	logger.info("entering valid email and password");
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	
	lp.clickLogin();
	logger.info("clicked on login button");
	
	Assert.assertEquals(macc.isMyAccountExists(), true,"Login is passed");
	logger.info("My account visible");
	
	macc.clickLogout();
	logger.info("clicked on logout link");
		}
		catch (Exception e)
		{
			logger.error("Test TC_002_LoginTest Failed");
			e.getMessage();
		}
		logger.info("Login test is finished");
	}
	
}
