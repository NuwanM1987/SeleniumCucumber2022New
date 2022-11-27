package pageObejects;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver lDriver;

    public LoginPage(WebDriver rDriver){
        lDriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(id="Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//form/div[3]/button")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement btnLogout;

    public void setEmail(String email){
        txtEmail.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        txtEmail.clear();
        txtEmail.sendKeys(email);

    }

    public void setPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);

    }
    public void clickLogin(){
        btnLogin.click();
    }
    public void clickLogout(){
        btnLogout.click();
    }

}
