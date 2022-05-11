package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitle;

    @FindBy(xpath = "//input[@id='location']")
    WebElement location;

    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDown;

    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;

    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;

    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;

    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;

    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;

    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;

    @FindBy(xpath = "//iframe[@id='gdpr-consent-notice']")
    WebElement acceptIFrame;


    public void enterJobTitle(String jobtitle){
        Reporter.log("Enter job Title:" + jobTitle.toString() + "<br>");
        sendTextToElement(jobTitle,jobtitle);
    }

    public void enterLocation(String loc){
        Reporter.log("Enter location:" + location.toString() + "<br>");
        sendTextToElement(location,loc);
    }

    public void selectDistance(String distance)
    {
        Reporter.log("select distance:" + distanceDropDown.toString() + "<br>");
        selectByVisibleTextFromDropDown(distanceDropDown,distance);
    }

    public void clickOnMoreSearchOptionLink(){
        Reporter.log("click on  more search option:" + moreSearchOptionsLink.toString() + "<br>");
        clickOnElement(moreSearchOptionsLink);
    }

    public void enterMinSalary(String minSalary)
    {
        sendTextToElement(salaryMin,minSalary);
    }

    public void enterMaxSalary(String maxSalary){
        sendTextToElement(salaryMax,maxSalary);
    }

    public void selectSalaryType(String sType){
        selectByVisibleTextFromDropDown(salaryTypeDropDown,sType);
    }

    public void selectJobType(String jobType){
        selectByVisibleTextFromDropDown(jobTypeDropDown,jobType);
    }

    public void clickOnFindJobsButton(){
        clickOnElement(findJobsBtn);
    }




    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptCookiesButton;

    public void acceptCookies(){
        driver.switchTo().frame(acceptIFrame);
        clickOnElement(acceptCookiesButton);
    }


}
