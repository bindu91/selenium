package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukriPageObjects {
	WebDriver driver;

	public NaukriPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath = "//a[@title='Search Jobs']")
    public WebElement  jobs;
	
    @FindBy(xpath = "//a[@title='Advanced Search']")
    public WebElement  advancedsearch;
    
    @FindBy(xpath = "//div[@id='geoLocPopUp']//div//span[@id='allow']")
    public WebElement  popUp;
          
    
    @FindBy(xpath = "//div[@id='advKeyskills']//input[@name='qp']")
    public WebElement  keySkill;    
    

    @FindBy(xpath="//div[@id='advKeyskills']/div[2]/ul/li[1]/div[contains(text(),'Software Testing'])")
    public WebElement  softwareTesting;
   
    
}
