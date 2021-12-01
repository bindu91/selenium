package stepdef;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	static WebDriver driver;
	private String naukriindow;
	private Set<String> Allwindows;
	private CreateAccountPageObjects createaccount;
	private HomePageObjects homepage;
	private ProductPageObjects product;
	private ExtentReports report;
	private ExtentTest test;
	private NaukriPageObjects naukari;
	


	@Before()
	public void startUp() {
		//  chrome driver
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = report.startTest("Login verification");
		driver.get(Config.url);
		homepage = new HomePageObjects(driver);
		createaccount = new CreateAccountPageObjects(driver);
		product = new ProductPageObjects(driver);
		naukari = new NaukriPageObjects(driver);
	}
	
	@After()
	public void tearDown() throws IOException {
//		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("E:/selscreenshots/error.png"));
		driver.quit();;
		report.endTest(test);
		report.flush();	
	}
	@Given("once url is loaded then print the url")
	public void once_url_is_loaded_then_print_the_url() {
		System.out.println("url of the page is: " + driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Navigated to the specified URL");
	}

	@Then("verify the title of the site")
	public void verify_the_title_of_the_site() {
		String ActualTitle = driver.getTitle();
		System.out.println("expected title is :" + ActualTitle);
		String ExpectedTitle = "My Store";
//		Assert.assertEquals(ExpectedTitle, ActualTitle);
		if(driver.getTitle().equals(ExpectedTitle))
		{
		test.log(LogStatus.PASS, "Verified the page title");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	@Then("click on Sign In button")
	public void click_on_sign_in_button() throws InterruptedException {
		Thread.sleep(4000);
		homepage.login.click();
		test.log(LogStatus.PASS, "clicked on Sign IN Button");
	}

	@Then("type {string} in email address")
	public void type_in_email_address(String Email) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(createaccount.emailAddress));
		createaccount.emailAddress.click();
		createaccount.emailAddress.sendKeys(Email);
		test.log(LogStatus.PASS, "Sucessfully entered email address");
	}

	@Then("click on create account")
	public void click_on_create_account() {
		createaccount.createButton.click();
		test.log(LogStatus.PASS, "clicked on create account");
		System.out.println();
	}

	@Then("select saluation as Mr")
	public void select_saluation_as_mr() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(createaccount.salutaion_Mrs));
		
		if(createaccount.salutaion_Mrs.isDisplayed())
		{
			createaccount.salutaion_Mrs.click();
			test.log(LogStatus.PASS, "launched to create account page");
		}
		else
		{
			test.log(LogStatus.FAIL, "unable to navigate to create account page");
		}
	}

	@Then("type {string} as first Name")
	public void type_as_first_name(String FirstName) throws InterruptedException {
		createaccount.FirstName.sendKeys(FirstName);
		test.log(LogStatus.PASS, "launched to create account page");
	}

	@Then("type {string} as last Name")
	public void type_as_last_name(String LastName) throws InterruptedException {
		createaccount.LastName.sendKeys(LastName);
		System.out.println("last name is filled");
		test.log(LogStatus.PASS, "launched to create account page");
	}

	@Then("verify email address is autofilled or not")
	public void verify_email_address_is_autofilled_or_not() throws InterruptedException {
		String emaildata = createaccount.AutofillEmail.getAttribute("value");
		System.out.println(emaildata);
		test.log(LogStatus.PASS, "launched to create account page");
	}

	@Then("type {string} as password")
	public void type_as_password(String Password) {
		createaccount.Password.sendKeys(Password);
		test.log(LogStatus.PASS, "launched to create account page");

	}

	@Then("select {string} as date {string} as month and {string} as year")
	public void select_as_date_as_month_and_as_year(String Date, String Month, String Year)
			throws InterruptedException {
		createaccount.Days.sendKeys(Date);
		createaccount.Months.sendKeys(Month);
		createaccount.Years.sendKeys(Year);
		test.log(LogStatus.PASS, "launched to create account page");

	}

	@Then("type {string} as firstname and {string} as lastname")
	public void type_as_firstname_and_as_lastname(String FirstName, String Lastname) {
		createaccount.firstName.sendKeys(FirstName);
		createaccount.lastName.sendKeys(Lastname);
		test.log(LogStatus.PASS, "launched to create account page");

	}

	@Then("type {string} , {string} , in address and city")
	public void type_in_address_and_city(String Address, String City) {
		
		createaccount.address1.sendKeys(Address);
		createaccount.city.sendKeys(City);
		test.log(LogStatus.PASS, "launched to create account page");
	}

	@Then("select {string} in state field")
	public void select_in_state_field(String State) {
		createaccount.id_State.sendKeys(State);
		test.log(LogStatus.PASS, "launched to create account page");
	}

	@Then("type {string} in zipcode")
	public void type_in_zipcode(String Zipcode) {
		createaccount.postCode.sendKeys(Zipcode);
		test.log(LogStatus.PASS, "launched to create account page");

	}

	@Then("select {string} from country")
	public void select_from_country(String Country) {
		createaccount.id_Country.sendKeys(Country);
		test.log(LogStatus.PASS, "launched to create account page");

	}

	@Then("type {string} in mobile")
	public void type_in_mobile(String MobileNo) {
		createaccount.phone_Mobile.sendKeys(MobileNo);
		test.log(LogStatus.PASS, "launched to create account page");
	}

	@Then("click on register button")
	public void click_on_register_button() throws InterruptedException {
		createaccount.submitAccount.click();
		test.log(LogStatus.PASS, "launched to create account page");

	}

	@Then("type {string} in email address and Password as {string}")
	public void type_in_email_address_and_password_as(String Emailaddress, String PassWord) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		if(product.emailId.isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOf(product.emailId));
			product.emailId.sendKeys(Emailaddress);
			product.password.sendKeys(PassWord);
			test.log(LogStatus.PASS, "sucessfully entered email and password");
		}else {
			test.log(LogStatus.FAIL, "sorry..! unable to enter email and password");
		}
			
	}

	@Then("click on login button")
	public void click_on_login_button() {
		//driver.findElement(By.id("SubmitLogin")).click();
		if(product.submitLogin.isEnabled()) {
		product.submitLogin.click();
		test.log(LogStatus.PASS, "sucessfully Clicked on submit button");
	}
		else {
			test.log(LogStatus.FAIL, "Unable to Click on Submitbutton");
		}
	}
	

	
	@Then("Click on Women category")
	public void click_on_women_category() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement Element = product.women;
		wait.until(ExpectedConditions.visibilityOf(Element));
		Actions action = new Actions(driver);
		action.moveToElement(Element).build().perform();
		
		if(product.women.isDisplayed()) {
			
			test.log(LogStatus.PASS, "sucessfully Clicked on submit button");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on Submitbutton");
			}
		
		
		
		
	
	}

