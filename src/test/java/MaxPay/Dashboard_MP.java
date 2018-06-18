package MaxPay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard_MP {

    private final WebDriver driver;


    public Dashboard_MP(WebDriver driver) {
        this.driver = driver;
    }

    private By controlLocator = By.xpath("//span[text() = 'Объем']");

    public By getControlLocator() {
        return controlLocator;
    }
}
