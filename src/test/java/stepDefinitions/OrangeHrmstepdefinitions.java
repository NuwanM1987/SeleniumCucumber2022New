package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;


public class OrangeHrmstepdefinitions {

    WebDriver driver;
    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
       // System.setProperty("webdriver.chromedriver","D://NuwanM//AutomationScripts//SeleniumCucumber2022//src//main//resources//Drivers//chromedriver.exe");
       WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();

    }
    @When("I Open Orange Hrm home page")
    public void i_open_orange_hrm_home_page() {
        driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/validateCredentials");

    }
    @Then("I verify that the logo is present on page")
    public void i_verify_that_the_logo_is_present_on_page() {
          boolean status = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img")).isDisplayed();
          Assert.assertEquals(true,status);
    }
    @Then("I close the browser")
    public void i_close_the_browser() {
            driver.quit();
    }

}
