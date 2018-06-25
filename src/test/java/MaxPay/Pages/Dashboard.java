package MaxPay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    private final WebDriver driver;


    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    private By controlLocator = By.xpath("//span[text() = 'Объем']");

    public By getControlLocator() {
        return controlLocator;
    }
}