//	@Then("Click on Tops")
//	public void click_on_tops() {
//		driver.findElement(By.xpath("//a[text()=''T-shirts]")).click();
//		System.out.println();
//
//	}

	@Then("select T-shirts")
	public void select_t_shirts() {
		
if(product.women.isDisplayed()) {
			
			test.log(LogStatus.PASS, "sucessfully Clicked on submit button");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on Submitbutton");
			}
		
		driver.findElement(By.xpath("//a[text()='T-shirts']")).click();
		// Write code here that turns the phrase above into concrete actions
		System.out.println();
	}

	@Then("enable  Large size size from size")
	public void enable_large_size_size_from_size() {
		
		
if(product.women.isDisplayed()) {
			
			test.log(LogStatus.PASS, "sucessfully Clicked on submit button");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on Submitbutton");
			}
		
		
		
		driver.findElement(By.id("layered_id_attribute_group_1")).click();
		System.out.println();
	}

	@Then("click on Casuals under Styles")
	public void click_on_casuals_under_styles() {
		
		
if(product.casuals.isDisplayed()) {
	product.casuals.click();
			test.log(LogStatus.PASS, "sucessfully Clicked on casuals");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on casuals");
			}
		
		
		
		
	}

	@Then("Click on  Shortsleeve under Properties")
	public void click_on_shortsleeve_under_properties() {
		
if(product.shortsleeves.isDisplayed()) {
	
	product.shortsleeves.click();
			
			test.log(LogStatus.PASS, "sucessfully Clicked on shortsleeves");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on shortsleeves");
			}
		
	}

	@Then("click on Instock  under Avaialbility")
	public void click_on_instock_under_avaialbility() throws InterruptedException {
		
if(product.inStocksavailability.isDisplayed()) {
	
	product.inStocksavailability.click();
			
			test.log(LogStatus.PASS, "sucessfully Clicked on inStocksavailability"); 
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on inStocksavailability");
			}
		
			}
                   
	@Then("click on Quick View")
	public void click_on_quick_view() throws InterruptedException {
		Thread.sleep(5000);	
if(product.image.isDisplayed()) {
	
	Thread.sleep(5000);
	
	Actions action1 = new Actions(driver);				
	action1.moveToElement(product.image).perform();		
	Thread.sleep(9000);
	product.quickview.click();
	
 	System.out.println();
			
			test.log(LogStatus.PASS, "sucessfully Clicked on quickview");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on quickview");
			}
		
		
		
	}

	@Then("increase the quantity")
	public void increase_the_quantity() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().frame(0);
