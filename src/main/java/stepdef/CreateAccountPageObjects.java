package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPageObjects {
	
	public CreateAccountPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(id = "email_create")
	 public WebElement emailAddress ;
	
	 @FindBy(name = "SubmitCreate")
	 public WebElement createButton ;
	 
	 @FindBy(id = "id_gender2")
	 public WebElement salutaion_Mrs ;
	 
	 @FindBy(id = "customer_firstname")
	 public WebElement FirstName ;
	 
	 @FindBy(name = "customer_lastname")
	 public WebElement LastName ;
	 
	 @FindBy(name = "email")
	 public WebElement AutofillEmail ;	 
	 
	 @FindBy(id = "passwd")
	 public WebElement Password ;	 
	 
	 @FindBy(id = "days")
	 public WebElement Days ;
	 
	 @FindBy(id = "months")
	 public WebElement Months ;	
	 
	 @FindBy(id = "years")
	 public WebElement Years ;	
	 
	 
	 @FindBy(id = "firstname")
	 public WebElement firstName ;	
	 
	 @FindBy(id = "lastname")
	 public WebElement lastName ;	
	 
	 @FindBy(id = "address1")
	 public WebElement address1 ;	
	 
	 @FindBy(id = "city")
	 public WebElement city ;	
	 
	 @FindBy(id = "id_state")
	 public WebElement id_State ;	
	 
	 
	 @FindBy(id = "postcode")
	 public WebElement postCode ;
	 
	 @FindBy(id = "id_country")
	 public WebElement id_Country ;	
	 
	 @FindBy(id = "phone_mobile")
	 public WebElement phone_Mobile ;	
	 
	 @FindBy(name = "submitAccount")
	 public WebElement submitAccount ;	
	 
	
	 
	 
	 
	 
	
}
