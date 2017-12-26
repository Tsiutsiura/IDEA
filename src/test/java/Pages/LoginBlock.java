package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBlock {
    By loginLocator = By.xpath("//input[@id = 'login_email']");
    By passwordLocator = By.xpath("//input[@id = 'pass']");
    By submitButtonLocator = By.xpath("//button[@type = 'submit']");


    private final WebDriver driver;

    public LoginBlock (WebDriver driver) {
        this.driver = driver;
    }

    public LoginBlock typeLogin(String login) {
        driver.findElement(loginLocator).sendKeys(login);
        return this;
    }
    public LoginBlock typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }
    public LoginBlock submitLoginBlock() {
        driver.findElement(submitButtonLocator).submit();
        return new LoginBlock(driver);
    }
}