if(product.quantityincreasing.isDisplayed()) {
	
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
	wait.until(ExpectedConditions.visibilityOf(product.quantityincreasing));
	product.quantityincreasing.click();
	System.out.println();
			test.log(LogStatus.PASS, "sucessfully Clicked on quantityincreasing");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on quantityincreasing");
			}
		
		}

	@Then("Change the size from dropdown")
	public void change_the_size_from_dropdown() {
if(product.changingSize.isDisplayed()) {
	WebElement dropdown = product.changingSize;
	Select S = new Select(dropdown);
	S.selectByValue("3");		
	System.out.println();
			
			test.log(LogStatus.PASS, "sucessfully changed_the_size_from_dropdown");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to change_the_size_from_dropdown");
			}
		
			}

	@Then("change the colour  of tshirt to blue")
	public void change_the_colour_of_tshirt_to_blue() throws InterruptedException {
		
if(product.changingColour.isDisplayed()) {
	
	product.changingColour.click();
	Thread.sleep(5000);
	test.log(LogStatus.PASS, "sucessfully changed the colour  of tshirt to blue");
}
			
		
	else {
				test.log(LogStatus.FAIL, "Unable to change the colour  of tshirt to blue");
			}
	}
			
			
	
	
		
	@Then("click on Add to Cart")
	public void click_on_add_to_cart() throws InterruptedException {
if(product.addTocart.isDisplayed()) {
	
	product.addTocart.click();
	Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "sucessfully Clicked on addTocart");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on addTocart");
			}
		
		
	}


	@Then("click on proceed to checkout to add product to cart")
	public void click_on_proceed_to_checkout_to_add_product_to_cart() {
if(product.proccedTocheckout1.isDisplayed()) {
	
	WebElement Proceed_to_checkout = product.proccedTocheckout1;
	Proceed_to_checkout.click();
	System.out.println();
			
			test.log(LogStatus.PASS, "sucessfully Clicked on proccedTocheckout1 button");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on proccedTocheckout1");
			}
		
//		WebElement Proceed_to_checkout = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
//		Proceed_to_checkout.click();
//		System.out.println();
	}


	@Then("click on proceed to checkout from Cart summary page")
	public void click_on_proceed_to_checkout_from_cart_summary_page() throws InterruptedException {
if(product.cartSummaryProceedtocheckout.isDisplayed()) {
			
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	System.out.println("title of the page is: "+driver.getTitle());
	Thread.sleep(5000);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(product.cartSummaryProceedtocheckout));
	WebElement checkout_from_cart_summary_page = product.cartSummaryProceedtocheckout ;
	checkout_from_cart_summary_page.click();
			test.log(LogStatus.PASS, "sucessfully Clicked on cartSummaryProceedtocheckout");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on cartSummaryProceedtocheckout");
			}
		
		
		
		
	}


	@Then("click on proceed to checkout from  ADDRESSES page")
	public void click_on_proceed_to_checkout_from_addresses_page() {
if(product.addressProceedtocheckout.isDisplayed()) {
	
	WebElement checkout_from_addresses_page = product.addressProceedtocheckout;
	checkout_from_addresses_page.click();
	System.out.println();
			
			test.log(LogStatus.PASS, "sucessfully Clicked on addressProceedtocheckout");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on addressProceedtocheckout");
			}
		
	
	}


	@Then("click on agree terms and conditions")
	public void click_on_agree_terms_and_conditions() {
if(product.termsConditions.isEnabled()) {
			
	
	product.termsConditions.click();
	
			test.log(LogStatus.PASS, "sucessfully Clicked on termsConditions");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on termsConditions");
			}
		
		//WebElement  ele = driver.findElement(By.id("cgv"));
		//ele.click();
		
	}

	@Then("click on proceed to checkout from  SHIPPING page")
	public void click_on_proceed_to_checkout_from_shipping_page() {
if(product.shippingProceedTocheckout.isDisplayed()) {
			
	
	product.shippingProceedTocheckout.click();
	
			test.log(LogStatus.PASS, "sucessfully Clicked on shippingProceedTocheckout");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on shippingProceedTocheckout");
			}
		
			
		System.out.println();
	}

	@Then("select the payment method  Pay by Check")
	public void select_the_payment_method_pay_by_check() {
if(product.payment.isDisplayed()) {
	
	product.payment.click();
			
			test.log(LogStatus.PASS, "sucessfully Clicked on Pay by Check");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on Pay by Check");
			}
		
//		driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
//		System.out.println();
	}

	@Then("click on I confrim My order")
	public void click_on_i_confrim_my_order() {
if(product.confrimOrder.isDisplayed()) {
	
	product.confrimOrder.click();
			
			test.log(LogStatus.PASS, "sucessfully Clicked on confrimOrder");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on confrimOrder");
			}
		
//		driver.findElement(By.xpath("//p[@id='cart_navigation']/button/span")).click();
//		System.out.println();
	}

	@Then("capture the reference code of the order.")
	public void capture_the_reference_code_of_the_order() throws InterruptedException {
if(product.referenceCode.isDisplayed()) {
	
	Thread.sleep(9000);
	String orderno = product.referenceCode.getText();
	System.out.println(orderno);
			
			test.log(LogStatus.PASS, "sucessfully Clicked on referenceCode");
		}
			else {
				test.log(LogStatus.FAIL, "Unable to Click on referenceCode");
			}
		
		
	}
	@Then("click on facebook and print the title and close fb link")
	public void click_on_facebook_and_print_the_title_and_close_fb_link() throws InterruptedException {
		
		driver.findElement(By.className("facebook")).click();
		
		Thread.sleep(5000);
		String parentwindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("size of all windows is : "+handles.size());
		String fb =  (String) handles.toArray()[1];
		driver.switchTo().window(fb);
		System.out.println("title of the page is:"+driver.getTitle());
		Thread.sleep(5000);
		driver.switchTo().window(parentwindow);
		Thread.sleep(5000);
		driver.switchTo().window(fb);
		driver.close();
		Thread.sleep(5000);
	}
	@Then("switch to multiple windows")
	public void switch_to_multiple_windows() throws InterruptedException {
		driver.findElement(By.className("facebook")).click();
		driver.findElement(By.className("twitter")).click();
//		driver.findElement(By.className("youtube")).click();
//		driver.findElement(By.className("google-plus")).click();
		Thread.sleep(5000);
		String parentwindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("size of all windows is : "+handles.size());
		String twitter =  (String) handles.toArray()[1];
		String fb =  (String) handles.toArray()[2];
//		String youtube =  (String) handles.toArray()[3];
//		String google =  (String) handles.toArray()[4];
		driver.switchTo().window(fb);
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parentwindow);
		Thread.sleep(5000);
		driver.switchTo().window(twitter);
		Thread.sleep(5000);
		driver.switchTo().window(parentwindow);
	}

	@Given("url is loaded  print the url")
	public void url_is_loaded_print_the_url() {
	 String Url =  driver.getCurrentUrl();
	    System.out.println(Url);
	}

	@Then("verify the title of main window")
	public void verify_the_title_of_main_window() {
	   String ExpectedTitle = driver.getTitle();
	   System.out.println(driver.getTitle());
	  String  ActualTitle = "Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com";
	  						 
//	    		Assert.assertEquals(ExpectedTitle, ActualTitle);
			
	}

	
	@Then("find the number of windows  available with main window")
	public void find_the_number_of_windows_available_with_main_window() {
	  
		 naukriindow = driver.getWindowHandle();

	  Allwindows = driver.getWindowHandles();
		
		
		int s = Allwindows.size();
		System.out.println(s );
	}

	
	@Then("print the title of each window  and  close the child windows")
	public void print_the_title_of_each_window_and_close_the_child_windows() {
		
	   String child1 = (String) Allwindows.toArray()[1];
	   String child2 = (String) Allwindows.toArray()[2];
	   String child3 = (String) Allwindows.toArray()[3];
	   
	   
	   driver.switchTo().window(child1);
	   System.out.println(driver.getTitle());
	   driver.close();
	   
	   driver.switchTo().window(child2);
	   System.out.println(driver.getTitle());
	   driver.close();
	   driver.switchTo().window(child3);
	   System.out.println(driver.getTitle());
	   driver.close();
	   
	   
	}

	
	@Then("switch to parent window")
	public void switch_to_parent_window() {
	  driver.switchTo().window(naukriindow);
	}
	
	@Then("type <username>")
	public void type_test2323_gmail_com(String username) {
		
		product.emailId.sendKeys(username);
		test.log(LogStatus.PASS, "sucessfully entered username");
		
	   
		
	}
	@Then("type <password>")
	public void type_assdfds(String password) {
	  product.password.sendKeys(password);
	  test.log(LogStatus.PASS, "sucessfully entered password");
	}
	@Then("type {string}")
	public void type(String name) throws AWTException, InterruptedException {
	    driver.findElement(By.name("q")).sendKeys(name);
//	    Robot rb = new Robot();
//	    rb.keyPress(KeyEvent.VK_ENTER);
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(5000);
	    
	}
	@Then("scroll down")
	public void scroll_down() throws InterruptedException {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
		 Thread.sleep(5000);
	}


	@Then("scroll side")
	public void scroll_side() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(1000,0)");
		 Thread.sleep(5000);
		 js.executeScript("window.scrollBy(1000,1000)");
		 Thread.sleep(5000);
	}
	
	
	
