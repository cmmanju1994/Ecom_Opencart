package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// Constructor
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
   // Page elements
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement inputPassword;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement btnLogin;
	
	
	// Action methods
	
	public void setEmail(String email)
	{
		inputEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		inputPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
	
	

}
