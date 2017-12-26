package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginPage {

    By titlePageLocator = By.xpath( "//div[@class = 'title_text']");
    By loginLocator = By.xpath("//li//input[@name = 'email']");
    By passwordLocator = By.xpath("//li//input[@name = 'pass']");
    By submitButtonLocator = By.xpath("//form//input[@id = 'submit']");



    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage checkIsItLoginPage (String title){
        assertEquals("This is not the login page", title, driver.findElement(titlePageLocator).getText());
        return this;
    }

    public LoginPage typeLogin(String login) {
        driver.findElement(loginLocator).sendKeys(login);
        return this;
    }
    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }
    public HomePage submitLoginPage() {
        driver.findElement(submitButtonLocator).click();
        return new HomePage(driver);
    }


}
