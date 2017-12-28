package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    By logOutButtonLocator = By.linkText("LogOut");


    private final WebDriver driver;

    public Dashboard (WebDriver driver) {
        this.driver = driver;
    }

    public Dashboard logOutFromCustomerProfile() {
        driver.findElement(logOutButtonLocator).click();
        return this;
    }
}
