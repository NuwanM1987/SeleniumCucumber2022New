package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import pageObejects.AddCustomerPage;
import pageObejects.LoginPage;
import pageObejects.SearchCustomerPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Steps extends BaseClass{

    WebDriver driver;
    AddCustomerPage addcus;
    LoginPage lp ;

     @Before //this is cucumber annotation so need to setup method in Step class in cucumber
    public void setup() throws IOException {
        logger = logger.getLogger("SeleniumCucumber2022"); //Added logger
        PropertyConfigurator.configure("log4j.properties");
        // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        //Reading properties
        configProp = new Properties();
        FileInputStream configpropfile = new FileInputStream("config.properties");
        configProp.load(configpropfile);

        String br = configProp.getProperty("browser");
        if ((br.equals("chrome"))){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox")){
          //  System.setProperty("webdriver.geckodriver",configProp.getProperty(""));
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }
        else if(br.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }
        else if(br.equals("opera")){
            WebDriverManager.operadriver().setup();
            driver= new OperaDriver();
        }

        logger.info("*** Launching browser ***");
    }

    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
               lp = new LoginPage(driver);

    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) throws InterruptedException {
        logger.info("*** Launching URL ***");
        driver.get(url); //url will get from feature file
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }
  @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
      LoginPage lp = new LoginPage(driver);
               Thread.sleep(3000);
                lp.setEmail(email);
                Thread.sleep(2000);
                lp.setPassword(password);
        Thread.sleep(2000);
    }


    @When("Click on Login")
    public void click_on_login() throws InterruptedException {
        logger.info("*** Click login ***");
        LoginPage lp = new LoginPage(driver);
                lp.clickLogin();
                Thread.sleep(3000);
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }
        else
        {
            Assert.assertEquals(title,driver.getTitle());
        }
    }
    @When("User click on Logout Link")
    public void user_click_on_logout_link() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.clickLogout();
        Thread.sleep(3000);


    }
    @Then("Close the browser")
    public void close_the_browner() {
        driver.close();
    }

    //Customer Feature Step Definitions
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addcus = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addcus.getPageTitle());

    }
    @When("User click on Customer menu")
    public void user_click_on_customer_menu() throws InterruptedException {
        Thread.sleep(3000);
        addcus.clickOnCustomerMenu();

    }
    @When("click on customer's menu item")
    public void click_on_customer_s_menu_item() throws InterruptedException {
        Thread.sleep(3000);
        addcus.clickOnCustomerMenuItem();

    }
    @When("click on Add new")
    public void click_on_add_new() throws InterruptedException {
        Thread.sleep(3000);
        addcus.clickOnAddNew();
        Thread.sleep(2000);

    }
    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addcus.getPageTitle());

    }
    @When("user enter customer infor")
    public void user_enter_customer_infor() throws InterruptedException {
        logger.info("*** Adding new customer ***");
        String email = randomString()+"@gmail.com";
        addcus.setEmail(email);
        addcus.setPassword("abc123");
        addcus.setFirstName("Nuwan");
        addcus.setLasttName("Maduranga");
        addcus.setGender("Male");
        addcus.setDOB("11/09/1988");
        Thread.sleep(2000);
        addcus.setCompanytName("Testcomp1");
        addcus.setCustomerRoles("Guests");
        Thread.sleep(2000);
        addcus.setAdminContent("This is testing 123");
        Thread.sleep(2000);
    }



    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
        logger.info("*** Saving customer information ***");
        addcus.clickOnSave();
        Thread.sleep(2000);

    }
    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        logger.info("*** Customer added successful ***");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));


    }
    @Then("close browser")
    public void close_browser() {
       driver.close();

    }
    //Steps for Serach customer by EmailId
    @When("Enter Customer Email")
    public void enter_customer_email() {
        searchCust = new SearchCustomerPage(driver);
        searchCust.setEmail("james_pan@nopCommerce.com");
           }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCust.clickSearch();
        Thread.sleep(5000);

    }
    @Then("User should found email in User table")
    public void user_should_found_email_in_user_table() {
        boolean status = searchCust.SearchCustomerByEmail("james_pan@nopCommerce.com");
        Assert.assertEquals(true,status);
    }
    //Steps for Serach customer by FirstName and Last Name
    @When("Enter Customer First Name")
    public void enter_customer_first_name() {
        searchCust = new SearchCustomerPage(driver);
        searchCust.setFirstName("James");
    }
    @When("Enter Customer Last Name")
    public void enter_customer_last_name() {
        searchCust.setLastname("Pan");
    }
    @Then("User should found name  in User table")
    public void user_should_found_name_in_user_table() {
        boolean status1 = searchCust.SearchCustomerByName("James Pan");
        Assert.assertEquals(true,status1);

    }




}
