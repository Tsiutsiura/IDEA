package MaxPay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class SignUp {
    private final WebDriver driver;
    private Actions action;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        action =  new Actions(driver);
    }


    private final String URL = "https://my.maxpay.com/#/signup";
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By confirmPasswordLocator = By.id("confirm");
    private By agreeTermsCheckboxLocator = By.xpath("//span[@class='ng-binding']");
    private By agreeEmailCheckboxLocator = By.xpath("//input[@type='checkbox'][@name='agreeEmail']");
    private By agreeCookiesCheckboxLocator = By.xpath("//input[@type='checkbox'][@name='agreeCookies']");
    private By submitButtonLocator = By.tagName("button");

    public String getURL() {
        return URL;
    }

    public By getEmailLocator() {
        return emailLocator;
    }

    public By getPasswordLocator() {
        return passwordLocator;
    }

    public By getConfirmPasswordLocator() {
        return confirmPasswordLocator;
    }

    public By getSubmitButtonLocator() {
        return submitButtonLocator;
    }

    public By getAgreeTermsCheckboxLocator() {
        return agreeTermsCheckboxLocator;
    }

    public By getAgreeEmailCheckboxLocator() {
        return agreeEmailCheckboxLocator;
    }

    public By getAgreeCookiesCheckboxLocator() {
        return agreeCookiesCheckboxLocator;
    }

    public SignUp enterEmail(String s) {
        driver.findElement(emailLocator).click();
        driver.findElement(emailLocator).sendKeys(s);
        return this;
    }
    public SignUp enterPassword(String s) {
        driver.findElement(passwordLocator).click();
        driver.findElement(passwordLocator).sendKeys(s);
        return this;
    }
    public SignUp enterConfirmPassword(String s) {
        driver.findElement(confirmPasswordLocator).click();
        driver.findElement(confirmPasswordLocator).sendKeys(s);
        return this;
    }
    public SignUp agreeTerms() {
       /* if (!driver.findElement(agreeTermsCheckboxLocator).isSelected()) {}*/

       action.moveToElement(driver.findElement(agreeTermsCheckboxLocator)).click().perform();

        return this;
    }
    public SignUp agreeEmail() {
       /* if (!driver.findElement(agreeEmailLocator).isSelected()) {}*/
        action.moveToElement(driver.findElement(agreeEmailCheckboxLocator)).doubleClick().perform();


        return this;
    }
    public SignUp agreeCookies() {
       /* if (!driver.findElement(agreeCookiesLocator).isSelected()) {}*/
        action.moveToElement(driver.findElement(agreeCookiesCheckboxLocator)).click().perform();

        return this;
    }
    public SignUp submitForm(){
        driver.findElement(submitButtonLocator).click();
        return this;
    }
}