//	 naukri advanced search steps
	
	@Then("mousehover on jobs")
	public void mousehover_on_jobs() throws InterruptedException {

		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(naukari.jobs).build().perform();
		
		
	}

	

	@Then("click on Advancedsearch jobs")
	public void click_on_advancedsearch_jobs() throws InterruptedException {

		Thread.sleep(3000);
		naukari.advancedsearch.click();
		
	}


	
	@Then("switch to Advancedsearchwindow")
	public void switch_to_advancedsearchwindow() throws InterruptedException {
		
		String advancedsearchwindow = (String) driver.getWindowHandles().toArray()[2];
		
		System.out.println(""+advancedsearchwindow);
				 
			driver.switchTo().window(advancedsearchwindow);
			
			Thread.sleep(5000);
	}

	

	@Then("click on keyskills  and select as {string} and {string}")
	public void click_on_keyskills_and_select_as_and(String Skill1, String Skill2) throws InterruptedException {
		
	//	driver.switchTo().alert().dismiss();
		naukari.popUp.click();
		Thread.sleep(5000);
		naukari.keySkill.click();
		naukari.keySkill.sendKeys("Testing");
		Actions action = new Actions(driver);
		action.moveToElement(naukari.softwareTesting).build().perform();

	
	}

	
	
	@Given("Url is loaded and home page is available")
	public void url_is_loaded_and_home_page_is_available() {
	    
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a [text()='Home']"))));
		
		
		
		
	}

	

	@Then("verify the register link  and click")
	public void verify_the_register_link_and_click() {
	   
		driver.findElement(By.xpath("//a [text()='REGISTER']")).click();
		
	}

	

	@Then("fill all the details  and click on submit")
	public void fill_all_the_details_and_click_on_submit() {
	   
		driver.findElement(By.name("firstName")).sendKeys("magesh");
		driver.findElement(By.name("lastName")).sendKeys("ikk");
		driver.findElement(By.name("phone")).sendKeys("7287138920");
		driver.findElement(By.name("userName")).sendKeys("magesh@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("addresslane");
		driver.findElement(By.name("city")).sendKeys("guntuygu");
		driver.findElement(By.name("state")).sendKeys("AP");
		driver.findElement(By.name("postalCode")).sendKeys("652167");
		
		 Select s = new Select(driver.findElement(By.name("country")));
		 s.selectByValue("INDIA");
		 driver.findElement(By.name("email")).sendKeys("magesh");
		 driver.findElement(By.name("password")).sendKeys("magesh123");
		 driver.findElement(By.name("confirmPassword")).sendKeys("magesh123");
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		String  Usercreated = driver.findElement(By.xpath("//p[3]//b")).getText();
		  System.out.println(Usercreated);
		 
		
		
		
	}

	


@Then("fill the username  and password login with details")
public void fill_the_username_and_password_login_with_details() {
   
	
	driver.findElement(By.name("userName")).sendKeys("magesh");
	
	driver.findElement(By.name("password")).sendKeys("magesh123");
	
	
	
	
}


@Then("click on Flights link and enter all the details")
public void click_on_flights_link_and_enter_all_the_details() {
    
	
	driver.findElement(By.xpath("//a[text()='Flights']")).click();
	driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
	 Select passengers = new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
	 passengers.selectByValue("4");
	 
	 Select Departingplace = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
	 Departingplace.selectByVisibleText("Portland");

	 Select Month = new Select(driver.findElement(By.xpath("//select[@name='fromMonth']")));
	 Month.selectByValue("8");
	 
	 Select Day = new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
	 Day.selectByValue("26");
	 
	 Select Toplace = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
	 Toplace.selectByVisibleText("New York");
	 
	 Select ToMonth = new Select(driver.findElement(By.xpath("//select[@name='toMonth']")));
	 ToMonth.selectByValue("8");
	 
	 Select ToDay = new Select(driver.findElement(By.xpath("//select[@name='toDay']")));
	 ToDay.selectByValue("29");
	 
	 driver.findElement(By.xpath("//input[@name='servClass'][@value='Business']")).click();
	 	 
	
	 	 Select Airline = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
	 Airline.selectByVisibleText("Blue Skies Airlines");
	
 

	
}


@Then("click on continue")
public void click_on_continue() {
    
	 driver.findElement(By.xpath("//input[@name='findFlights']")).click();
 	 
	
	
}


	
	
	

	
@Given("the url click on payments link")
public void the_url_click_on_payments_link() {
    
	driver.findElement(By.xpath("//a[text()='Payment Gateway Project']")).click();
}



@Then("capture the product and  cost  and select the cost  and buy")
public void capture_the_product_and_cost_and_select_the_cost_and_buy() {
   String product = driver.findElement(By.xpath("//h2[text()='Mother Elephant With Babies Soft Toy']")).getText();
   System.out.println(product);
   String cost = driver.findElement(By.xpath("//h3[text()='Price: $20']")).getText();
   System.out.println(cost);
   Select  Quantity =  new Select(driver.findElement(By.xpath("//select[@name='quantity']")))  ;
   Quantity.selectByValue("9");
   driver.findElement(By.xpath("//input[@type='submit']")).click();
 
}


@Then("Click on card details tab caputre enter yourcard number")
public void click_on_card_details_tab_caputre_enter_yourcard_number() {
    
	String cardnumber =driver.findElement(By.xpath("//input[@placeholder='Enter Your Card Number']")).getAttribute("placeholder"); 
	System.out.println(cardnumber);

} 

                            

@Then("select the month and expiry year")
public void select_the_month_and_expiry_year() {
  
	 Select  Month =  new Select(driver.findElement(By.name("month")))  ;
	 Month.selectByIndex(9);
	 Select  Year =  new Select(driver.findElement(By.name("year")))  ;
	 Year.selectByValue("2019");
	
}


@Then("click on cvvcode and capture the cvv")
public void click_on_cvvcode_and_capture_the_cvv() {
	String cvvno =driver.findElement(By.xpath("//input[@placeholder='CVV Code']")).getAttribute("placeholder"); 
	System.out.println(cvvno);
	
	driver.findElement(By.name("cvv_code")).click();
	 
}



@Then("enter the cvv and click on paytab")
public void enter_the_cvv_and_click_on_paytab() {
	driver.findElement(By.name("cvv_code")).sendKeys("432"); 
	
	driver.findElement(By.name("submit")).click();
}


@Then("capture the alert and accept alert")
public void capture_the_alert_and_accept_alert() {
	
	 String alert = driver.switchTo().alert().getText();
	 System.out.println(alert);
	 driver.switchTo().alert().accept();
   
}



@Then("enter the card details  with {int} digits")
public void enter_the_card_details_with_digits(Integer int1) {
   
	driver.findElement(By.name("card_nmuber")).sendKeys("1234123412341234");
	driver.findElement(By.name("submit")).click();
	
}


@Then("capture the order placed")
public void capture_the_order_placed() {
    
	String Payment = driver.findElement(By.xpath("//h2[text()='Payment successfull!']")).getText();
	System.out.println(Payment);
	 String Order =driver.findElement(By.xpath("//table[@class='alt access']")).getText();
	 System.out.println(Order);
	
}
@Given("url of mercury travels and verify the title")
public void url_of_mercury_travels_and_verify_the_title() throws Throwable {
    Thread.sleep(1000);
	String Actualtitle = driver.getTitle();
	System.out.println(Actualtitle);
	String Expectedtitle = "Mercury Travels: Holiday Packages, Flight Booking, Hotels, Forex, Visa & Travel Insurance";
	Assert.assertEquals( Expectedtitle, Actualtitle);
	
}



@Then("click on the hotels link and fill in the details")
public void click_on_the_hotels_link_and_fill_in_the_details() throws InterruptedException {
 
    driver.findElement(By.xpath("//a[@title='Hotels']")).click();
    Thread.sleep(5000);
     WebElement  City = driver.findElement(By.name("cityName"));  
     City.click();
     City.clear();
     Thread.sleep(5000);
     City.sendKeys("Bang");

     
//     WebDriverWait wait = new WebDriverWait(driver,20);
//     WebElement  location =  driver.findElement(By.xpath("//li[@class='ui-menu-item']//a[text()='Bangalore, India']"));
//     wait.until(ExpectedConditions.elementToBeClickable(location));
     System.out.println(City.getAttribute("value"));
     Thread.sleep(5000);
     WebElement ele= driver.findElement(By.xpath("//a[text()='Bangalore, India']"));
     ele.click();
     Thread.sleep(5000);
     
     
     driver.findElement(By.name("checkIn")).click();
     Thread.sleep(1000);
//     WebDriverWait wait = new WebDriverWait(driver,20);
//     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='datepicker dropdown-menu'][10]")));
//     Thread.sleep(1000);
     WebElement month	= driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][5]/div/table[@class=' table-condensed']/thead/tr/th[@class='switch']"));
     while(!month.getText().equals("December 2025")){
    	 driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][5]/div/table[@class=' table-condensed']/thead/tr/th[@class='next']")).click();

    	}
     
     System.out.println("Month displayed is "+month.getText());
