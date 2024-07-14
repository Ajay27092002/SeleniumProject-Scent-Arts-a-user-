package org.StepDefnition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;

public class ScentDescription {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	public TakesScreenshot ts;
@Given("To launch the browser")

public void to_launch_the_browser() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}

@When("To launch URL of Scent-Arts")
public void to_launch_url_of_scent_arts() {
	driver.get("https://scentarts.ae/");
}

@When("To click About Us button")
public void to_click_about_us_button() {
	WebElement about = driver.findElement(By.xpath("(//a[contains(text(),'About Us')][1])"));
	about.click();
	 
}

@When("To Scroll down to the AREAS OF SCENTING section")
public void to_scroll_down_to_the_areas_of_scenting_section() {
	js = (JavascriptExecutor) driver;
    WebElement area = driver.findElement(By.xpath("//h2[contains(text(),'AREAS OF SCENTING')]"));
	js.executeScript("arguments[0].scrollIntoView(true)",area);
}

@When("Click on hotels, offices and airports areas")
public void click_on_hotels_offices_and_airports_areas() {
    WebElement hotels = driver.findElement(By.xpath("//a[contains(text(),'Hotels')]"));
    hotels.click();
    WebElement offices = driver.findElement(By.xpath("//a[contains(text(),'Offices')]"));
    offices.click();
    WebElement airports = driver.findElement(By.xpath("//a[contains(text(),'Airports Lounges')]"));
    airports.click();
}
@When("To check hotels, offices and airports areas description is present")
public void to_check_hotels_offices_and_airports_areas_description_is_present() {
	WebElement hotelsdes = driver.findElement(By.xpath("//p[contains(text(),'Smell provides guests')]"));
    WebElement officesdes = driver.findElement(By.xpath("//p[contains(text(),'A signature scent')]"));
    WebElement airportsdes = driver.findElement(By.xpath("//p[contains(text(),'Every airport')]"));
    String hot = hotelsdes.getText();
    String off = officesdes.getText();
    String air = airportsdes.getText();
    SoftAssert s = new SoftAssert();
    s.assertTrue(hot.contains("Smell provides"),"Hotels description not present");
    s.assertTrue(off.contains("A signature scent"),"Offices description not present");
    s.assertTrue(air.contains("Every airport"),"Airports description not present");
    s.assertAll();
}

@When("To click the OUR SERVICES button")
public void to_click_the_our_services_button() {
	WebElement ourservices = driver.findElement(By.xpath("(//a[contains(text(),'Our Services')][1])"));
	ourservices.click();
}

@When("To scroll down to Contact Us button")
public void to_scroll_down_to_contact_us_button() {
	js = (JavascriptExecutor) driver;
    WebElement contact = driver.findElement(By.xpath("(//span[contains(text(),'Contact Us')][1])"));
	js.executeScript("arguments[0].scrollIntoView(true)",contact);
   
}

@When("To click the Contact Us button")
public void to_click_the_contact_us_button() {
	 WebElement contact = driver.findElement(By.xpath("(//span[contains(text(),'Contact Us')][1])"));
	 contact.click();
}
@When("Scroll down to the form and take screenshot")
public void scroll_down_to_the_form_and_take_screenshot() throws IOException, InterruptedException {
	js = (JavascriptExecutor) driver;
    WebElement send = driver.findElement(By.xpath("//span[contains(text(),'Send')]"));
	js.executeScript("arguments[0].scrollIntoView(false)",send);
	Thread.sleep(5000);
	ts = (TakesScreenshot) driver;
	File s = ts.getScreenshotAs(OutputType.FILE);
	File f = new File("C:\\Users\\ajay4\\eclipse-workspace\\ScentWebSiteTest\\ScreenShots\\contactform.png");
	FileUtils.copyFile(s, f);
}

@When("click the contact us button")
public void click_the_contact_us_button() {
	 WebElement contact = driver.findElement(By.xpath("(//a[contains(text(),'Contact Us')][1])"));
	 contact.click();
}

@When("To enter the name in name field")
public void to_enter_the_name_in_name_field() {
    WebElement name = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
    name.sendKeys("vijay");
}
@When("To enter the company name in company name field")
public void to_enter_the_company_name_in_company_name_field() {
    WebElement companyname = driver.findElement(By.xpath("//input[@placeholder='Company Name']")); 
    companyname.sendKeys("Inmakes");
}
@When("To enter phone number in phone number field")
public void to_enter_phone_number_in_phone_number_field() {
    WebElement phonenumber = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
    phonenumber.sendKeys("4567891223");
}
@When("To enter email in mail address field")
public void to_enter_email_in_mail_address_field() {
    WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));  
    email.sendKeys("inmakes@gmail.com");
}
@When("To select type of services")
public void to_select_type_of_services() {
    WebElement typeofservices = driver.findElement(By.id("form-field-field_a5209a9"));
    Select s = new Select(typeofservices);
    s.selectByVisibleText("want to buy your products");
    
}
@When("To enter the location in location field")
public void to_enter_the_location_in_location_field() {
    WebElement location = driver.findElement(By.xpath("//input[@placeholder='Country Name']"));
    location.sendKeys("India");
}
@When("To enter the message in message field")
public void to_enter_the_message_in_message_field() throws InterruptedException, IOException {
    WebElement message = driver.findElement(By.xpath("//textarea[@placeholder='Message']"));
    message.sendKeys("We need your products in wholesale");
	Thread.sleep(3000);
	ts = (TakesScreenshot) driver;
	File s = ts.getScreenshotAs(OutputType.FILE);
	File f = new File("C:\\Users\\ajay4\\eclipse-workspace\\ScentWebSiteTest\\ScreenShots\\contactformfilled.png");
	FileUtils.copyFile(s, f);
}

@When("To click send button")
public void to_click_send_button() throws InterruptedException, IOException {
	 WebElement send = driver.findElement(By.xpath("//span[contains(text(),'Send')]"));
	 send.click();
	 Thread.sleep(3000);
     ts = (TakesScreenshot) driver;
	 File s = ts.getScreenshotAs(OutputType.FILE);
	 File f = new File("C:\\Users\\ajay4\\eclipse-workspace\\ScentWebSiteTest\\ScreenShots\\contactformsent.png");
	 FileUtils.copyFile(s, f);
}




@Then("To close the browser")
public void to_close_the_browser() {
   driver.close();
}


}
