package MaxPay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginPage_MP {

   
    By emailLocator = By.id("login-email");
    By passwordLocator = By.id("login-password");
    By submitButtonLocator = By.xpath("//button[@class = 'btn btn-block btn-primary mheight-40 text-uppercase ng-binding']");


    private final WebDriver driver;

    public LoginPage_MP(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage_MP typeEmail(String email) {
        driver.findElement(emailLocator).click();
        driver.findElement(emailLocator).sendKeys(email);

        return this;
    }
    public LoginPage_MP typePassword(String password) {
        driver.findElement(passwordLocator).click();
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }
    public Dashboard_MP submitLoginPage() {
        driver.findElement(submitButtonLocator).click();
        return new Dashboard_MP(driver);
    }
}