//  driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][5]/div/table[@class=' table-condensed']/thead/tr/th[@class='next']")).click();

  driver.findElement(By.xpath("//body//div[@class='datepicker dropdown-menu'][5]"
  		+ "//div[@class='datepicker-days']//table//tbody//tr[2]//td[@class='day '][3]")).click();
  Thread.sleep(1000);
  driver.findElement(By.name("checkOut")).click();  
  Thread.sleep(1000);
  
  driver.findElement(By.name("room_count")).click();
   Select rooms = new Select(driver.findElement(By.name("room_count")));
   rooms.selectByVisibleText("2");
  
   
   driver.findElement(By.name("adults[]")).click();
   Select adults = new Select(driver.findElement(By.name("adults[]")));
   rooms.selectByVisibleText("4");
   
   driver.findElement(By.name("childs[]")).click();
   Select children = new Select(driver.findElement(By.name("childs[]")));
   rooms.selectByVisibleText("2");
   
   
}



@Then("click on search hotels")
public void click_on_search_hotels() {
	
	driver.findElement(By.xpath("//button[@id='searchHotelsBtn']")).click();
}


@Then("mousehover on foriegn exchange")
public void mousehover_on_foriegn_exchange() throws InterruptedException {
	Thread.sleep(5000);
    
	 try {
		WebElement  foriegn =  driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[8]/a"));
		foriegn.click();
		 Actions action = new Actions(driver);
		 
		 action.moveToElement(foriegn).build();
	} catch (ElementNotInteractableException e) {
		
	}
	 
}



