package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
//	 Page factory
	
	 @FindBy(xpath = "//a[@title='Log in to your customer account']")
	 public WebElement login ;
	

}
