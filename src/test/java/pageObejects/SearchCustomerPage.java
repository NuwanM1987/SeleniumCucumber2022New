package pageObejects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {

    WebDriver ldriver;
    WaitHelper waitHelper;

    public SearchCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(ldriver,this);
        waitHelper = new WaitHelper(ldriver);
    }

    @FindBy(how = How.ID,using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.NAME,using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how =How.ID,using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(how = How.ID,using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement drpdobMonth;

    @FindBy(how = How.ID,using = "SearchDayOfBirth")
    @CacheLookup
    WebElement drpdobDay;

    @FindBy(how = How.ID,using = "SearchCompany")
    @CacheLookup
    WebElement txtCompany;

    @FindBy(how = How.XPATH,using = "//section/div/div/div/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[2]/div")
    @CacheLookup
    WebElement txtCustomerRole;

    @FindBy(how = How.XPATH,using = "/html/body/div[4]/div/div[2]/ul/li[1]")
    @CacheLookup
    WebElement txtAdministrator;

    @FindBy(how = How.ID,using = "search-customers")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']")
      WebElement table;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;

    public void setEmail(String email){
        waitHelper.waitUntil(txtEmail,20);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }
    public void setFirstName(String firstname){
        waitHelper.waitUntil(txtFirstName,20);
        txtFirstName.clear();
        txtFirstName.sendKeys(firstname);
    }
    public void setLastname(String lastname){
        waitHelper.waitUntil(txtLastName,20);
        txtLastName.clear();
        txtLastName.sendKeys(lastname);
    }
    public void clickSearch(){
        waitHelper.waitUntil(btnSearch,20);
        btnSearch.click();

    }
    public int getNoOfRows(){
        return (tableRows.size());
    }
    public int getNoOfColumns(){
        return (tableColumns.size());
    }
    public boolean SearchCustomerByEmail(String email){
        boolean flag = false;

        for(int i=1;i<=getNoOfRows();i++){
            //Here we get email columns of earch rows - so in table dynamic xpath we have to give - rows are different columns same
            String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println(emailId);
            if(emailId.equals(email))
            {
                flag = true;
            }
        }

        return flag;
    }
    public boolean SearchCustomerByName(String name){
        boolean flag = false;

        for(int i=1;i<=getNoOfRows();i++){
            //Here we get email columns of earch rows - so in table dynamic xpath we have to give - rows are different columns same
            String Name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
            String names[] = Name.split(" ");//seperating fname and lname
            if(names[0].equals("James")&&names[1].equals("Pan"))
            {
                flag = true;
            }
        }

        return flag;
    }

}