@Then("go to FAQ menu")
public void go_to_faq_menu() throws InterruptedException {
   driver.findElement(By.xpath("//div[@class='container']//a[text()='FAQ']")).click();
   Thread.sleep(5000);
}


@Then("click on {string}")
public void click_on_and_print_text(String link) {
	
	switch(link) {
	case "Holiday Travel":

		WebElement element1 =driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div/div[1]/div/div/dl/dt[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element1);
		 String text1 = driver.findElement(By.xpath("//dd[@id='accordion1']")).getText();
		System.out.println(text1);
		
	break;
	case "Businees Travel":
		WebElement element =driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div/div[1]/div/div/dl/dt[2]/a"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element);
		 String text2 = driver.findElement(By.xpath("//dd[@id='accordion2']")).getText();
		System.out.println(text2);
		break;
	case "Higher Studies":
		WebElement element2 =driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div/div[1]/div/div/dl/dt[3]/a"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);
		 String text3 = driver.findElement(By.xpath("//dd[@id='accordion3']")).getText();
		System.out.println(text3);
		break;
	
	}
  
}

@Given("when the url is provided  mousehover onjobs")
public void when_the_url_is_provided_mousehover_onjobs() throws InterruptedException {
   
	Thread.sleep(3000);
	WebElement target = driver.findElement(By.xpath("//div[@class ='headGNB cloneCont wrap']//li[@class='mActive']"));
	Actions action = new Actions(driver);
	action.moveToElement(target).build().perform();
	
	
	
}



