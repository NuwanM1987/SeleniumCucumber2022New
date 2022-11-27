package pageObejects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
    }
    By linkCustomers_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
    By linkCustomers_menuitem = By.xpath("//li[4]/ul/li[1]/a/p");
    By btnAddCustomer = By.xpath("//form[1]/div/div/a");

    By txtEmail= By.xpath("//input[@id='Email']");
    By txtPassword = By.id("Password");
    By txtFirstName = By.name("FirstName");
    By txtLastName = By.name("LastName");
    By radioGenderMale = By.id("Gender_Male");
    By radioGenderFeMale = By.id("Gender_Female");
    By txtDateOfBirth = By.name("DateOfBirth");
    By txtCompanyName = By.name("Company");
    By chkTxExcempt = By.id("IsTaxExempt");
    By dropDownNewsLetter = By.xpath("//nop-card/div/div[2]/div[9]/div[2]/div/div[1]/div/div");

    By txtCustomerRole = By.xpath("//nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div/input");
    By listItemAdministrator = By.xpath("//li[contains(text(),'Administrators')]");
    By listItemForumModerator = By.xpath("//li[contains(text(),'Forum Moderators')]");
    By listItemRegistered = By.xpath("//li[contains(text(),'Registered')]");
    By listVendor = By.xpath("//li[contains(text(),'Vendors')]");
    By listGuest = By.xpath("//li[contains(text(),'Guests')]");
    By MagrOfVendor = By.xpath("//nop-cards/nop-card/div/div[2]/div[11]/div[2]/span");
    By chkActive = By.id("Active");
    By txtAdminComment = By.id("AdminComment");

    By btnSave = By.name("save");

    //Action Methods
    public String getPageTitle(){
        return ldriver.getTitle();
    }

    public void clickOnCustomerMenu(){
        ldriver.findElement(linkCustomers_menu).click();
    }
    public void clickOnCustomerMenuItem(){
        ldriver.findElement(linkCustomers_menuitem).click();
    }
    public void clickOnAddNew(){
        ldriver.findElement(btnAddCustomer).click();
    }

    public void setEmail(String email){
        ldriver.findElement(txtEmail).sendKeys(email);
    }
    public void setPassword(String password){
        ldriver.findElement(txtPassword).sendKeys(password);
    }
    public void setCustomerRoles(String role) throws InterruptedException {
        if(!role.equals("Vendors")){
            ldriver.findElement(By.xpath("//nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div/ul/li/span[2]")).click();
        }
        ldriver.findElement(txtCustomerRole).click();
        WebElement listElement;
        Thread.sleep(3000);
        if (role.equals("Administrators")){
            listElement = ldriver.findElement(listItemAdministrator);
        }
        else if (role.equals("Registered")){
            listElement = ldriver.findElement(listItemRegistered);
        }
        else if (role.equals("Vendors")){
            listElement = ldriver.findElement(listVendor);
        }
        else if  (role.equals("Guests")){
            listElement = ldriver.findElement(listGuest);}
        else
        {
            listElement = ldriver.findElement(listItemForumModerator);
        }
        Thread.sleep(3000);
       // listElement.click();
        JavascriptExecutor js = (JavascriptExecutor)ldriver ;
        js.executeScript("arguments[0].click()",listElement);
    }

    public void setManagerOfVendor(String value){
            Select s = new Select(ldriver.findElement(MagrOfVendor));
            s.selectByValue(value);

    }

    public void setGender(String gender){
        if(gender.equals("Male")){
            ldriver.findElement(radioGenderMale).click();
        }
        else if (gender.equals("Female")){
            ldriver.findElement(radioGenderFeMale).click();
        }
        else if (gender.equals("default")){
            ldriver.findElement(radioGenderMale).click();
        }

    }
    public void setFirstName(String fname){
        ldriver.findElement(txtFirstName).sendKeys(fname);
    }

    public void setLasttName(String lname){
        ldriver.findElement(txtLastName).sendKeys(lname);
    }
    public void setDOB(String dob){
        ldriver.findElement(txtDateOfBirth).sendKeys(dob);
    }
    public void setCompanytName(String comname){
        ldriver.findElement(txtCompanyName).sendKeys(comname);
    }
    public void setAdminContent(String admincontent){
        ldriver.findElement(txtAdminComment).sendKeys(admincontent);
    }

    public void clickOnSave(){
        ldriver.findElement(btnSave).click();
    }


}
