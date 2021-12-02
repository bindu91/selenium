package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {"pretty","html:target/reports"},
		features="src/test/resources/resources/features/",
		glue= "",
		tags ="@jobs1"
	
		)

public class Runner {
	
	

}