@Given("click on jobsby location")
public void click_on_jobsby_location() throws InterruptedException {
	Thread.sleep(1000);
	driver.findElement(By.xpath("//li[@class='mActive']//a[@title='Jobs by Location']")).click();
	Thread.sleep(1000);
}



@When("switch to child window and enter  the skill and location  as chennai click on search")
public void switch_to_child_window_and_enter_the_skill_and_location_as_chennai_click_on_search() throws InterruptedException {
   
	String parentWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	 System.out.println("no of windows are: " +allWindowHandles.size());
	 System.out.println("no of windows are: " +allWindowHandles);
	String window1 = allWindowHandles.toArray()[1].toString();
	 driver.switchTo().window(parentWindowHandle);
	 driver.switchTo().window(window1);
	 System.out.println("Title of child window is : "+ window1);
	 System.out.println("Title of child window is : "+ driver.getTitle());
	 System.out.println("Title of child window is : "+ parentWindowHandle);
	 System.out.println("Title of parent window is : "+ driver.getTitle());
	 Thread.sleep(5000);
	 
	 driver.findElement(By.xpath("//input[@placeholder='Skills, Designations, Companies']")).click();
	 driver.findElement(By.xpath("//input[@placeholder='Skills, Designations, Companies']")).sendKeys("se");	 
	 driver.findElement(By.xpath("//div[@id='skill']//div[@id='sugDrp_skill']//ul//li[10]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//div[@id='skill']//div[@id='sugDrp_skill']//ul//li[4]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//div[@id='skill']//div[@id='sugDrp_skill']//ul//li[8]")).click();
	 Thread.sleep(1000);
//	 List<WebElement> elements= driver.findElements(By.xpath("//div[@id='sugDrp_skill']/ul[@class='Sdrop']"));
//	 System.out.println("list of elements are \n" +elements);
//	 Thread.sleep(1000);
//	 driver.findElement(By.xpath("//div[@id='sugDrp_skill']//ul//li*[text()='Selenium Webdriver']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//div[@id='location']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@placeholder='Location/Locality']")).sendKeys("ch");
	 driver.findElement(By.xpath("//div[@id='sugDrp_location']//ul//li[1]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//button[@id='qsbFormBtn']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//div[@class='DDsearch']")).click();
	 driver.findElement(By.xpath("//div[@id='dp_filter-freshness']//div//ul//li[4]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//div[@class='filterOptns']//span[text()='Chennai']")).click();
	
}



@When("select the filter as last {int} days  and check the location as chennai")
public void select_the_filter_as_last_days_and_check_the_location_as_chennai(Integer int1) {
   
	
}



@When("scroll down and click on next button  till disapear")
public void scroll_down_and_click_on_next_button_till_disapear() {
    
	
	
	WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
	 try {
		while (next.isEnabled()) {
			next.click();
		}
	} catch (ElementClickInterceptedException e) {
		System.out.println("catched exception");
	}
	
	
}



//@Then("click on the last job profile")
//public void click_on_the_last_job_profile() {
//	
//	driver.findElement(By.xpath("")).click();
//}



}
