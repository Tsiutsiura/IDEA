package MaxPay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
    private final WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    private final String URL = "https://my.maxpay.com/#/signup";
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By confirmPasswordLocator = By.id("confirm");
    private By agreeTermsLocator = By.xpath("//input[@name = 'agreeTos']");
    private By agreeEmailLocator = By.name("agreeEmail");
    /*private By agreeTermsCheckboxLocator = By.xpath("//*[@class ='css-input.css-checkbox.css-checkbox-primary']//span");*/
    private By agreeTermsCheckboxLocator = By.xpath("//*[@class='css-input.css-checkbox.css-checkbox-primary']]//span[@text()='I agree with']");
    private By agreeEmailCheckboxLocator = By.xpath("//label[@class='css-input css-checkbox css-checkbox-primary ng-binding']/span");
    private By agreeCookiesCheckboxLocator = By.xpath("//label[@class='css-input css-checkbox css-checkbox-primary ng-binding']/span");
    private By agreeCookiesLocator = By.name("agreeCookies");

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

    public By getAgreeTermsLocator() {
        return agreeTermsLocator;
    }

    public By getAgreeEmailLocator() {
        return agreeEmailLocator;
    }

    public By getAgreeCookiesLocator() {
        return agreeCookiesLocator;
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
        if (!driver.findElement(agreeTermsLocator).isSelected()) {
            driver.findElement(agreeTermsCheckboxLocator).click();
        }
        return this;
    }

    public SignUp agreeEmail() {
        if (!driver.findElement(agreeEmailLocator).isSelected()) {
            driver.findElement(agreeEmailCheckboxLocator).click();

        }
        return this;
    }

    public SignUp agreeCookies() {
        if (!driver.findElement(agreeCookiesLocator).isSelected()) {
            driver.findElement(agreeCookiesCheckboxLocator).click();
        }
        return this;
    }
    public SignUp submitButton (){
        driver.findElement(submitButtonLocator).click();
        return this;
    }
}
