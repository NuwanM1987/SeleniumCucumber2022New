package utilities;

import org.joda.time.Seconds;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class WaitHelper {

    public WebDriver driver;

    public WaitHelper(WebDriver driver){
        //Create constructor with webdriver so when object is created of this class Web driver will be initiated
           this.driver= driver;
    }


   public void waitUntil(WebElement element, long timeInSeconds) {
       WebDriverWait waitq = new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
        waitq.until(ExpectedConditions.visibilityOf(element));

    }

}
