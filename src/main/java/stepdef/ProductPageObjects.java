package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageObjects {
	
	
	public ProductPageObjects(WebDriver driver) {
		PageFactory.initElements(driver,this );
	
	}
	
	@FindBy(id="email")
	public WebElement emailId;
	
	@FindBy(id="passwd")
	public WebElement password;
	
	
	@FindBy(id="SubmitLogin")
	public WebElement submitLogin;
	
	@FindBy(xpath="//a[text()='Women']")
	public WebElement women;
	
	
	@FindBy(xpath="//a[text()='Casual']")
	public WebElement casuals;
	
	@FindBy(xpath="//a[text()='Short Sleeve']")
	public WebElement shortsleeves;
	
	@FindBy(xpath="//a[text()='In stock']")
	public WebElement inStocksavailability;
	
	
	@FindBy(xpath="//*[@id=\\\"center_column\\\"]/ul/li/div/div[1]/div/a[1]/img")
	public WebElement image;
	
	@FindBy(xpath="//span[text()='Quick view']")
	public WebElement quickview;
	
	
	@FindBy(xpath="//*[@id=\\\"quantity_wanted_p\\\"]/a[2]/span")
	public WebElement quantityincreasing;
	
	
	@FindBy(xpath="//div[@class='attribute_list']/div/select")
	public WebElement changingSize;
		

	@FindBy(name="Blue")
	public WebElement changingColour;
	
	
	@FindBy(name="Submit")
	public WebElement addTocart;
	
	@FindBy(xpath="\"//a[@title='Proceed to checkout']\"")
	public WebElement proccedTocheckout1;

	@FindBy(xpath="//*[@id='center_column']/p[2]/a[1]")
	public WebElement cartSummaryProceedtocheckout;
	

	@FindBy(name="processAddress")
	public WebElement addressProceedtocheckout;
	
	@FindBy(id="cgv")
	public WebElement termsConditions;
	

	@FindBy(name="processCarrier")
	public WebElement shippingProceedTocheckout;

	@FindBy(xpath="//a[@title='Pay by check.']")
	public WebElement payment;
	
	@FindBy(xpath="//p[@id='cart_navigation']/button/span")
	public WebElement confrimOrder;
	
	@FindBy(xpath="//*[@id=\\\"center_column\\\"]")
	public WebElement referenceCode;
	

	
	
	

}
