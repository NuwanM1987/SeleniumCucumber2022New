package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObejects.AddCustomerPage;
import pageObejects.LoginPage;
import pageObejects.SearchCustomerPage;

import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage ac;
    public SearchCustomerPage searchCust;
    public static Logger logger;
    public Properties configProp;

    //creating random string for email
    public static String randomString(){
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return generatedString1;
    }
}
